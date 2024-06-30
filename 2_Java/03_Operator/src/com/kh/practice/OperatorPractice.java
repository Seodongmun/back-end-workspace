package com.kh.practice;

import java.util.Scanner;

import com.kh.operator.D_Comparison;

public class OperatorPractice {
    
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		OperatorPractice practice = new OperatorPractice();
		practice.method1();
		practice.method2();
		practice.method3();
		practice.method4();
		practice.method5();
		practice.method6();
		practice.method7();

	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.println("인원수를 입력하세요");
		int people = Integer.parseInt(sc.nextLine());
		System.out.println("연필 개수를 입력하세요");
		int pencle = Integer.parseInt(sc.nextLine());
		
		int haveCount = (pencle / people); // -- 가진 개수
		int pencleCount = (pencle - people); // -- 남은 연필 개수
	
		
		System.out.printf("1인당 가진 연필의 수는%d 개 이고, 남은 연필 수는 %d개 입니다",haveCount,pencleCount);
		System.out.println();
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("수를 입력하세요");
		int num = sc.nextInt();
	
		System.out.println(num / 100 * 100);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("수를 입력하세요");
		int num1 = sc.nextInt();
		System.out.println("수를 입력하세요");
		int num2 = sc.nextInt();
		System.out.println("수를 입력하세요");
		int num3 = sc.nextInt();
		
		String check = num1 == num2 && num2 == num3
						? "true" : "false";
		System.out.println(check);
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("수를 입력하세요");
		int num = sc.nextInt();
		
		String check = num % 2 == 0 
						? "짝수다" : "짝수가 아니다";
		System.out.println(check);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		sc.nextLine();
		System.out.print("주민번호를 입력하세요 : ");
		String input = sc.nextLine();
		// 951208-1184716
		char e = input.charAt(input.length()-6);
		String check = e == '1' || e == '3' ?
						"남자입니다" : "여자입니다";
		System.out.println(check);

	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		
		if(13 >= age) {
			System.out.println("어린이 입니다");
		} else if(13 < age && age <= 19){
			System.out.println("청소년 입니다");
		} else {
			System.out.println("성인 입니다");
		}
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		
		System.out.println("사과의 개수를 입력하세요");
		int apple = sc.nextInt();
		
		System.out.println("바구니의 크기를 입력하세요");
		int buket = sc.nextInt();
		
		int needBuket = apple/buket;
		if (apple % buket != 0) {
			++needBuket;
		}
		System.out.println("필요한 바구니의 개수는" + needBuket + "개 입니다");
		
		
	}
	
}