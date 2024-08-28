package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

import config.ServerInfo;

/*
   DAO(Data Access Object)
   - DB에 접근하는 역할을 하는 객체 (CRUD)
 * */

public class BookDAO {
	
	private Scanner sc = new Scanner(System.in);

	Properties p = new Properties();

	public BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			p.load(new FileInputStream("src/config/jdbc.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();

	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	
//	========================================================================================
//	1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("printBookAll"));
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Book book = new Book();
			book.setBkNo(rs.getInt("bk_no"));
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
			
			Publisher publisher = new Publisher();
			publisher.setPubName(rs.getString("pub_name"));
			book.setPublisher(publisher);

			list.add(book);
			
//			book.setPublisher(new Publisher(rs.getInt("pub_no"),
//					rs.getString("pub_name"),
//					rs.getString("phone")));
			
//			
//			list.add(new Book(rs.getInt("bk_no"),
//					rs.getString("bk_title"),
//					rs.getString("bk_author"),
//					rs.getInt("bk_price"),
//					new Publisher(rs.getInt("pub_no"),
//							rs.getString("pub_name"),
//							rs.getString("phone")
//							)));
		}
		closeAll(rs,ps,conn);

		return list;
	}
//	========================================================================================
//	2. 책 등록
//	
//	public void registerBook() {
//	System.out.print("책 제목을 입력하세요 : ");
//	String title = sc.nextLine();
//	System.out.println("책 저자를 입력하세요 : ");
//	String author = sc.nextLine();
//	
//
//	
//	
//}
//============================================================================
// 3. 책 삭제
//public void sellBook() throws SQLException {
//	int select = 0;
//	// printBookAll로 전체 책 조회를 한 후
//	printBookAll();
//	// 삭제할 책 번호 선택을 사용자한테 입력 받아 (DELETE)
//	try {
//	System.out.print("삭제할 책 번호를 입력하세요 : ");
//	select = Integer.parseInt(sc.nextLine());
//	} catch (Exception e) {
//		sellBook();
//		System.out.println("다시 입력해주세요");
//	}
////	bc.sellBook(select);
//	boolean check = bc.sellBook(select);
//	if (!check) {
//		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
//		System.out.println("책을 삭제하는데 실패했습니다");
//	} else {
//		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
//		System.out.println("성공적으로 책을 삭제했습니다");
//	}
//	
//}
//============================================================================
// 4. 회원가입
//public void registerMember() throws SQLException {
//	// 아이디, 비밀번호, 이름을 사용자한테 입력 받아 (입력)
//	System.out.println("아이디를 입력하세요 : ");
//	String id = sc.nextLine();
//	System.out.println("비밀번호를 입력하세요 : ");
//	String password = sc.nextLine();
//	System.out.println("이름를 입력하세요 : ");
//	String name = sc.nextLine();
//	boolean check = bc.registerMember(id, password, name);
//	if (check) {
//		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력 (INSERT INTO)
//		System.out.println("성공적으로 회원가입을 완료하였습니다");
//	} else {
//		// 실패하면 "회원가입에 실패했습니다." 출력
//		System.out.println("회원가입에 실패했습니다.");
//	}
//}
//=========================================================
// 5. 로그인
public void login() throws SQLException {
	// 아이디, 비밀번호를 사용자한테 입력 받아 
	System.out.println("아이디를 입력하세요 : ");
	String id = sc.nextLine();
	System.out.println("비밀번호를 입력하세요 : ");
	String password = sc.nextLine();
//	로그인 성공 후 받아온 name
	String name = bc.login(id, password); //?????????
	if (name!= null) {
//			로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
		System.out.println( name + "님, 환영합니다!");
		memberMenu();
	} else {
		System.out.println("로그인에 실패하였습니다 다시 입력해주세요");
		login();
	}
}

//memberMenu()*******************************************
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
		memberMenu();
	}
}

//로그인 했을 시 사용자 정보를 담는 객체!
//private Member member = new Member();
//=========================================================
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
//	boolean check = bc.rentBook(select);
	
}
//=========================================================
// 2. 내가 대여한 책 조회 (SELECT)
public void printRentBook() {
	
	
	// 내가 대여한 책들을 반복문을 이용하여 조회
	// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회 (+7일)
	
	
}
//=========================================================
// 3. 대여 취소 
public void deleteRent() {
	
	
	// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
	
	// 취소할 대여 번호 선택을 사용자한테 입력 받아
	
	// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
	// 실패하면 "대여를 취소하는데 실패했습니다." 출력
	
	
}
//=========================================================
// 4. 회원탈퇴 (Remove)
public void deleteMember() {
	
	
	// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
	// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	
	
}

}
































