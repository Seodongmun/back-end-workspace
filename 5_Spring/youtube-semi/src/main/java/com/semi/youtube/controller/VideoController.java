package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.model.vo.Member;
import com.semi.youtube.model.vo.Video;
import com.semi.youtube.model.vo.VideoLike;
import com.semi.youtube.service.VideoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService video;
	
//	좋아요
	@ResponseBody
	@PostMapping("/like")
	public String like(HttpServletRequest request, int code) {
		// 세션으로 컨트롤 ===================================
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		VideoLike data = VideoLike.builder()
		.id(member.getId())
		.videoCode(code)
		.build();
		video.like(data);
		// 토큰으로 컨트롤 ===================================
		Authentication authentication = SecurityContextHolder
										.getContext()
										.getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Member memberLike = (Member) authentication.getPrincipal();
			System.out.println("로그인 여부 : " + memberLike.getId());
			if (!memberLike.getId().equals("")) { 
				// 리턴 값을 select 해서 video_like 테이블에 + 되게
				return "detail";
			}	
		
		}
		return "/";
//		return "redirect:/detail";
		// ================================================
	}
	
//	좋아요 취소
	@ResponseBody
	@PostMapping("/unlike")
	public void unlike(int code) {
		video.unlike(code);
	}
	
	
	
//	댓글 작성
	
//	댓글 수정
	
//	댓글 삭제
	

	

	
//	구독
	
//	구독 취소
	
	
	
	
	
}
