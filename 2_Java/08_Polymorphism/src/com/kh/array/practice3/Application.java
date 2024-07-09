package com.kh.array.practice3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import com.kh.array.practice3.controller.BookController;
import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();


	}
	
	public void mainMenu() {
		BookController bc = new BookController();
		Member member = new Member();

		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		member.setName(name); // 이름 받아옴
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age); // 나이 받아옴
		
		int select = 0;
		boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지 ");
			System.out.println("2. 도서 대여하기 ");
			System.out.println("3. 프로그램 종료하기 ");
			System.out.print("메뉴 번호 : ");
			select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				// 회원 정보 출력
				bc.memberInfo();
				break;
			case 2:
				// 대여할 도서 선택 1~4
				rental();
				break;
			case 3:
				check = false;
				System.out.println("프로그램 종료");
				break;
				
			}
		}

	}
	
	


	public void rental() {
		HashSet<Book> setList = new HashSet<Book>(); 
		BookController bc = new BookController();
		Book book1 = new Book("밥을지어요",true,0);
		Book book2 = new Book("오늘은 아무래도 덮밥",false,0);
		Book book3 = new Book("원피스 108",false,15);
		Book book4 = new Book("귀멸의 칼날 23",false,19);
		
		System.out.println("대여할 도서 번호 선택");
		int select = Integer.parseInt(sc.nextLine());

		// 중복선택일시 이미 대여한 책입니다 출력
		switch (select) {
		case 1:
//			if(bc.checkBookList(book1)!= null) {
//				System.out.println("이미 대여한 책입니다");
//			}
			setList.add(new Book("밥을지어요",true,0));
			System.out.println("1번 도서 : " + setList);
			System.out.println("성공적으로 대여되었습니다.");
			System.out.println(setList.size());
			break;
		case 2:
			setList.add(new Book("오늘은 아무래도 덮밥",false,0));
			System.out.println("2번 도서 : " + setList);
			System.out.println("성공적으로 대여되었습니다.");
			System.out.println(setList.size());
			break;
		case 3:
			setList.add(new Book("원피스 108",false,15));
			System.out.println("3번 도서 : " + setList);
			System.out.println("성공적으로 대여되었습니다.");
			System.out.println(setList.size());
			break;
		case 4:
			setList.add(new Book("귀멸의 칼날 23",false,19));
			System.out.println("4번 도서 : " + setList);
			System.out.println("성공적으로 대여되었습니다.");
			System.out.println(setList.size());
			break;
			
		}

	
		
	}
	
	
	
	

	

}
