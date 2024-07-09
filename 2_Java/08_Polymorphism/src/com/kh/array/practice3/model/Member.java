package com.kh.array.practice3.model;

import java.util.Arrays;

public class Member {
	// 회원 정보
	private String name;
	private int age;
	private int coupon; // 쿠폰 보유 개수
	

	public Member() {}
	public Member(String name, int age, int coupon) {
		super();
		this.name = name;
		this.age = age;
		this.coupon = coupon;
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
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + "]";
	}
	
	


}
