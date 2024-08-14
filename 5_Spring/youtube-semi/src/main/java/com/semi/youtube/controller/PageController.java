package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.semi.youtube.model.vo.Member;
import com.semi.youtube.model.vo.Subscribe;
import com.semi.youtube.model.vo.Video;
import com.semi.youtube.model.vo.VideoLike;
import com.semi.youtube.service.VideoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
	
	@Autowired
	private VideoService video;
	
	//	비디오 전체 목록 보기
	// 비디오 코드 페이지 이동
	// 메인페이지 이동
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println(video.allVideo());
		model.addAttribute("list", video.allVideo());
		return "index";
	}
	
	// 비디오 한개 보여주기
	// 좋아요 관련 정보 가져오기
	// 구독자수, 구독 관련 정보 가져오기
	@GetMapping("/{videoCode}")
	public String detail(@PathVariable("videoCode") int videoCode, Model model, HttpServletRequest request) {
		
		Video data = video.detail(videoCode);
		
		model.addAttribute("video", data);
		model.addAttribute("list", video.allVideo());
		model.addAttribute("count",video.count(data.getChannel().getChannelCode()));
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		
		VideoLike like = null;
		Subscribe sub = null;
		System.out.println(like);
		
		if(member!=null) {
			like = video.checkLike(VideoLike.builder()
					.id(member.getId())
					.videoCode(videoCode)
					.build());
			System.out.println(like);
			
			sub = video.check(Subscribe.builder()
					.id(member.getId())
					.channelCode(data.getChannel().getChannelCode())
					.build());
					
		}
		model.addAttribute("like", like);
		model.addAttribute("sub", sub);
		
		return "detail";
	}
	
	// 로그인 페이지 이동
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	// 회원가입
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	
	
	

}