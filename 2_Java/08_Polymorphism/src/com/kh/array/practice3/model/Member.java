package com.kh.array.practice3.model;

import java.util.Arrays;

public class Member {
	
	private String name;
	private int age;
	private int coupon; // 쿠폰 보유 개수
	private int bookList[]; // 배열 2개
	

	public Member() {}
	public Member(String name, int age, int coupon, int[] bookList) {
		super();
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public int[] getBookList() {
		return bookList;
	}
	public void setBookList(int[] bookList) {
		this.bookList = bookList;
	}
	
	


}
