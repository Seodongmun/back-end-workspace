package com.kh.operator;

public class C_Arithmetic {
	
	/*
	 * 산술 연산자 
	 *  + : 더하기
	 *  - : 빼기
	 *  * : 곱하기
	 *  / : 나누기
	 *  % : 나머지
	 * */

	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();
	}
	
	public void method1() {

		int num1 = 10;
		int num2 = 3;

		System.out.println(" + : " + (num1 + num2)); // 13
		System.out.println(" - : " + (num1 - num2)); // 7
		System.out.println(" * : " + (num1 * num2)); // 30
		System.out.println(" / : " + (num1 / num2)); // 3
		System.out.println(" % : " + (num1 % num2)); // 1
		
		
	}
	public void method2() {
		
		int a = 5;
		int b = 10;
		int c = (++a) + b; //		a6 + b10 , c16 
		int d = c / a; //  			16 / 6 = d2
		int e = c % a; // 			16 % 6 = e4
		int f = e++; // 			f4 = e5
		int g = (--b) + (d--); //	b9 , g11 ,d1 
		int h = c-- * b; // 		h144 , c15
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		// 6 + 9 / (14 / 4) * (11 - 1) % (6 + 144)
		// 6 + 9 / 3 * 10 % 150
		// 6 + 3 * 10 % 150
		// 6 + 30 % 150
		// 6 + 30 = 36
		// / * % 
		System.out.println(i);
		
		
	}
	

}
