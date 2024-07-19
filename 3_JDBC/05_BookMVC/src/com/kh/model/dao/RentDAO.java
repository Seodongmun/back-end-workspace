package com.kh.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class RentDAO {
	
	Properties p = new Properties();

	public RentDAO() {
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
//	대여한 책이 있는지 조회
	public void checkRentBook() {
		try {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("sellBook"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}






























