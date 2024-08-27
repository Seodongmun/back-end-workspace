package com.kh.service;

import java.sql.SQLException;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

//	회원가입
	public void memberRegister(Member vo) throws SQLException {
		dao.memberRegister(vo.getId(), vo.getPassword(), vo.getName());
	}
	
//	로그인
	public Member login(Member vo) throws SQLException {
		return dao.login(vo.getId(), vo.getPassword());
	}
	
//	회원검색
	public Member searchMember(String id) throws SQLException {
		return dao.searchMember(id);
	}
	
//	전체회원검색
	public ArrayList<Member> allMember() throws SQLException {
		return dao.allMember();
	}
	
}









