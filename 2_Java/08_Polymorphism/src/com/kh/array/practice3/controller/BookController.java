package com.kh.array.practice3.controller;
import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;


public class BookController {
	
	private Member member = new Member();
	private Book[] bArr = new Book[1];
	public int count = 0;
	
	
	// 마이페이지 회원정보 조회
	public void MemberInfo(String name, int age, int coupon, int[] bookList) {
		
		// member에서 private 회원정보 set
		member.setName(name);
		member.setAge(age);
		member.setCoupon(coupon);
		member.setBookList(bookList);
	}
	
	
	
	
}
