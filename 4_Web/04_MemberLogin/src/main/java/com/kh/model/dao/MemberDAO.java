package com.kh.model.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	private Member member = new Member();
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException  {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps,conn);
	}
	
//	DAO 개발할 때 중요한 건
//	매개변수(파라미터) 뭘 가지고 와야 되는지, 리턴타입 결과 출력이 어떤게 필요한지
	
	
	
	
//	아이디 중복 체크
	public boolean checkId(String id) throws SQLException {
		boolean check = false;
		if(id.equals(member.getId())) {
		Connection conn = connect();
		String query = "SELECT id FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.executeQuery();
		close(ps,conn);
		check = true;
		}
		return check;
	}
	
//  회원가입
	public void memberRegister(String id, String password, String name) throws SQLException {
		if(checkId(id)) {
		Connection conn = connect();
		String query = "INSERT INTO member VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeUpdate();
		close(ps,conn);
		}
	}
	
//	Member 변수로 받기
//	public void register(Member member) throws SQLException {
//		Connection conn = connect();
//		String query = "INSERT INTO member VALUES (?,?,?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, member.getId());
//		ps.setString(2, member.getPassword());
//		ps.setString(3, member.getName());
//		ps.executeUpdate();
//		close(ps,conn);
//		}
		
	
	
	

//	로그인
	public Member login(String id, String password) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		
		if(rs.next()) {
//			id,password는 입력값
//			name값만 가져온다
			member = new Member(id,password,rs.getString("name"));
			
		}
		closeAll(rs,ps,conn);
		return member;
	}
	
//	회원검색
	public Member searchMember(String id) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
		}
		closeAll(rs,ps,conn);
		return member;
	}
	
//	전체회원보기
	public ArrayList<Member> allMember() throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Member> list = new ArrayList<Member>();
		while(rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			list.add(member);
		}
		
		closeAll(rs,ps,conn);
		return list;
	}

	
	
}
