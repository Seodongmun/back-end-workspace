package com.kh.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.Member;

import config.ServerInfo;

public class MemberController {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/new_schema1";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	boolean check = true;
	Properties p = new Properties();

//	싱글톤 패턴(Singleton Pattern)
//	- 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
//	1. 생성자는 private
//	public MemberController() {}
	
//	2. 유일한 객체를 담을 static 변수
	private static MemberController instance;
	
//	3. 객체를 반환하는 static 메서드
	public static MemberController getInstance() {
		if(instance == null) instance = new MemberController();
		
		return instance;
	}
	
	
	
	public MemberController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			p.load(new FileInputStream("src/config/jdbc.properties"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();

	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
//  Member 객체의 변수 m으로 받아온 값 사용
	public boolean signUp(String id, String password, String name) throws SQLException {
// 		-> 아이디가 기존에 있는지 체크 여부!
//		idCheck 메서드 사용!
		if (!idCheck(id)) {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("signUp"));
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.executeUpdate();
			closeAll(ps, conn);
			return true;
		}
		return false;
//			try {
//				try / catch 방식으로 중복 체크
//				중복된값 없을때 ps.executeUpdate()실행
//				ps.executeUpdate();
//				closeAll(ps, conn);
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
	}
	// -> 아이디가 기존에 있는지 체크 여부!
	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("idCheck"));
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		String checkId = null;

		if (rs.next())
			checkId = rs.getString("id");
		closeAll(rs, ps, conn);
		if (checkId != null)
			return true;

		return false;
	}

	// -> member 테이블에 데이터 추가!
	public String login(String id, String password) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1, id);
		ps.setString(2, password);
		// 로그인 기능 구현!
		// -> member 테이블에서 입력받은 값이 곧 조건(id와 password)로 멤버 정보 하나 가져오기!
		ResultSet rs = ps.executeQuery();
		String name = null;
		if (rs.next())
			name = rs.getString("name");
		closeAll(rs, ps, conn);
		return name;
	}
	
	
	
//	public ArrayList<Member> login(String id, String password) throws SQLException {
//		Connection conn = getConnect();
//		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
//		ps.setString(1, id);
//		ps.setString(2, password);
//		ps.executeQuery();
//		
//		// 로그인 기능 구현! 
//		// -> member 테이블에서 입력받은 값이 곧 조건(id와 password)로 멤버 정보 하나 가져오기!
//		ResultSet rs = ps.executeQuery();
//		ArrayList<Member> list = new ArrayList<>();
//
//		while(rs.next()) {
//			Member member = new Member();
//			member.setId(rs.getString("id"));
//			member.setName(rs.getString("name"));
//			member.setPassword(rs.getString("password"));
//			list.add(member);
////			list 에 입력한 id 값과 일치하는 name 값이 add 된다
//		}
//		closeAll(rs, ps, conn);
//		return list;
//	}
//	
//	이름 중복 확인
	public boolean checkName(Member m) throws SQLException {
		String name = m.getName();
		boolean checkName = check;
		if (name != null) {
			check = true;
//	 		-> login 메서드 활용 후 사용자 이름이 null이 아니면() 
		} // true(비밀번호 변경)
		return checkName;
	}
	
//  비밀번호 바꾸기 기능 구현!
	public boolean changePassword(String id , String oldPw, String newPw) throws SQLException {
//		2. 정보 받아서 조건에따라 실행
//		member 테이블에서 (WHERE)id로 (UPDATE)새로운 패스워드로 변경
		if(login(id,oldPw)!= null) {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("changePassword"));
			ps.setString(1, newPw);
			ps.setString(2, id);
			ps.executeUpdate();
			closeAll(ps,conn);
			return true;
		}
		return false;
	}
	
	
	
////  비밀번호 바꾸기 기능 구현!
//	public void changePassword(String id, String password, String newPassword) throws SQLException {
////		2. 정보 받아서 조건에따라 실행
//		Connection conn = getConnect();
//		String query = "UPDATE member SET password = ? WHERE id=? AND password=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, newPassword);
//		ps.setString(2, id);
//		ps.setString(3, password);
//		ps.executeUpdate();
//
//	}
//		member 테이블에서 (WHERE)id로 (UPDATE)새로운 패스워드로 변경
	
//	
	public void changeName(String id , String newName) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("changeName"));
		ps.setString(1,newName);
		ps.setString(2, id);
		ps.executeUpdate();
		closeAll(ps,conn);
		}

	}




