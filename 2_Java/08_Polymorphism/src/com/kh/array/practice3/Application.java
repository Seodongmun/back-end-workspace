package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;
import com.kh.array.practice3.controller.BookController;

public class Application {
	
	Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		
		Application app = new Application();
		Member member = new Member();
		BookController bc = new BookController();
		Book book = new Book();
		app.mainMenu();
		

	}
	
	public void mainMenu() {
		
		boolean check = true;
		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지 ");
			System.out.println("2. 도서 대여하기 ");
			System.out.println("3. 프로그램 종료하기 ");
			System.out.print("메뉴 번호 : ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				// 회원 정보 출력
				memberInfo();
				break;
			case 2:
				// 대여할 도서 선택 1~4
				rental();
				break;
			case 3:
				check = false;
				break;
				default: System.out.println("잘못 입력하셨습니다");
			}
		}

	}
	
	// 
	public void memberInfo() {
		Member member = new Member();
		// 커스터머 이름 정보 입력해서 스캔
		System.out.println("이름입력 : ");
		String name = sc.nextLine();
		member.getName();
		member.getAge();
		member.getCoupon();
		System.out.println(member.getName() + member.getAge() + member.getCoupon());
	}

	public void rental() {
		Book book1 = new Book("밥을지어요", true, 0);
		Book book2 = new Book("오늘은 아무래도 덮밥", false, 0);
		Book book3 = new Book("원피스 108", false, 15);
		Book book4 = new Book("귀멸의 칼날 23", false, 19);
		System.out.println("대여할 도서 번호 선택");
		int select = Integer.parseInt(sc.nextLine());
		Member check = new Member();
		// 중복선택일시 이미 대여한 책입니다 출력
		switch (select) {
		case 1:
			
			System.out.println("1번 도서 : " + book1);
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 2:
			System.out.println("2번 도서 : " + book2);
			System.out.println("성공적으로 대여되었습니다.");

			break;
		case 3:
			System.out.println("3번 도서 : " + book3);
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 4:
			System.out.println("4번 도서 : " + book4);
			System.out.println("성공적으로 대여되었습니다.");
			break;

		}

	}

	

}
