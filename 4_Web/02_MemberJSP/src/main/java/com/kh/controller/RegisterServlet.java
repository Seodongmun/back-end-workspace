package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	MemberDAO dao = new MemberDAO();
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Controller - 비지니스 로직 작성 공간
		
//		id(키값)
//		index.jsp에서 /register로 요청 하여
//		요청 받은 아이디(id), 비밀번호(pwd), 이름(name)을 받아야함
//		1. 폼 값 받아온다. (선택)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		boolean check = false;
		
		
//		2. DAO 호출 - DB 접근 필요시
		try {
			dao.registerMember(id, pwd, name);
			check = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(check) {
////			3. 바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때
////			키,값
		request.setAttribute("name", name);
		request.setAttribute("check", check);

		
//			4. 네비게이션 : 결과 페이지 지정 - result.jsp
			response.sendRedirect("result.jsp");
//			만약 결과 페이지로 서버에서 받은 값 보여주려면 
//			-> RequestDispatcher forword 방식으로 보내야 함
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} else {
//			실패했을때
			response.sendRedirect("fail.jsp");
		}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}


}
