package com.kh;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.BookController1;
import com.kh.controller.MemberController;
import com.kh.model.Book;
import com.kh.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
//	private BookController1 bc1 = new BookController1();
//	로그인 했을 시 사용자 정보를 담는 객체!
	private Member member = new Member();
	private Book book = new Book();
	
//	스키마 : sample

	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();
		
	}

	public void mainMenu() {
		System.out.println("===== 도서 관리 프로그램 =====");
		try {
			boolean check = true;
			while (check) {
				System.out.println("1. 전체 책 조회");
				System.out.println("2. 책 등록");
				System.out.println("3. 책 삭제");
				System.out.println("4. 회원가입");
				System.out.println("5. 로그인");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					printBookAll();
					break;
				case 2:
					registerBook();
					break;
				case 3:
					sellBook();
					break;
				case 4:
					registerMember();
					break;
				case 5:
					login();
					break;
				case 9:
					check = false;
					System.out.println("프로그램 종료");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	============================================================================
	// 1. 전체 책 조회
	public void printBookAll(){
		// 반복문을 이용해서 책 리스트 출력
		bc.printBookAll();
		for (Book book : bc.printBookAll()) {
			System.out.println("===================================");
			System.out.println("책 번호 : " + book.getBkNo());
			System.out.println("제목 : " + book.getBkTitle());
			System.out.println("저자 : " + book.getBkAuthor());
			if (book.getPublisher() != null) {
				System.out.println("출판사 : " + book.getPublisher().getPubName());
			}
		}
	}
//	============================================================================
	// 2. 책 등록 (중복체크,등록)
	public void registerBook() {
		// 책 제목, 책 저자를 사용자한테 입력 받아 (입력)
		System.out.print("책 제목을 입력하세요 : ");
		String bookTitle = sc.nextLine();
		System.out.println("책 저자를 입력하세요 : ");
		String bookAuthor = sc.nextLine();
//		============================================
//		방법 1) 객채 생성후 보내기
		Book book = new Book();
		book.setBkTitle(bookTitle);
		book.setBkAuthor(bookAuthor);
//		============================================
//		방법 2) 보내면서 객체생성
//		Book result = bc.registerBook(book);
//		Book book = bc.registerBook(new Book(bookTitle,bookAuthor));
//		============================================
		if(bc.registerBook(bookTitle, bookAuthor)) {
//			등록에 성공하면 "성공적으로 책을 등록했습니다." 출력 (INSERT INTO)
			System.out.println("성공적으로 책을 등록했습니다");
		} else {
// 			실패하면 "책을 등록하는데 실패했습니다." 출력
			System.out.println("책을 등록하는데 실패했습니다");
		}
		
// 		기존 제목, 저자 있으면 등록 안되게!
	}
//	============================================================================
	// 3. 책 삭제
	public void sellBook() throws SQLException {
		int select = 0;
		// printBookAll로 전체 책 조회를 한 후
		// 삭제할 책 번호 선택을 사용자한테 입력 받아 (DELETE)
		try {
			System.out.print("삭제할 책 번호를 입력하세요 : ");
			select = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			sellBook();
			System.out.println("다시 입력해주세요");
		}
		bc.sellBook(select);
		boolean check = bc.sellBook(select);
		if (!check) {
			// 실패하면 "책을 삭제하는데 실패했습니다." 출력
			System.out.println("책을 삭제하는데 실패했습니다");
		} else {
			// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
			System.out.println("성공적으로 책을 삭제했습니다");
		}
	}
//	============================================================================
	// 4. 회원가입
	public void registerMember(){
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아 (입력)
		System.out.println("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요 : ");
		String password = sc.nextLine();
		System.out.println("이름를 입력하세요 : ");
		String name = sc.nextLine();
		if (mc.registerMember(id,password,name)) {
			// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력 (INSERT INTO)
			System.out.println("성공적으로 회원가입을 완료하였습니다");
		} else {
			// 실패하면 "회원가입에 실패했습니다." 출력
			System.out.println("회원가입에 실패했습니다.");
		}
		
//		boolean 에 굳이 안담아도 registerMember()메서드의 리턴값을 boolean으로 해놓으면
//		if 사용 가능
//		내가 한거
//		boolean check = bc.registerMember(id, password, name);
//		if (check) {
//			// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력 (INSERT INTO)
//			System.out.println("성공적으로 회원가입을 완료하였습니다");
//		} else {
//			// 실패하면 "회원가입에 실패했습니다." 출력
//			System.out.println("회원가입에 실패했습니다.");
//	}
	}
//	=========================================================
	// 5. 로그인
	public void login() throws SQLException {
		// 아이디, 비밀번호를 사용자한테 입력 받아
		System.out.println("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요 : ");
		String password = sc.nextLine();
//		로그인 성공 후 받아온 name
//		member = mc.login(id, password);
//		if (member != null) {
//			System.out.println(member.getMemberName() + "님, 환영합니다!");
//			memberMenu();
//		} else {
//			System.out.println("로그인에 실패하였습니다 다시 입력해주세요");
//			login();
//		}
		
//		내가 한거
		String name = bc.login(id, password);
		if (name!= null) {
// 			로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
			member.setMemberId(id);
			member.setMemberPwd(name);
			
			System.out.println( name + "님, 환영합니다!");
			memberMenu();
		} else {
			System.out.println("로그인에 실패하였습니다 다시 입력해주세요");
			login();
		}
	}

//	memberMenu()*******************************************
	public void memberMenu() {
		try {
			boolean check = true;
			while (check) {
				System.out.println("1. 책 대여");
				System.out.println("2. 내가 대여한 책 조회");
				System.out.println("3. 대여 취소");
				System.out.println("4. 로그아웃");
				System.out.println("5. 회원탈퇴");
				System.out.print("메뉴 번호 입력 : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					rentBook();
					break;
				case 2:
					printRentBook();
					break;
				case 3:
					deleteRent();
					break;
				case 4:
					check = false;
					break;
				case 5:
					deleteMember();
					check = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
			System.out.println(e.getMessage());
			memberMenu();
		}
	}
	
//	로그인 했을 시 사용자 정보를 담는 객체!
//	private Member member = new Member();
//	=========================================================
	// 1. 책 대여
	public void rentBook() throws SQLException {
		
		// 책이 1권이라고 가정
		// 다른 사람은 대여 못하게 본인 뿐만 아니라 다른 사람도 대여 못하게
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		printBookAll();
		//( 대여할 책 번호 )선택을 사용자한테 (입력) 받아
		System.out.println("대여할 책 번호를 입력하세요 : ");
		int select = Integer.parseInt(sc.nextLine());
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
//		boolean check = bc.rentBook(select);
		
	}
//	=========================================================
	// 2. 내가 대여한 책 조회 (SELECT)
	public void printRentBook(Book book) throws SQLException {

//		String book = bc.printRentBook(book,member);
		System.out.println(book);
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회 (+7일)
		
		
	}
//	=========================================================
	// 3. 대여 취소 
	public void deleteRent() {
//		printRentBook();
		
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		
		
	}
//	=========================================================
	// 4. 회원탈퇴 (Remove)
	public void deleteMember() {
		
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
		
		
	}
	
}











