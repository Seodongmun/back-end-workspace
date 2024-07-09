package com.kh.array.practice3.controller;
import java.util.ArrayList;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;


public class BookController {
	private Book[] bArr = new Book[1];
	public int count = 0;


	// 마이페이지 회원정보 조회
	public void memberInfo() {
		Member member = new Member();
		System.out.println(member.getName()); 
		
	}

	// 책 데이터를 저장하는 메소드
	public void modify (String title, boolean coupon, int accessAge) {
		Book book1 = new Book();
		book1.setTitle(title);
		book1.setCoupon(coupon);
		book1.setAccessAge(accessAge);
		
	}
	
	// 멤버 데이터를 저장하는 메소드
	
	public void modify (String name, int age) {
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
	}
	
	
	
	
}
