package com.kh.array.practice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;
import com.kh.array.practice3.controller.BookController;

public class Application {
	
	BookController bc = new BookController();
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
//	객체를 제일 상위 클래스에서 생성해놓는 방법!
	
//	ArrayList<Book> books = new ArrayList<>()
//		{  
//		books.add(new Book("밥을 지어요" ,true, 0));
//		books.add(new Book("오늘은 아무래도 덮밥",false,0));
//		books.add(new Book("원피스 108",false,15));
//		books.add(new Book("귀멸의 칼날 23", false, 19));
//		}

	Book[] books = {new Book("밥을 지어요" ,true, 0),
					new Book("오늘은 아무래도 덮밥",false,0),
					new Book("원피스 108",false,15),
					new Book("귀멸의 칼날 23", false, 19)};
	int count = 0;
	
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
		System.out.print("이름입력 : ");
		String name = sc.nextLine();
		System.out.print("나이 입력 : ");
		int age = Integer.parseInt(sc.nextLine());
//		컨트롤러에 입력한 정보 저장
		bc.addMember(name, age);
		boolean close = true;
		while (close) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지 ");
			System.out.println("2. 도서 대여하기 ");
			System.out.println("3. 프로그램 종료하기 ");
			System.out.print("메뉴 번호 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				// 회원 정보 출력
				memberInfo();
				break;
			case 2:
				// 대여할 도서 선택 1~4
				rental();
				break;
			case 3:
				close = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}

	public void memberInfo() {
		System.out.println("이름 : " + member.getName());
		System.out.println("나이 : " + member.getAge());
		System.out.println("보유쿠폰 개수 : " + member.getCoupon());
		System.out.println("대여한 책 : " + Arrays.toString(member.getBookList()));
	}

	public void rental() {
		System.out.print("대여할 도서 번호 선택 : ");
		int select = Integer.parseInt(sc.nextLine());
//		bc.rentBook(books[select -1]);
		switch (select) {
//		1번 도서 로직 ==============================================
		case 1:
			if (member.getAge() <= books[0].getAccessAge()){
				System.out.println("나이제한으로 대여 불가능입니다");
			} else if (count < 2){
//				이미 대여한 책은 대여 불가능하게 만들어야 하는 경우
				for(Book book : member.getBookList()) {
					if(book != null && book.equals(books[select -1])) {
						System.out.println("이미 대여한 책입니다");
						return;
					}
				}
				System.out.println("1번 도서 : " + books[0]);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[count++] = books[select -1];
			}
			break;
//		2번 도서 로직 ==============================================
		case 2:
			if (member.getAge() <= books[1].getAccessAge()) {
				System.out.println("나이제한으로 대여 불가능입니다");
			} else if (count < 2) {
				for (Book book : member.getBookList()) {
					if (book != null && book.equals(books[select - 1])) {
						System.out.println("이미 대여한 책입니다");
						return;
					}
				}
				System.out.println("2번 도서 : " + books[1]);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[1] = books[select - 1];
			} else {
				System.out.println("이미 대여한 도서입니다");
			}
			break;
//		3번 도서 로직 ==============================================
		case 3:
			if (member.getAge() <= books[2].getAccessAge()) {
				System.out.println("나이제한으로 대여 불가능입니다");
			} else if (count < 2) {
				for(Book book : member.getBookList()) {
					if(book != null && book.equals(books[select -1])) {
						System.out.println("이미 대여한 책입니다");
						return;
					}
				}
				System.out.println("3번 도서 : " + books[2]);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[2] = books[select -1];
			} else {
				System.out.println("이미 대여한 도서입니다");
			}
			break;
//		4번 도서 로직 ==============================================
		case 4:
			if (member.getAge() <= books[3].getAccessAge()) {
				System.out.println("나이제한으로 대여 불가능입니다");
			} else if (count < 2) {
				for (Book book : member.getBookList()) {
					if (book != null && book.equals(books[select - 1])) {
						System.out.println("이미 대여한 책입니다");
						return;
					}
				}
				System.out.println("4번 도서 : " + books[3]);
				System.out.println("성공적으로 대여되었습니다.");
				member.getBookList()[3] = books[select - 1];
			} else {
				System.out.println("이미 대여한 도서입니다");
			}
			break;
		}
	}
}
