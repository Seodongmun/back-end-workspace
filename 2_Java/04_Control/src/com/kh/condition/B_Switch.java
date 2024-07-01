package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 *  switch문
	 *  
	 *  switch(조건식){
	 *  	case 값1 : 
	 *  		조건식의 결과가 값1과 같은 경우 실행
	 *  		break;
	 *  	case 값2 : 
	 *  		조건식의 결과가 값2와 같은 경우 실행
	 *  		break;
	 *  	default :
	 *  		조건식의 결과가 일치하는 case문이 없을 때 실행
	 *  }
	 *  
	 *  - case 문의 수는 제한이 없다.
	 *  - 조건식 결과는 정수, 문자, 문자열이어야 한다
	 *  - 조건문을 빠져나가려면 break가 필요하다
	 *  - default 문은 생략 가능하다
	 * */
	public void method1() {
		
		/*
		 * 숫자를 입력받아
		 * 1일 경우 "빨간색입니다"
		 * 2일 경우 "파란색입니다"
		 * 3일 경우 "초록색입니다"
		 * 잘못입력했을 경우 "잘못입력했습니다"
		 * */
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		switch (num) {
			case 1: System.out.println("빨간색입니다");
					break;
			case 2: System.out.println("파란색입니다");
					break;	
			case 3: System.out.println("초록색입니다");
					break;		
			default : System.out.println("잘못입력했습니다");
		}
		
	}
	/*
	 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력 (그 외에는 "사람이 아니다")
	 * 주민번호 입력 : 100000-3100000
	 * 남자 1,3
	 * 여자 2,4
	 * 
	 * */
	public void practice1() {
		
		System.out.println("주민번호를 입력하세요 (-포함)");
		char gender = sc.nextLine().charAt(7);
		
		// String.valueOf : 문자열로 변환
		// Integer.parseInt : 정수로 변환
		switch (Integer.parseInt(String.valueOf(gender))) {
		case 1 :
		case 3 : System.out.println("남자입니다");
			break;
		case 2 :
		case 4 : System.out.println("여자입니다");
			break;
		default : System.out.println("사람이 아닙니다");
		}
	}
	/*
	 * 등급별 권한
	 * 1. 관리권한, 글쓰기권한, 읽기권한
	 * 2. 글쓰기권한, 읽기권한
	 * 3. 읽기권한
	 * 
	 * 등급 입력 : 1
	 * 관리권한
	 * 글쓰기 권한
	 * 읽기 권한
	 * */
	public void practice2() {

		System.out.print("등급을 입력하세요 : ");
		int level = sc.nextInt();

		switch (level) {
		case 1:
			System.out.println("관리권한");
		case 2:
			System.out.println("글쓰기권한");
		case 3:
			System.out.println("읽기권한");
			break;
		default:
			System.out.println("권한이 없습니다");
		}

	}
	
	public static void main(String[] args) {
		
		B_Switch b = new B_Switch();
//		b.method1();
//		b.practice1();
		b.practice2();
	}

}
