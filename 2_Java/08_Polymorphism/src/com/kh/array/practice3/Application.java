package com.kh.array.practice3;

import java.util.Scanner;


import com.kh.array.practice3.model.Member;
import com.kh.array.practice3.controller.BookController;

public class Application {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Application app = new Application();
		BookController bc = new BookController();
		Member member = new Member();
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
				update();
				break;
			case 2:
				insert();
				break;
			case 3:
				check = false;
				break;
				default: System.out.println("잘못 입력하셨습니다");
			}
		}

	}
	
	public void update() {
		
		
	}
	public void insert() {
		
		
	}
	

	

}
