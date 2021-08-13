package olympic.controller;

import java.sql.SQLException;

import olympic.exception.NotExistException;
import olympic.model.OlympicService;
import olympic.model.PlayerDAO;
import olympic.view.RunningEndView;

public class OlympicController {
	
	static OlympicService service = OlympicService.getInstance();

	//1. 모든 올림픽 정보 검색
	public static void getAllOlympic() {
		try {
		RunningEndView.olympicListView(service.getAllOlympic());
		}catch(SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 올림픽 정보 검색시 에러 발생");
		}
	}
	
	//2. 올림픽 참전 국가 검색
	public static void getCountries() {
			try {
				RunningEndView.countryViewHS(service.getAllCountryHS());
			}catch(Exception e) {
				RunningEndView.showError("국가 검색시 에러 발생");
			}
	}

	//3. 특정 국가 메달 수 검색
	public static void getMedalCnt(String country) {
		try {
			RunningEndView.olympicView(service.getMedalCnt(country));
		}catch(SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("국가이름으로 메달 수 검색 에러 발생");
		}catch(NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("국가명 혹은 선수명을 다시 입력해 주세요.");
		}
	}
		
	//4. 특정 종목 검색
	public static void getSport(String country, String sport) {
		try {
			RunningEndView.olympicView(service.getSport(country, sport));
		}catch(SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("종목 이름으로 검색 에러 발생");
		}
	}

	//5. 특정 선수 검색
	public static void getPlayer(String country, String name) {
			try {
				RunningEndView.olympicView(PlayerDAO.getPlayer(country, name));
			} catch (NotExistException e) {
				e.printStackTrace();
				RunningEndView.showError("선수 이름을 다시 입력해 주세요.");
			}catch(SQLException e) {
				e.printStackTrace();
				RunningEndView.showError("선수 이름으로 검색 에러 발생");
		}
	}
	
	//6. 특정 선수이름으로 선수번호 수정 
	public static void updatePlayer(String name, int playerNum) {
		try{
			boolean b = service.updatePlayer(name, playerNum);
			RunningEndView.updateView(b, name, playerNum);			
		}catch(SQLException e){
			e.printStackTrace();
			RunningEndView.showError("선수 번호 수정 오류 재시도 하세요.");
		}catch(NotExistException e){
			e.printStackTrace();
			RunningEndView.showError("선수 이름 재 확인 하세요.");
		}
	}
	
	// 선수 이름 수정 결과 검색
	public static void getOnePlayer(String name) {
		try {
			RunningEndView.olympicView(service.getOnePlayer(name));
		}catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("선수 이름으로 검색 에러 발생");
		}catch(NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("선수 이름 재 확인 하세요.");
		}
	}
	
	
	//7. 메달 스코어로 랭킹 검색
	public static void getMedalScore() {
		try {
			RunningEndView.medalRankView(service.getMedalScore());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("스코어 검색 에러");
		}
	
	}

	//8. 검색 수가 많은 선수 출력
	public static void searchLog() {
		try {
			service.searchLog();
		} catch (NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("파일이 존재하지 않습니다.");
		}
	}	
}