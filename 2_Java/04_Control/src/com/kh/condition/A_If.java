package com.kh.condition;

import java.util.Scanner;

public class A_If {
	Scanner sc = new Scanner(System.in);
	
	/*
	 * if문
	 * 
	 * if(조건식) {
	 * 	조건식이 참(true)일 때 실행 
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * */
	public void method1() {
		
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		System.out.println("성적을 입력하세요");
		int score = sc.nextInt();
		
		if (score >= 60) {
			System.out.println("합격입니다");
		}else{
			System.out.println("불합격입니다");
		}
		
		// 한 줄만 들어갔을 때 유용!
		if (score >= 60) System.out.println("합격입니다");

	}
	/*
	 * if-else문

	 * if(조건식) {
	 * 	조건식이 참(ture)일 때 실행
	 * }else{
	 * 	조건식이 거짓(false)일 때 실행
	 * }
	 * */
	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다",
		// 아니면 "불합격입니다"를 출력
		System.out.println("성적을 입력하세요");
		int score = sc.nextInt();
		
//		if (score >= 60) {
//			System.out.println("합격입니다");
//		}else {
//			System.out.println("불합격입니다");
//		}
//		
		
		// 삼항연산자
		String result = score >= 60 ? "합격입니다" : "불합격입니다";
		System.out.println(result);
		
	}
	
	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.println("name의 주소값 : " + System.identityHashCode(name));
		System.out.println("본인이름의 주소값 : " + System.identityHashCode("서동문"));

		if (name.equals("서동문")) {
			System.out.println("본인입니다");
		} else {
			System.out.println("본인이 아닙니다");
		}
		
	}
	/*
	 * if - else if - else문
	 * 
	 * if(조건식1){
	 * 	조건식1이 참(true)일 때 실행
	 * } else if (조건식2){
	 * 	조건식1이 거짓(false)이면서 조건식2이 참(true)일 때 실행
	 * } else {
	 * 	조건식1, 조건식2 모두 거짓(false)일 때 실행
	 * }
	 * 
	 * - else if는 수가 제한이 없다
	 * */
	public void method4() {
		
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수 출력"
		
		// if else if 문
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();

		if (num == 0) { // if문 중첩 가능! 가급적으로는 좋은 코드는 X
			System.out.println("0입니다");
		} else if (num > 0) {
			System.out.println("양수 입니다");
		} else {
			System.out.println("음수 입니다");
		}

		// 삼항연산자
		String result = num > 0 ? "양수" : num == 0 ? "0이다" : "음수";
		System.out.println(result);
	}
	
	public void pactice1() {
		
		/*
		 * 사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력
		 * 
		 * - 90점 이상은 A 등급
		 * - 90점 미만 80점 이상은 B등급
		 * - 80점 미만 70점 이상은 C등급
		 * - 70점 미만 60점 이상은 D등급
		 * - 60점 미만 F등급
		 * */
		System.out.print("점수(0~100)를 입력하세요 : ");
		int score = sc.nextInt();
		
		String result = "";
		
		if (score >= 90) {
//			System.out.println("A");
			result = "A";
		} else if (score >= 80) {
			result = "B";
//			System.out.println("B");
		} else if (score >= 70) {
			result = "C";
//			System.out.println("C");
		} else if (score >= 60) {
			result = "D";
//			System.out.println("D");
		} else {
			result = "F";
//			System.out.println("F");
		}
		System.out.println(result);
	}
	/*
	 * 세 정수를 입력헀을 때 짝수만 출력
	 * 
	 * num1 = 3
	 * num2 = 4
	 * num3 = 6
	 * 
	 * */
	public void pactice2() {
		System.out.println("정수를 입력하세요");
		int num1 = sc.nextInt();
		System.out.println("정수를 입력하세요");
		int num2 = sc.nextInt();
		System.out.println("정수를 입력하세요");
		int num3 = sc.nextInt();
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		if (num1 % 2 == 0) result1 = num1;
		if (num2 % 2 == 0) result2 = num2;
		if (num3 % 2 == 0) result3 = num3;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
	
	/*
	 * 정수 1개를 입력했을 때 음(minus)/양(plus)/0(zero), 짝(even)/홀(odd) 출력
	 * 
	 * 정수 입력 : -3
	 * minus
	 * odd
	 * */
	public void pactice3() {
		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();
		
		// 양수
		if (num == 0) {
			System.out.println(0);
		} else if (num > 0 && num % 2 == 0) {
			System.out.println("짝수");
			System.out.println("양수");
		} else if (num > 0 && num % 2 != 0) {
			System.out.println("홀수");
			System.out.println("양수");
		}
		// 음수
		if (num < 0 && num % 2 == 0) {
			System.out.println("짝수");
			System.out.println("음수");
		} else if (num < 0 && num % 2 != 0) {
			System.out.println("홀수");
			System.out.println("음수");
		}
	}
	
	public static void main(String[] args) {
		
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.pactice1();
//		a.pactice2();
		a.pactice3();
	}

}