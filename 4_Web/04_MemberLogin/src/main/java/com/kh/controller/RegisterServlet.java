package com.kh.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	MemberDAO dao = new MemberDAO();
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1. 회원정보 입력 get
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		boolean check = false;
		
//		2. DAO 연결
		
		try {
			dao.memberRegister(id, password, name);
//			Member변수로 받기
//			dao.register(new Member(id,password,name));
			check = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(check){

//		3. 바인딩
		

		
//		4. 네비게이션
		response.sendRedirect("/index.jsp");
		} else {
			response.sendRedirect("/views/register_fail");
		}


		
	}

}
