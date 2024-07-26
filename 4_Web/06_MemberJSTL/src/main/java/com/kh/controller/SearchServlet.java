package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	MemberDAO dao = new MemberDAO();
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			Member member = dao.searchMember(id);
			if(member != null) {
				request.setAttribute("memberInfo", member);
				request.getRequestDispatcher("/views/search_ok.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/views/search_fail.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
