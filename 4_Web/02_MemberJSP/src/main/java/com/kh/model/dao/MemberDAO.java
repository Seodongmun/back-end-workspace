package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.controller.RegisterServlet;
import com.kh.model.vo.Member;
	
public class MemberDAO {
	
	ArrayList<Member> list = new ArrayList<Member>();

	public MemberDAO()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
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
	
	
//	회원가입
	public void registerMember(String id, String pwd, String name) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO member VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		ps.executeUpdate();
		close(ps,conn);
		
	}
	
//	전체 회원 보기
	public ArrayList<Member> memberView() throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			list.add(member);
		}
		
		closeAll(rs, ps, conn);
		return list;
	}
	
	
	public Member search(String id) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
//		하나의 정보는 if문으로만 써도 된다
		Member member = null;
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
		}
		closeAll(rs,ps,conn);
		return member;
	}
	
	
	
	
	
}






