package com.kh.sesstion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	MemberDAO dao = new MemberDAO();
	
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		boolean check = false;
		
		try {
			dao.login(id, password);
			check = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(check) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
//			로그인 된 상태
//			response.sendRedirect("index.jsp");
		}
		
	}
	
	
	
}
