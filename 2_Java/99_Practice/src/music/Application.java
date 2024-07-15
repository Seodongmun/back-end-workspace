package music;

import java.util.ArrayList; 
import java.util.Scanner;

import music.controller.MusicController;
import music.model.Music;

public class Application {

	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	public static void main(String[] args) {

		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu() {

		boolean check = true;
		while (check) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 가수 명 내림차순 정렬");
			System.out.println("8. 곡 명 오름차순 정렬");
			System.out.println("9. 종료");
			int select = 0;
			try {
			System.out.print("메뉴 번호 입력 : ");
			select = Integer.parseInt(sc.nextLine());
			// 문자 입력시 잘못 입력메세지 출력 (Exception 사용)
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다 다시 입력해주세요");
				mainMenu();
			}
			switch (select) {
//			    1. 마지막 위치에 곡 추가
			case 1:
				menu1();
				break;
//			    2. 첫 위치에 곡 추가
			case 2:
				menu2();
				break;
			case 3:
//				3. 전체 곡 목록 출력
				menu3();
				break;
			case 4:
//				4. 특정 곡 검색
				menu4();
				break;
			case 5:
//				5. 특정 곡 삭제
				menu5();
				break;
			case 6:
//				6. 특정 곡 수정
				menu6();
				break;
			case 7:
//				7. 가수 명 내림차순 정렬
				menu7();
				break;
			case 8:
//				8. 곡 명 오름차순 정렬
				menu8();
				break;
			case 9:
//				9. 종료
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	
//	1. 마지막 위치에 곡 추가
	public void menu1(){
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.println("노래 이름 입력 : ");
		String musicName = sc.nextLine();
		System.out.println("가수 이름 입력 : ");
		String name = sc.nextLine();
		System.out.println(mc.menu1(musicName, name));
	}
	
//	2. 첫 위치에 곡 추가
	public void menu2() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.println("노래 이름 입력 : ");
		String musicName = sc.nextLine();
		System.out.println("가수 이름 입력 : ");
		String name = sc.nextLine();
		System.out.println(mc.menu2(musicName, name));
	}
//	3. 전체 곡 목록 출력
	public void menu3() {
		System.out.println(mc.menu3());
	}
//	4. 특정 곡 검색
	public void menu4() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.println("검색할 곡 입력 : ");
		String serch = sc.nextLine();
		System.out.println(mc.menu4(serch));
	}
//	5. 특정 곡 삭제
	public void menu5() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.println("삭제할 곡 입력 : ");
		String serch = sc.nextLine();
		System.out.println(mc.menu5(serch));
	}
//	6. 특정 곡 수정
	public void menu6() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.println("검색할 곡 명 : ");
		String serch = sc.nextLine();
		System.out.println("수정할 곡 명 : ");
		String changeSong = sc.nextLine();
		System.out.println("수정할 가수 명 : ");
		String changeSinger = sc.nextLine();
		System.out.println(mc.menu6(serch,changeSong,changeSinger));
		
	}
//	7. 가수 명 내림차순 정렬
	public void menu7() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		System.out.println(mc.menu7());
	}
//	8. 곡 명 오름차순 정렬
	public void menu8() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		System.out.print(mc.menu8());
	}
}

