package com.kh.array.practice3;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;
import com.kh.array.practice3.controller.BookController;

public class Application {
	
	
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	Book book = new Book();
//	객체를 제일 상위 클래스에서 생성해놓는 방법!
	Book[] books = {new Book("밥을 지어요" ,true, 0),
					new Book("오늘은 아무래도 덮밥",false,0),
					new Book("원피스 108",false,15),
					new Book("귀멸의 칼날 23", false, 19)};
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	
	/*
	  구현 못한것들 
	  1. 이미 대여한 책 출력(중복된 배열) 
	  일단 배열 만들긴 함
	  2. 마이페이지 (1번메뉴)에 null값만 출력
	  이유 : member를 지역변수로 호출해서 일일이 입력하니 지역에서만 입력돼고 다른데서 쓸라니까 출력 안됌
	 * */
	
	public void mainMenu() {
		boolean check = true;
		System.out.print("이름입력 : ");
		String name = sc.nextLine();
		member.setName(name);
		System.out.print("나이 입력 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age);
		
		while (check) {
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
			default:
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}

	//
	public void memberInfo() {
		System.out.println("이름 : " + member.getName());
		System.out.println("나이 : " + member.getAge());
		System.out.println("보유쿠폰 개수 : " + member.getCoupon());
		System.out.println("대여한 책 : " + Arrays.toString(member.getBookList()));
	}

	
	public void rental() {
//		하나씩 출력하는거 보다는 for문을 돌려서 length만큼 조회하는게 더 보기좋다
//		for(int i = 0; i < books.length; i++) {
//			System.out.println((i+1) + "번 도서 : " + books[i]);
//		}
		Book book1 = new Book("밥을지어요", true, 0);
		System.out.println("1번 도서 : " + book1.getTitle() + " 연령제한 : " + book1.getAccessAge());
		Book book2 = new Book("오늘은 아무래도 덮밥", false, 0);
		System.out.println(
				"2번 도서 : " + book2.getTitle() + " 연령제한 : " + book2.getAccessAge());
		Book book3 = new Book("원피스 108", false, 15);
		System.out.println(
				"3번 도서 : " + book3.getTitle() + " 연령제한 : " + book3.getAccessAge());
		Book book4 = new Book("귀멸의 칼날 23", false, 19);
		System.out.println(
				"4번 도서 : " + book4.getTitle() + " 연령제한 : " + book4.getAccessAge());
		System.out.println("대여할 도서 번호 선택");
		int select = Integer.parseInt(sc.nextLine());
		// 중복선택일시 이미 대여한 책입니다 출력

		switch (select) {
		case 1:
			// int selset에서 값1을 받으면 case1 실행 후 select카운트 ++
			// 다음 호출시에는 select가 2일테니 if문 으로 이미 대여한 책 출력
//			if (member.getBookList()) {
//				System.out.println("이미 대여한 도서입니다");
			if (member.getAge() <= book1.getAccessAge()){
				System.out.println("나이제한으로 대여 불가능입니다");
			} else {
				System.out.println("1번 도서 : " + book1);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[0] = books[select -1];
//				
			}
			break;
		case 2:
			if (member.getAge() <= book2.getAccessAge()) {
				System.out.println("나이제한으로 대여 불가능입니다");
			} else {
				System.out.println("2번 도서 : " + book2);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[1] = books[select -1];
			}
			break;
		case 3:
			if (member.getAge() <= book3.getAccessAge()) {
				System.out.println("나이제한으로 대여 불가능입니다");
			} else {
				System.out.println("3번 도서 : " + book3);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[2] = books[select -1];
			}
			break;
		case 4:
			if (member.getAge() <= book4.getAccessAge()) {
				System.out.println("나이제한으로 대여 불가능입니다");
			} else {
				System.out.println("4번 도서 : " + book4);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[3] = books[select -1];
			}
			break;
		}

	}

}
