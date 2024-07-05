package com.kh.example.practice1.model;

public class Member {
	
	// 캡슐화
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	
	public Member() {}
	public void changeName(String name) {
		
		this.name = name;
		
	}
	
	public void printName() {
		
		System.out.println(name); // this.가 숨겨져있음
		
	}
}

