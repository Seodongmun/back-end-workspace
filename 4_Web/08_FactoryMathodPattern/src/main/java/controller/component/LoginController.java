package controller.component;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller{
	

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = null;
		MemberDAO dao = new MemberDAO();
		member = dao.login(id, password);
		
		if(member != null) {
//			세션에 바인딩
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
//			session.setAttribute("id", member.getId());
//			session.setAttribute("password", member.getPassword());
//			로그인 된 상태로 index로
		}
		
		return new ModelAndView("index.jsp",true);
	}
	

}
