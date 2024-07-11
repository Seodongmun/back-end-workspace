package com.kh.array.practice3.controller;
import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;


public class BookController {
	
	private Member member = new Member();
	public int count = 0;
	
	
	
	public BookController() {
	}


	public BookController(Member member, int count) {
		super();
		this.member = member;
		this.count = count;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	// 마이페이지 회원정보 조회
	public void memberInfo(String name, int age, int coupon) {
		// member에서 private 회원정보 set
		member.getName();
		member.getAge();
		member.getCoupon();
		
	}

	
//	 중복된 대여된 책


	
	
	
}
