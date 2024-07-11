package music;

import java.util.ArrayList;
import java.util.Scanner;

import music.controller.MusicController;
import music.model.Music;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Music> musicList = new ArrayList<>();
	MusicController mc = new MusicController();
	
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();
	}
	
	public void mainMenu() {

		try {
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
				System.out.print("메뉴 번호 입력 : ");
				int select = Integer.parseInt(sc.nextLine());
				// 문자 입력시 잘못 입력메세지 출력 (Exception 사용)
				switch (select) {
				// 1. 마지막 위치에 곡 추가
				case 1:
					mc.musicSelect1();
					break;
				// 2. 첫 위치에 곡 추가
				case 2:
					mc.musicSelect2();
					break;
				case 3:
					mc.musicSelect3();
					break;
				case 4:
					mc.musicSelect4();
					break;
				case 5:
					mc.musicSelect5();
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					check = false;
					System.out.println("프로그램 종료");
					break;

				}
			}
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			mainMenu();
		}
	}
}







