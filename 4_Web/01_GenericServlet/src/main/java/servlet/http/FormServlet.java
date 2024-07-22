package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


// form으로 전송중
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		getParameterValues 사용(String 배열)
//		응답
		String id = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		System.out.println(id);
		System.out.println(password);
		System.out.println(gender);
		
//		배열 메뉴
		String[] menus = request.getParameterValues("menu");
		
		
//		form으로 해당 요청 값 받아서 응답 결과 출력
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다..</h1>");
		out.println("<p>당신의 아이디는 " + id + "</p>");
		out.println("<p>당신의 비밀번호는 " + password + "</p>");
		String genderResult = gender.equals("M") ? "남자" : "여자";
//		if(gender.equals("M")) genderResult = "남자";
		out.println("<p>당신의 성별은 " + genderResult + "</p>");
		try {
			for (int i = 0; i < menus.length; i++) {
				out.println("<li>" + menus[i] + "</li>");
			}
		} catch (Exception e) {
			e.getMessage();
			out.println("<p>메뉴를 선택해주세요</p>");
		}
		out.println("</body></html>");
		out.close();
	}

}
