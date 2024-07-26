package com.kh.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;



@WebServlet("/allMember")
public class ViewAllMember extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	MemberDAO dao = new MemberDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			list = dao.allMember();
			request.setAttribute("allMemberInfo", list);
			request.getRequestDispatcher("views/allMember.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
	}

}
















