package com.kh.array.practice3.controller;
import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;


public class BookController {
	
	private Member member = new Member();
	private Book[] bArr = new Book[2];
	public int count = 0;
	
	
	public BookController() {}
	public BookController(Member member, Book[] bArr, int count) {
		super();
		this.member = member;
		this.bArr = bArr;
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
	public int checkBook(String title) {
		
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i] != null && bArr[i].getTitle().equals(title))

			return i;
		}
		return 0;
	}


	public Book[] getbArr() {
		return bArr;
	}

	
	public void setbArr(Book[] bArr) {
		this.bArr = bArr;
	}
	
	
	
	
}
