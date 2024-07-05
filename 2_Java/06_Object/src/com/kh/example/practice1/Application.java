package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {
		
		Member member = new Member(); // 객체생성
		
		member.changeName("김동문");
		// 주소값만 출력됨
		member.printName();

	}

}
