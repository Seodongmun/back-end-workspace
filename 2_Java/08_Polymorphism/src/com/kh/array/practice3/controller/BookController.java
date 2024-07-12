package com.kh.array.practice3.controller;
import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;


public class BookController {
	
	private Member member = new Member();
	public int count = 0;
	
//  내 정보 추가하는 기능 필요
	public void addMember(String name , int age) {
		member.setName(name);
		member.setAge(age);
	}
	
//  member에서 private 회원정보 set
//	마이페이지 기능
	public void memberInfo(String name, int age, int coupon) {
		member.getName();
		member.getAge();
		member.getCoupon();
		
	}


}
