package project.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import project.config.ServerInfo;
import project.model.vo.Sign_up;
import project.model.vo.User;


public class Sign_upDAO {
	
	public Sign_upDAO()  {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
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
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps,conn);
	}
	
//	회원가입
	public ArrayList<Sign_up> signUp(String id,String pwd, String addr, String phone, String email, String name, String age, String gender) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO sign_up VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, addr);
		ps.setString(4, phone);
		ps.setString(5, email);	
		ps.setString(6, name);
		ps.setInt(7, Integer.parseInt(age));
		ps.setString(8, String.valueOf(gender));
		ps.executeUpdate();
		User user = new User(id, pwd, addr, phone, email, name, age, gender);
		ArrayList<Sign_up> userList = new ArrayList<>();
		userList.add(user);
		
		
		close(ps,conn);
		return userList;
	}
	

	
	
	
	
	
	
	
}
