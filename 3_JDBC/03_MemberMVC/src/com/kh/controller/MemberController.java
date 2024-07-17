package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Member;

public class MemberController {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/new_schema1";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	boolean check = true;
	
	public void PersonController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
////	중복 체크 메서드
//	public boolean checkId(String id) throws SQLException {
//		// -> 아이디가 기존에 있는지 체크 여부!
//		Connection conn = getConnect();
////		중복된 아이디가 있으면
//		String query = "SELECT id WHERE LIKE '%?%' ";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, id);
//		ps.executeQuery();
//		check = false;
//		closeAll(ps,conn);
////		false 반환
//		return check;
//	}
	
	
	

	public void signUp(String id, String password, String name) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO member(id,password,name)VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		// 회원가입 기능 구현! 
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeUpdate();
		check = true;
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가!
		
		closeAll(ps,conn);
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}
	
	
	public ArrayList<Member> login(String id, String password) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT name  FROM person WHERE id = ?,password = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		// 로그인 기능 구현! 
		// -> member 테이블에서 입력받은 값이 곧 조건(id와 password)로 멤버 정보 하나 가져오기!
		ResultSet rs = ps.executeQuery();
		ArrayList<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("name"));
			list.add(member);
//			list 에 입력한 id 값과 일치하는 name 값이 add 된다
		}

		return list;
	}
	
	public void changePassword() {
		
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	}
	
	public void changeName() {
		
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
		
		
	}
	
}









