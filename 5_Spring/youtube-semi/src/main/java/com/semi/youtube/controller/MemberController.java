package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.config.TokenProvider;
import com.semi.youtube.model.vo.Member;
import com.semi.youtube.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private TokenProvider tokenProvier;
	
	// 중복체크 (ajax 실시간 처리)
	@ResponseBody
	@PostMapping("/check")
	public boolean check (String id) {
		System.out.println(id);
		return service.check(id);
	}
	
	
	
//	로그인
	@ResponseBody
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		Member member = service.login(vo);
		System.out.println(member);
		if(member!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", member);
			// 로그인 되면 index로
			String token = tokenProvier.create(member);
			return token;
		}
		// 아니면 다시 로그인
		return null;
	}
	
// 로그아웃
//	@GetMapping("/logout")
//	public String logout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return "redirect:/";
//		
//	}

//	회원가입
	@PostMapping("/signup")
	public String signup(Member vo) {
		service.signup(vo);
		return "redirect:/";
	}
	
	
}
