package olympic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import olympic.exception.NotExistException;
import olympic.model.dto.MedalDTO;
import olympic.model.util.DBUtil;

public class MedalDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	//메달 정보 추가
	public static boolean addMedal(MedalDTO medal) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addOlympic"));
					
			pstmt.setString(1, medal.getMedalId());
			pstmt.setString(2, medal.getCountry());
			pstmt.setString(3, medal.getSportName());
			pstmt.setInt(4, medal.getGMedal());
			pstmt.setInt(5, medal.getSMedal());
			pstmt.setInt(6, medal.getBMedal());
					
			int result = pstmt.executeUpdate();
				
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
		
	//메달 정보 수정
	public static boolean updateMedal(String country, String sportName) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateMedal"));
			pstmt.setString(1, country);
			pstmt.setString(2, sportName);
					
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//특정 종목의 메달 정보 삭제
	public static boolean deleteMedal(String sportName) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteMedal"));
			pstmt.setString(1, sportName);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
		
	//모든 메달 정보 반환
	public static ArrayList<MedalDTO> getAllMedal() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MedalDTO> list = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllMedal"));
			rset = pstmt.executeQuery();
			list = new ArrayList<MedalDTO>();
			
			while(rset.next()){
				list.add(new MedalDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getInt(6)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
