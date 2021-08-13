package olympic.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

import olympic.model.dto.OlympicDTO;
import olympic.model.dto.PlayerDTO;
import olympic.model.util.DBUtil;
import olympic.view.RunningEndView;

public class OlympicDAO {
	
	private static Properties sql = DBUtil.getSql();

	//올림픽 정보 추가
	public static boolean addOlympic(OlympicDTO olympic) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addOlympic"));
				
			pstmt.setInt(1, olympic.getOlympicId());
			pstmt.setString(2, olympic.getCountry());
			pstmt.setString(3, olympic.getSportName());
			pstmt.setInt(4, olympic.getPlayerNumber());
				
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//올림픽 id로 올림픽 종목 수정
	public static boolean updateOlympic(int olympicId, String sportName) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
				
			pstmt = con.prepareStatement(sql.getProperty("updateOlympic"));
			pstmt.setInt(1, olympicId);
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

	//올림픽 정보 삭제
	public static boolean deleteOlympic(int olympicId) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteOlympic"));
			pstmt.setInt(1, olympicId);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//올림픽 id로 올림픽 정보 반환
	public static OlympicDTO getOlympic(int olympicId) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OlympicDTO olympic = null;
			
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getOlympic"));
			pstmt.setInt(1, olympicId);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				olympic = new OlympicDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return olympic;
	}

	//모든 올림픽 정보 반환
	public static ArrayList<OlympicDTO> getAllOlympic() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OlympicDTO> list = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllOlympic"));
			rset = pstmt.executeQuery();
			list = new ArrayList<OlympicDTO>();
			
			while(rset.next()){
				list.add(new OlympicDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4),rset.getString(5)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}