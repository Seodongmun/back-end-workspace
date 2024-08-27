package com.kh.mybatis.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
//	의존성 주입
	@Autowired
	private MemberService service;
	
//	첫 페이지 와서 index.jsp 호출 요청
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allMember", service.allMember());
		return "index";
	}
	
//	회원가입 a 누르면 register.jsp로 ㄱㄱ
	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}
	
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}
	
//	로그인 페이지 a태그 get방식
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}
//	
	@PostMapping("/login")
//	로그인 정보 세션에 담기
	public String login(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vo",service.login(vo));
		service.login(vo);
		return "redirect:/";
	}
	
//	비밀번호 이름 업데이트
	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(vo);
//		기존정보 get한뒤
		Member member = (Member) session.getAttribute("vo");
//		수정해준 후
		if(vo.getId()==null) vo.setId(member.getId());
		System.out.println(vo);
		service.update(vo);
//		다시 set 해준다
		if(vo.getName()==null) vo.setName(member.getName());
		session.setAttribute("vo", vo);
//		HttpSession session = request.getSession();
//		session.setAttribute("vo", vo);
//		service.update(vo);
		return "redirect:/";
	}
	
	
	
	
//	로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if(member != null)session.invalidate();
		return "redirect:/";
	}
}













