package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.semi.youtube.service.VideoService;

@Controller
public class PageController {
	
	@Autowired
	private VideoService video;
	
	// 메인페이지 이동
	@GetMapping("/")
	public String index(Model model) {
		System.out.println(video.allVideo());
		model.addAttribute("list", video.allVideo());
		return "index";
	}
	
	// 비디오 코드 페이지 이동
	@GetMapping("/{videoCode}")
	public String detail(@PathVariable("videoCode") int videoCode, Model model) {
		model.addAttribute("video", video.detail(videoCode));
		model.addAttribute("list", video.allVideo());
		return "detail";
	}
	
	// 로그인 페이지 이동
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
	
	

}