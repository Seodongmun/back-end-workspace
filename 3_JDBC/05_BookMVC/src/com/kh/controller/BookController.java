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
//	전체 book 정보 출력
	public void printBookAll() throws SQLException {
	
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("printBookAll"));
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int bk_no = rs.getInt("bk_no");
					String bk_title = rs.getString("bk_title");
					String bk_author = rs.getString("bk_author");
					int bk_price = rs.getInt("bk_price");
					int bk_pub_no = rs.getInt("bk_pub_no");

					System.out.println(bk_no + bk_title + bk_author + bk_price + bk_pub_no);
				}
			}

		}

//	책 제목, 저자 입력받아 새로 객체 생성 ============================================
	//public Book registerBook(Book b) throws SQLException {
	public boolean registerBook(String title, String author) throws SQLException {
			boolean check = true;

			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("registerBook"));
			ps.setString(1, title);
			ps.setString(2, author);
			ps.executeUpdate();

			return true;
		}
	
	
	public boolean idCheck() {
		
		
		
		return true;
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

