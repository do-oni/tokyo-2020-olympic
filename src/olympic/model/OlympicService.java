package olympic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.Set;

import olympic.exception.NotExistException;
import olympic.model.dto.OlympicDTO;
import olympic.model.dto.PlayerDTO;
import olympic.model.dto.SportDTO;
import olympic.model.util.DBUtil;

public class OlympicService {

	private static Properties sql = DBUtil.getSql();
	private static OlympicService instance = new OlympicService();
	static Logger logger = Logger.getLogger("olympic.view.PlayerDAO");

	private OlympicService() {
	};

	public static OlympicService getInstance() {
		return instance;
	}

	// 1. 모든 올림픽 정보 반환
	public static ArrayList<OlympicDTO> getAllOlympic() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OlympicDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllOlympic"));
			rset = pstmt.executeQuery();
			list = new ArrayList<OlympicDTO>();

			while (rset.next()) {
				list.add(new OlympicDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4),
						rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// 2. 올림픽 참전 국가 목록
	public static HashSet<String> getAllCountryHS() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashSet<String> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllCountry"));
			rset = pstmt.executeQuery();
			list = new HashSet<String>();

			while (rset.next()) {
				list.add((rset.getString("COUNTRY")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// 3. 특정 국가 총 메달 수
	public static ArrayList<String> getMedalCnt(String country) throws SQLException, NotExistException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> totalMedal = new ArrayList<>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getMedalCnt"));
			pstmt.setString(1, country);
			rset = pstmt.executeQuery();

			int gSum;
			int sSum;
			int bSum;

			if (rset.next()) {
				// 점수 환산
				gSum = rset.getInt(2) * 5;
				sSum = rset.getInt(3) * 3;
				bSum = rset.getInt(4) * 1;

				int sumMedal = gSum + sSum + bSum;

				totalMedal.add(0, rset.getString(1));
				totalMedal.add(1, String.valueOf(rset.getInt(2)));
				totalMedal.add(2, String.valueOf(rset.getInt(3)));
				totalMedal.add(3, String.valueOf(rset.getInt(4)));
				totalMedal.add(4, String.valueOf(sumMedal));
			} else {
				throw new NotExistException("국가 정보가 없습니다");
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return totalMedal;
	}

	// 4. 특정 종목 정보
	public static SportDTO getSport(String country, String sportName) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SportDTO sport = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getSport"));
			pstmt.setString(1, country);
			pstmt.setString(2, sportName);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				sport = new SportDTO(rset.getString(1), rset.getString(2), rset.getInt(3));
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return sport;
	}

	// 5. 특정 선수 정보
	public static void getPlayer(String country, String name) throws SQLException, NotExistException {
		PlayerDAO.getPlayer(country, name);
	}

	// 6. 특정 선수 번호로 선수명 수정
	public static boolean updatePlayer(String name, int playerNum) throws SQLException, NotExistException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			// player table 수정
			pstmt = con.prepareStatement(sql.getProperty("updatePlayer"));
			pstmt.setString(1, name);
			pstmt.setInt(2, playerNum);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			} else {
				throw new NotExistException("특정 선수 번호로 선수명 수정 실패");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
//			return false;
	}

	// 6-1. 선수 이름 수정 후 결과 반환
	public static PlayerDTO getOnePlayer(String name) throws SQLException, NotExistException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PlayerDTO player = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getPlayerName"));
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				logger.info(rset.getString(2));
				player = new PlayerDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4),
						rset.getString(5));
			} else {
				throw new NotExistException("선수 정보가 없습니다");
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return player;
	}

	// 7. 메달 스코어로 랭킹 검색
	public static HashMap<Integer, String[]> getMedalScore() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<Integer, String[]> totalMedal = new HashMap<Integer, String[]>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getMedalScore"));
			rset = pstmt.executeQuery();

			while (rset.next()) {
				String[] temp = new String[3];
				temp[0] = rset.getString(1);
				temp[1] = rset.getString(2);
				temp[2] = Integer.toString(rset.getInt(3));
				totalMedal.put(rset.getInt("rank"), temp);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return totalMedal;
	}

	// 8. 검색 수가 많은 선수 출력
	public static void searchLog() throws NotExistException {

		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader("C:\\20210628_lab\\88.log\\olympicPlayer.log"));
			String data = null;
			ArrayList<String> rank = new ArrayList<>();

			while ((data = in.readLine()) != null) {
				rank.add(data);
			}

			Set<String> set = new HashSet<String>(rank);
			HashMap<String, Integer> hm = new HashMap<>();

			for (String str : set) {
				hm.put(str, Collections.frequency(rank, str));
			}
			Entry<String, Integer> maxEntry = null;
			Set<Entry<String, Integer>> entrySet = hm.entrySet();

			for (Entry<String, Integer> entry : entrySet) {
				if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
					maxEntry = entry;
				}
			}
			System.out.println(maxEntry.getKey() + " : " + maxEntry.getValue());

		} catch (Exception e) {
			throw new NotExistException();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public OlympicDTO getOlympic(int olympicId) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OlympicDTO olympic = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getOlympic"));
			pstmt.setInt(1, olympicId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				olympic = new OlympicDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4),
						rset.getString(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return olympic;
	}
}