package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;
import com.kh.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
//	회원가입
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(Member vo) {
		try {
			service.memberRegister(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	
//	로그인
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(Member vo, HttpServletRequest request) {
		try {
			Member member = service.login(vo);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
//	회원검색
	@GetMapping("search")
	public void search() {}
	
	@GetMapping("find")
	public String find(@RequestParam("id") String id, Model model) {
		try {
			Member member = null;
			member = service.searchMember(id);
			if(member != null) {
				model.addAttribute("memberInfo", member);
				return "search_ok";
			}
			
		} catch (Exception e) {}

		return "redirect:/fail";
	}

	@GetMapping("fail")
	public String fail() {
		return "search_fail";
	}
	
	
	
//	전체회원검색
	@GetMapping("allMember")
	public String allMember(Model model) {
		try {
		ArrayList<Member> list = new ArrayList<Member>();
		list = service.allMember();
		
		model.addAttribute("allMemberInfo", list);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "allMember";
		
	}
		
//  로그아웃
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		if (member != null) {
			session.invalidate();
		}

		return "redirect:/";
	}
	
	
	
}

