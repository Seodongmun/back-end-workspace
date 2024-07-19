package com.kh.controller;

import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberController {
	
	private MemberDAO member = new MemberDAO();

	public boolean registerMember(String id, String password, String name) {
		try {
			member.registerMember(id, password, name);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public Member login(String id, String password) {
		try {
			Member m = member.login(id, password);
//			회원 탈퇴시 사용할 것
			if(m == null || m.getStatus() == 'N') return m;
			
			
			
			
		} catch (SQLException e) {
			return null;
		}

		return null;
	}

	
	
	
	
	
}
	
	
	
	
	

