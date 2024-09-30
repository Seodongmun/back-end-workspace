package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.semi.youtube.model.vo.Member;
import com.semi.youtube.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	// 중복체크 (ajax 실시간 처리)
	@ResponseBody
	@PostMapping("/check")
	public boolean check (String id) {
		System.out.println(id);
		return service.check(id);
	}
	
	
//	회원가입
	@PostMapping("/signup")
	public String signup(Member vo) {
		service.signup(vo);
		return "redirect:/";
	}
	
	
}
