package olympic.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import olympic.exception.NotExistException;
import olympic.model.MedalDAO;
import olympic.model.OlympicService;
import olympic.model.dto.MedalDTO;
import olympic.model.dto.OlympicDTO;
import olympic.model.dto.PlayerDTO;
import olympic.model.dto.SportDTO;

public class RunningEndView {
	
	static OlympicService service = OlympicService.getInstance();

	public static void olympicListView(ArrayList allOlympic) {
		if (allOlympic != null) {
			int length = allOlympic.size();

			if (length != 0) {
				
				for (int index = 0; index < length; index++) {
					System.out.println("검색정보 " + (index + 1) + " - " + allOlympic.get(index));
				}
			} else {
				System.out.println("요청하신 올림픽 정보는 존재하지 않습니다.");
			}
		} else {
			System.out.println("요청하신 올림픽 정보는 존재하지 않습니다.");
		}
	}

	// 특정 국가 메달 수 출력
	public static void olympicView(MedalDTO medal) {
		System.out.println(medal);
	}

	// 특정 종목 검색
	public static void olympicView(SportDTO sport) {
		if (sport == null) {
			System.out.println("검색한 종목이 없습니다.");
		} else {
			System.out.println(sport);
		}
	}

	// 특정 선수 검색
	public static void olympicView(PlayerDTO player) {
		System.out.println(player);
	}

	//모든 DTO
	public static void allView(Object data) {
		if (data != null) {
			System.out.println(data);
		} else {
			System.out.println("요청하신 id에 해당하는 정보는 없습니다.");
		}
	}

	// update 성공, 실패시 메세지 출력 -
	public static void updateView(boolean result, String name, int playerNum) {
		if (result) {
			System.out.println("요청하신 " + name + playerNum + " 수정 완료");
		} else {
			System.out.println("요청하신 " + name + " 수정 실패, 다른 이름으로 검색해주세요.");
		}
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}

	public static void countryViewHS(HashSet<String> allCountryHS) {
		if (allCountryHS != null) {
			
			int length = allCountryHS.size();

			if (length != 0) {
				Iterator iter = allCountryHS.iterator();
				int i = 0;
				while (iter.hasNext()) {
					System.out.println("검색정보 " + (i + 1) + " - " + iter.next());
					i++;
				}
			} else {
				System.out.println("요청하신 국가 정보가 없습니다.");
			}
		} else {
			System.out.println("요청하신 국가 정보는 없습니다.");
		}
	}

	public static void olympicView(ArrayList<String> totalMedal) {
		System.out.println("검색하신 국가 " + "'" + totalMedal.get(0) + "'" + "의 메달 획득 현황은 아래와 같습니다.\n" 
								  + "금메달 : " + totalMedal.get(1) + "개\n" 
								  + "은메달 : " + totalMedal.get(2) + "개\n" 
								  + "동메달 : " + totalMedal.get(3)+ "개\n" 
				  + "따라서 해당 국가의 올림픽 총점은 " + totalMedal.get(4) + "점입니다.");
	}

	public static void medalRankView(HashMap<Integer, String[]> medalScore) {
		if (medalScore != null) {
			
			for (Entry<Integer, String[]> entrySet : medalScore.entrySet()) {
				System.out.println(entrySet.getKey() + " : 국가  :" + entrySet.getValue()[0] + ", 종목 : "
						+ entrySet.getValue()[1] + ", 스코어 : " + entrySet.getValue()[2]);
			}
		} else {
			System.out.println("요청하신 메달 랭크 정보가 없습니다.");
		}
	}

	public static OlympicDTO getOlympic(int olympicId) throws SQLException, NotExistException {
		
		OlympicDTO olympic = service.getOlympic(olympicId);
		
		if (olympic == null) {
			throw new NotExistException("검색하신 올림픽 정보가 없습니다.");
		}
		return olympic;
	}
}