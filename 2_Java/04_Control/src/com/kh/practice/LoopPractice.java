package com.kh.practice;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2(); 
		l.method3(); 
//		l.method4();
//		l.method5();
//		l.method6(); !

	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {

    	System.out.print("숫자(1~100)를 입력하세요 > ");
    	int num = sc.nextInt();
    	
    	for(int i = 0; i < num; num--) {
    		System.out.println(num);
    	}
    	
    }
    // 양수 추가 음수 추가가 1씩 늘어난다.
    // 1+(-2)+3+(-4)+5+(-6)+7+(-8)...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {

//    	1,3,5,7,9 홀수
//    	-2,-4,-6,-8,-10 짝수
		int sum = 0;
		int count = 0;
		for (int i = 1; sum < 100; i++) {
			count++;
			if (i % 2 == 1) {
				sum += i;
			} else {
				sum -= i;
			}
			System.out.println(count);
		}	
    }

    

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 
        문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	
    	System.out.print("문자열을 입력하세요 > ");
    	String input = sc.nextLine();
    	// 문자열을 입력
    	System.out.print("문자를 입력하세요 > ");
    	char ch = input.charAt(0);
    	// 받은 문자열의 문자를 검색.
    	int count = 0;
    	for(int i = 0; i < ch; i++) {
    		count++;
    	}
    	System.out.println(count);
    	

    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {

		while (true) {
			double random = Math.random();
			random = Math.random() * 10 -1;
			System.out.println((int)random);
			if((int)random == 0) {
				System.out.println((int)random);
				break;
			}
		}
    	
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {

		int count = 0;
    	for(int i = 0; i < 6; i++) {
    		double random = Math.random();
    		random = Math.random() * 7 ;
    		count++;
    		System.out.printf("주사위 굴린수 : %d  나온 눈금수 : %d\n",count,((int)random));
    	}
    	
    	
    	
    	
    }

    /*
        사용자의 이름을 입력하고 / 컴퓨터와 가위바위보를 하세요. 
        입력 2개
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고,
        0~3 랜덤값.
        사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
		double random = Math.random();
		random = Math.random() * 3; // 0,1,2 랜덤값
		System.out.println((int)random);

		String scissor = "가위";
    	String rock = "바위";
    	String paper = "보";
    	int comScissor = 0;
    	int comRock = 1;
    	int comPaper = 2;
		
    	while (true) {
		    	System.out.print("이름을 입력하세요 : ");// 이름 입력
		    	String name = sc.nextLine();
		    	System.out.println("가위바위보 : "); // 가위바위보 낼거 입력
		    	String input = sc.nextLine();
		    	

		  
    
    	
    	}
    }
}
//사용자의 이름을 입력하고/ 컴퓨터와 가위바위보를 하세요. 
//컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고,
//사용자에게는 직접 가위바위보를 받으세요.
//사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.