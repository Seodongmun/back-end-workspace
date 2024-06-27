package com.kh.practice;

import java.util.Scanner;

import com.kh.variable.B_Casting;

public class VariablePractice {
	
	public static void main(String[] args) {
		VariablePractice sum = new VariablePractice();
		sum.method1();
		sum.method2();
		sum.method3();
		sum.method4();
		sum.method5();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	
	public void method1() {
		int adult = 10000;
		int adultCount = 2;
		int kid = 7000;
		int kidCount = 3;
		System.out.println("--- 1번문제 ---");
		System.out.printf("어른 %d명의 요금는 각%d원이고, 청소년 %d명의 요금은 각%d 원입니다\n"
							,adultCount,adult,kidCount,kid);
		System.out.printf("어른의 총 금액은 %d이고, 청소년의 총 금액은 %d입니다.\n\n"
							,adult*adultCount,kid*kidCount);
	}	
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		int x2 =7;
		int y2 =9;
		int z2 =5;
		System.out.println("--- 2번문제 ---");
		System.out.printf("x=%d\n",x2);
		System.out.printf("y=%d\n",y2);
		System.out.printf("z=%d\n\n",z2);
		
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		Scanner sc = new Scanner(System.in);

		System.out.println("--- 3번문제 ---");
		System.out.print("첫 번째 값을 입력하세요 : ");
		int a = sc.nextInt();
		System.out.print("두번째 값을 입력하세요 : ");
		int b = sc.nextInt();
		System.out.printf("첫번째 값 %d와 두번째 값 %d를 더한 값은 %d 입니다\n",a,b,a+b);
		System.out.print("첫 번째 값을 입력하세요 : ");
		int c = sc.nextInt();
		System.out.print("두번째 값을 입력하세요 : ");
		int d = sc.nextInt();
		System.out.printf("첫번째 값 %d와 두번째 값 %d를 뺀 값은 %d 입니다\n",c,d,c-d);
		System.out.print("첫 번째 값을 입력하세요 : ");
		int e = sc.nextInt();
		System.out.print("두번째 값을 입력하세요 : ");
		int f = sc.nextInt();
		System.out.printf("첫번째 값 %d와 두번째 값 %d를 곱한 값은 %d 입니다\n",e,f,e*f);
		System.out.print("첫 번째 값을 입력하세요 : ");
		int g = sc.nextInt();
		System.out.print("두번째 값을 입력하세요 : ");
		int h = sc.nextInt();
		System.out.printf("첫번째 값 %d와 두번째 값 %d를 나눈 값은 %d 입니다\n",g,h,g+h);
	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		System.out.println("--- 4번문제 ---");
		float width = 13.5F;
		float height = 41.7F;
		float surface = 562.95F;
		float cir = 110.4F;
		System.out.printf("사각형의 면적은 가로 %.1f와 세로%.1f를 곱한 %.1f 입니다\n",width,height,width*height);
		System.out.printf("사각형의 둘레는 (가로 %.1f와 세로%.1f)를 더한 %.1f를 2로 곱한 %.1f입니다\n",width,height,width+height,(width+height)*2);
		
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		System.out.println("--- 5번문제 ---");
		Scanner sc = new Scanner(System.in);
		String apple = "apple";
		String a = "a";
		String p = "p";
		String e = "e";
				
		System.out.printf("문자열을 입력하세요 : ", apple);
		String name = sc.next();
		sc.nextLine();

	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {

	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {

	}

}
