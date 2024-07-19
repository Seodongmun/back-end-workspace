package com.kh.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.model.vo.Member;

import config.ServerInfo;

public class MemberDAO {
	
	Properties p = new Properties();
	
	public MemberDAO() {
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
	
// ===============================================================
	public boolean registerMember(String id, String password, String name) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("registerMember"));
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeUpdate();
		close(ps, conn);
		return true;
	}

// ===============================================================
	public Member login(String id, String password) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		Member member =  new Member();
		if (rs.next()) {
			
			member.setMemberId(id);
			member.setMemberPwd(password);
			member.setMemberName(rs.getString("member_name"));
			member.setMemberNo(rs.getInt("member_no"));
			member.setStatus(rs.getString("status").charAt(0));
			
		}
		closeAll(rs, ps, conn);
		return null;
	}
	
	
	

}










