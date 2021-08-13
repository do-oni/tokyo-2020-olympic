package olympic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import olympic.model.dto.SportDTO;
import olympic.model.util.DBUtil;
import olympic.view.RunningEndView;

public class SportDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	//종목 정보 추가
	public static boolean addSport(SportDTO sport) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addSport"));
			pstmt.setString(1, sport.getSportName());
			pstmt.setString(2, sport.getCountry());
			pstmt.setInt(3, sport.getTotalMedal());
							
			int result = pstmt.executeUpdate();
						
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
				
	//국가 이름으로 종목 이름 변경
	public static boolean updateSport(String country, String sportName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
							
			pstmt = con.prepareStatement(sql.getProperty("updateSport"));
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

	//종목 정보 삭제
	public static boolean deleteSport(String country, String sportName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteSport"));
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
				
	//특정 국가의 종목 이름으로 선수 정보 반환
	public static SportDTO getSport(String country, String sportName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SportDTO sport = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getSport"));
			pstmt.setString(1, country);
			pstmt.setString(2, sportName);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				sport = new SportDTO(rset.getString(1), rset.getString(2), rset.getInt(3));
			}
		
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return sport;
	}

	//모든 종목 정보 반환
	public static ArrayList<SportDTO> getAllSport() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SportDTO> list = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllSport"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SportDTO>();
			
			while(rset.next()){
				list.add(new SportDTO(rset.getString(1), rset.getString(2), rset.getInt(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}