package com.kh.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

@Controller
public class MemberController {
	
//	의존성 주입
	@Autowired
	private MemberService service;
	
//	첫 페이지 와서 index.jsp 호출 요청
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
//	회원가입 a 누르면 register.jsp로 ㄱㄱ
	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}
	
//	서비스 vo
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}
	
	
	
	
}














