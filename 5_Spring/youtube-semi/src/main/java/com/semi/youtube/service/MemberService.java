package com.semi.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.semi.youtube.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	// 중복체크
	public boolean check(String id) {
		Member vo = mapper.check(id);
		// 멤버 vo가 null 일경우만 return true
		if (vo!=null) return true;
		
		return false;
		
	}
	
//	 로그인
	public Member login(Member vo) {
		
		return mapper.login(vo);
	
	}
	
	// 회원가입
	public void signup(Member vo) {
		// System.out.println("암호화 전 : " + vo.getPassword());
		// System.out.println("암호화 후 : " + bcpe.encode(vo.getPassword()));
		// 암호화 된 비밀번호로 저장
		vo.setPassword(bcpe.encode(vo.getPassword()));

		mapper.signup(vo);
		
	}
	
	
}




