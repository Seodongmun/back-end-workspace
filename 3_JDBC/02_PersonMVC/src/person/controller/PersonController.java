package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import person.model.Person;

public class PersonController {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/sample";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";


//	고정적인 반복 -- DB 연결, 자원 반납 -> 공통적인 메서드 정의.... 메서드 마다 호출해서 사용
	
	
	public PersonController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
//	자원반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
		
	}
	
	
//	변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)
//	person 테이블에 데이터 추가 - INSERT
	public int addPerson(String name, int age, String addr) throws SQLException {
		
		Connection conn = getConnect();
		String query = "INSERT INTO person(name,age,addr)VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		
		int result = ps.executeUpdate();
		closeAll(ps,conn);
		return result;
	}

//	person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(String name, int age, String addr) throws SQLException {
		Connection conn = getConnect();
		String query = "UPDATE person SET (name = ?,age = ?,addr = ?) WHERE id = (?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
//		ps.setInt(4, id);
		
		ps.executeUpdate();
		closeAll(ps,conn);
	}
	
//	person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id, String name) throws SQLException {

		Connection conn = getConnect();
		String query = "DELETE FROM person  WHERE id = (?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		closeAll(ps, conn);
	}

//	person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();

		while (rs.next()) {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setAge(rs.getInt("age"));
			person.setAddr(rs.getNString("addr"));
			list.add(person);
		}
		closeAll(rs, ps, conn);
		return list;
	}

//	person 테이블에서 데이터 한개만 가져오기 - SELECT
	public String searchPerson(int searchId) throws SQLException {
		int id = 0;
		String name = "";
		int age = 0;
		String addr = "";
		Connection conn = getConnect();
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, searchId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		id = rs.getInt("id");
		name = rs.getString("name");
		age = rs.getInt("age");
		addr = rs.getString("addr");
		}
		System.out.println("아이디 : "+ id +  "\n이름 : " + name +  "\n나이 : " + age + "\n주소 : "+ addr);
		closeAll(rs,ps,conn);
		return name;
	}
	
	
	
	
	
	
	
	
	
}
