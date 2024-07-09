package com.kh.array.practice3.model;

public class Book {
	
	// 책 정보
	private String title;  // 타이틀
	private boolean coupon;// 쿠폰 true / false
	private int accessAge; // 연령제한
	
	public Book() {
	}
	public Book(String title, boolean coupon, int accessAge) {
		super();
		this.title = title;
		this.coupon = coupon;
		this.accessAge = accessAge;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCoupon() {
		return coupon;
	}
	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}
	public int getAccessAge() {
		return accessAge;
	}
	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}
	
	

	
	
	
}
