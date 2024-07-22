package com.kh.controller;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.kh.model.Book;
import com.kh.model.Member;
import com.kh.model.Rent;

import config.ServerInfo;

public class BookController {
	
	Properties p = new Properties();
	
	
	public BookController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			p.load(new FileInputStream("src/config/jdbc.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public Connection getConnect() throws SQLException {
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
//	1. 전체 book 정보 출력
	public ArrayList<Book> printBookAll() {
		ArrayList<Book> list = new ArrayList<Book>();
		try {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("printBookAll"));
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBkNo(rs.getInt("bk_no"));
				book.setBkTitle(rs.getString("bk_title"));
				book.setBkAuthor(rs.getString("bk_author"));
				list.add(book);
		}
		closeAll(rs,ps,conn);
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}
//	========================================================================================
//	2-1. 책 등록
//	책 제목, 저자 입력받아 새로 객체 생성
	public boolean registerBook(String bookTitle, String bookAuthor) {
		try {
		if (!bookCheck(bookTitle, bookAuthor)) {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("registerBook"));
			ps.setString(1, bookTitle);
			ps.setString(2, bookAuthor);
			ps.executeUpdate();
			close(ps, conn);
			return true;
		}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
//	========================================================================================
//  2-2. 책 , 저자 이름 중복체크
//  기존 제목, 저자 있으면 등록 안되게!
	public boolean bookCheck(String bookTitle, String bookAuthor) {
		try {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("bookCheck"));
			ps.setString(1, bookTitle);
			ps.setString(2, bookAuthor);
			ResultSet rs = ps.executeQuery();
//		null인경우
			if (rs.next()) {
				closeAll(rs, ps, conn);
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
//	========================================================================================
//	3. 책 삭제
	public boolean sellBook(int select) {
		try {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("deleteBook"));
			ps.setInt(1, select);
			ps.executeUpdate();
//		없는 책번호를 입력해도 삭제 execute는 작동해서 문제
//		기존 책들 중에 해당 no가 있는 경우만 삭제
//			for (Book b : printBookAll()) {
//				if (b.getBkNo() == select) {
//					sellBook(select);
//					return true;
//				}
//			}
			if (ps.executeUpdate() != 1) {
//			삭제 성공하면 true반환
				close(ps, conn);
				return true;
			} else {
//			삭제 실패하면 false반환
				close(ps, conn);
				return false;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
//	
//	public boolean checkRentBook(int select) {
//		boolean check = true;
//		try {
//			Connection conn = getConnect();
//			PreparedStatement ps = conn.prepareStatement(p.getProperty("checkRentBook"));
//			ps.setInt(1, select);
//			ResultSet rs = ps.executeQuery();
//			check = rs.next();
//			closeAll(rs, ps, conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return check;
//	}
////	DAO 파일
//	public void sellBook(int select) throws SQLException {
//		Connection conn = getConnect();
//		PreparedStatement ps = conn.prepareStatement(p.getProperty("deleteBook"));
//		ps.setInt(1, select);
//		ps.executeUpdate();
//		close(ps,conn);
//	}
	
	
//	========================================================================================
//	4. 회원가입
	public boolean registerMember(String id, String password, String name)  {
		try {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("registerMember"));
		ps.setString(1,id);
		ps.setString(2,password);
		ps.setString(3,name);
		ps.executeUpdate();
		close(ps, conn);
		} catch (Exception e) {
			e.getMessage();
		}
		return true;
	}
//	========================================================================================
//  5. 로그인
	public String login(String id, String password) {
		String name = null;
		try {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1, id);
		ps.setString(2, password);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			name = rs.getString("member_name");
			closeAll(rs, ps, conn);
		} catch (Exception e) {
			e.getMessage();
		}
		return name;
	}
//	========================================================================================
//	memberMenu()*******************************************

//	로그인 했을 시 사용자 정보를 담는 객체!
//	private Member member = new Member();
//	필요한 테이블 rent , book, member
//  1-1 . 책 대여 SELECT
	public boolean rentBook(int memberNo, int bookNo ) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("rentBook"));
		ps.setInt(1, memberNo);
		ps.setInt(2, bookNo);
		ps.executeUpdate();
		close(ps,conn);

		return false;
	}

//	=========================================================
//	2. 내가 대여한 책 조회
	public void printRentBook() throws SQLException {

	}

//	=========================================================
//	3. 대여 취소
	public void deleteRent() {
		
		
		
	}

//	=========================================================
//	4. 회원탈퇴
	public void deleteMember() {
		
		
		
		
	}

}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

