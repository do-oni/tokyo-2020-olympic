package olympic.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import olympic.controller.OlympicController;

public class RunningStartView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("***** 2020 도쿄 올림픽 결과는? *****");
		System.out.println("***** 개막식 : 2021.07.23 *****");
		System.out.println("***** 폐막식 : 2021.08.08 *****\n");
		System.out.println("~~~~~ 기능 목록 ~~~~~");
		System.out.println(" 1 : 모든 올림픽 정보" 
					   + "\n 2 : 올림픽 참전 국가 목록" 
					   + "\n 3 : 특정 국가 총 메달 수" 
					   + "\n 4 : 특정 종목 정보"		
					   + "\n 5 : 특정 선수 정보" 
					   + "\n 6 : 특정 선수 번호로 선수명 수정" 
					   + "\n 7 : 메달 스코어로 랭킹 검색 " 
					   + "\n 8 : 검색 수가 많은 선수 출력"
					   + "\n 9 : 검색 그만");
		
		boolean sessionEnd = false;
		
		while (!sessionEnd) {
			
			try {
				System.out.println("메뉴 번호를 입력해주세요");
				
				int num = sc.nextInt();
				
				if(num == 1) {
					System.out.println("***모든 올림픽 정보 ***");
					OlympicController.getAllOlympic();
				} else if(num == 2) {
					System.out.println("\n***모든 올림픽 참전 국가***");
					OlympicController.getCountries();
				} else if(num == 3) {
					sc.nextLine();
					System.out.println("\n***특정 국가 모든 메달 수***");
					System.out.println("\n***국가를 입력하세요***");
					String country = sc.nextLine();
					OlympicController.getMedalCnt(country);
				} else if(num == 4) {
					sc.nextLine();
					System.out.println("\n***특정 종목 정보***");
					System.out.println("\n***국가를 입력하세요***");
					String country = sc.nextLine();
					System.out.println("\n***종목을 입력하세요 ***");
					String sportname = sc.nextLine();
					OlympicController.getSport(country, sportname);
				} else if(num == 5) {
					sc.nextLine();
					System.out.println("\n***특정 선수 정보***");
					System.out.println("\n***국가를 입력하세요***");
					String country = sc.nextLine();
					System.out.println("\n***선수를 입력하세요 ***");
					String name = sc.nextLine();
					OlympicController.getPlayer(country, name);
				} else if(num == 6) {
					sc.nextLine();
					System.out.println("\n***특정 선수 번호로 선수명 수정***");
					System.out.println("\n***선수번호를 입력하세요***");
					int playernum = sc.nextInt();
					sc.nextLine();
					System.out.println("\n***이름을 수정해주세요 ***");
					String name = sc.nextLine();
					OlympicController.updatePlayer(name, playernum);
					System.out.println("\n***수정된 선수 이름***");
					OlympicController.getOnePlayer(name);
				} else if(num == 7) {
					System.out.println("\n***메달 스코어로 랭킹 검색***");
					OlympicController.getMedalScore();
				} else if(num == 8) {
					System.out.println("\n***제일 많이 검색된 선수출력***");
					OlympicController.searchLog();
				}  else if(num == 9) {
					sc.close();
					System.out.println("\n***검색 종료***");
					sessionEnd = true;
				}else {
					System.out.println("다시 입력해 주세요");
				}
			} catch(InputMismatchException e) {
				System.out.println("숫자가 아닌 값을 입력했습니다.");
				sc.next();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("");
				sc.next();
			}
		}
	}
}