package transaction;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.exceptions.RSAException;

public class TXCommitTest2 {
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema1","root","qwer1234");
			
			conn.setAutoCommit(false);
			
			/*
			   동엽 -> 동호 : 3만원씩 이체
			   동엽님의 잔액이 마이너스가 되면 이체 취소가 되어야 함!
			   쿼리 3개 필요!
			   - UPDATE 2개 , SELECT 1개
			   
			   잔액이 없으므로 이체 취소!
			   잔액이 있으므로 이체 성공!
			 * */

			System.out.println("이체금액을 입력하세요 : ");
			int sendMoney = Integer.parseInt(sc.nextLine());
			String query1 = "UPDATE bank SET balance = balance-? WHERE name = ?";
			String query2 = "UPDATE bank SET balance = balance+? WHERE name = ?";
			String query3 = "SELECT balance FROM bank WHERE name =?";

			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setInt(1, sendMoney);
			ps1.setString(2, "동엽");
			ps1.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1,sendMoney);
			ps2.setString(2, "동호");
			ps2.executeUpdate();
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, "동엽");
			ResultSet rs = ps3.executeQuery();
			
//			동엽님의 잔액이 마이너스가 되면
			if (rs.next()) {
				if (rs.getInt("balance") < 0) {
//					이체 취소가 되어야 함!
					conn.rollback();
					System.out.println("잔액이 부족합니다");
				} else {
					conn.commit();
					System.out.println("이체되었습니다");
				}
			}
			
			
			
			conn.setAutoCommit(true);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
