package com.kh.mybatis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;
//xml -> Mapper -> service -> controller
@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	public void register(Member member) {
		mapper.register(member);
	}
	
	public List<Member> allMember() {
		return mapper.allMember();
	}
	
	public Member login(Member member) {
		return mapper.login(member);
	}
	
	public void update(Member member) {
		System.out.println("서비스단 맴버 정ㅂ ㅗ확인" + member);
		mapper.update(member);
	}
	
	public List<Member>search(SearchDTO dto) {
		return mapper.search(dto);
	}
	
	public void delete(List<String> idList) {
		mapper.delete(idList);
	}

	public Member memberInfo(Member vo) {
		return mapper.memberInfo();
	}
	
	
}
















