package project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.model.dao.Sign_upDAO;
import project.model.vo.Sign_up;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/sign_up")
public class Sign_upServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Sign_upDAO dao = new Sign_upDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		
//		DAO 접근
		try {
			dao.signUp(id, pwd, addr, phone, email, name, age, gender);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		바인딩
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.setAttribute("addr", addr);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);

//		
		request.getRequestDispatcher("sign_up_ok.jsp").forward(request, response);
		
		
	
	}

}












