package com.kh.practice;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2(); 
//		l.method3(); 
//		l.method4();
//		l.method5();
		l.method6(); 

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
    	
//    	for(int i = num; i >= 1; i--) {
//    		System.out.println(i);
//    	}
    	
    }
    
    
    // 양수 추가 음수 추가가 1씩 늘어난다.
    // 1+(-2)+3+(-4)+5+(-6)+7+(-8)...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	
//    	1,3,5,7,9 홀수
//    	-2,-4,-6,-8,-10 짝수
//		int sum = 0;
//		int count = 0;
//		for (int i = 1; sum < 100; i++) {
//			count++;
//			if (i % 2 == 1) {
//				sum += i;
//			} else {
//				sum -= i;
//			}
//			System.out.println(count);
//		}	
    	int sum = 0;
//    	int num = 1;
    	int num = 0;
    	
    	while(sum < 100) {
    		num++;
    		if(num % 2 == 0) {
    			sum -= num;
    		}else {
    			sum += num;
    		}
    		
    		/*
    		if(sum >= 100) {
    			System.out.println(num);
    			break;
    		}
    		*/
    		
    	} 
    	System.out.println(num);

    }

    /*
        사용자로부터 문자열을 입력 / 받고 문자열에서 검색될 문자를 입력 / 받아 해당 
        문자열에 그 문자가 몇 개 있는지 개수 / 를 출력하세요. 

        문자열 : banana
        banana 안에 포함된 a 개수 : 3
    */
    public void method3() {
    	// 문자열을 입력
    	System.out.print("문자열을 입력하세요 > ");
    	String input = sc.nextLine();
    	// 문자 입력
    	System.out.print("문자를 입력하세요 > ");
    	char ch = sc.next().charAt(0);
    	
    	// 받은 문자열의 문자를 검색.
    	// input 문자열
    	// chInput 문자 의 개수. <-- 반복문 돌릴거
    	
    	int count = 0;
//    	for(int i = 0; i < input.length(); i++) {
//    		if(input.charAt(i) == ch) {
//    			count++;
//    		}
//    	
//    	}
    	
    	for(char s : input.toCharArray()) {
    		if(ch == s) count++;
    	}
    	System.out.println(input + " 안에 포함된 " +
    					ch + " 개수 : " + count);
    	
    

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

//		while (true) {
//			double random = Math.random();
//			random = Math.random() * 11;
//			System.out.println((int)random);
//			if((int)random == 0) {
//				break;
//			}
//		}
    	while(true) {
    		int random = (int)(Math.random() * 11);
    		System.out.println(random);
    		if(random == 0) break;
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

//		int count = 0;
//    	for(int i = 0; i < 10; i++) {
//    		double random = Math.random();
//    		random = Math.random() * 7;
//    		count++;
//    		System.out.printf("주사위 굴린수 : %d  나온 눈금수 : %d\n",count,((int)random));
//    	}
    	int[] dice = new int[6];
    	
    	for(int i = 0; i < 10; i++) {
    		// 이 부분 이해 가지 않으시다면 switch나 if 조건문 활용하고 나서!
    		int random = (int) (Math.random()*6); // 1 ~ 6 - > 0 ~ 5
    		// -- > random : 1(0) -- > dice[0]
    		// -- > random : 2(1) -- > dice[1]
    		dice[random]++;
    	} 
    	
    	for(int i = 0; i < dice.length; i++) {
    		System.out.println((i+1) + " : " + dice[i]);
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

    	String[] rps = {"가위","바위","보"};
    	int win = 0;
    	int lose = 0;
    	int draw = 0;
	   	System.out.print("이름을 입력하세요 : ");// 이름 입력
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.printf("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		// 0 - 가위, 1 - 바위, 2 - 보
    		int computer = (int)(Math.random() * 3 );
    		System.out.println("컴퓨터 : " + rps[computer]);
    		
    		System.out.println(name + " : " + input);
    		
    		// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로!
    		int number = Arrays.asList(rps).indexOf(input);
    		
    		if(computer == number) {
    			// 비겼을 경우
    			draw++;
    			System.out.println("비겼습니다.");
    		}else if((number == 0 && computer == 2)
    				||(number == 1 && computer == 0)
    				||(number == 2 && computer == 1)){
    			// 이겼을 경우
    			win++;
    			System.out.println("이겼습니다!");
    			break;
    		}else {
    			// 졌을 경우
    			lose++;
    			System.out.println("졌습니다 ㅠㅠ");
    		}

    	}
    	
    	System.out.println("비긴 횟수 : " + draw + ", 진 횟수 : " 
    						+ lose + ", 이긴 횟수 : " + win);
    	
    	
    	

    	
    	
//    	String com1 = "";
//    	String com2 = "";
//    	String com3 = "";
//    	int winCount = 0;
//		int loseCount = 0;
//		int sameCount = 0;
//		while (true) {
//			System.out.printf("가위바위보 : "); // 가위바위보 낼거 입력
//	    	String input = sc.nextLine();
//	    	System.out.println(name + " : " + input);
//	    	double random = Math.random();
//			random = Math.random() * 3; // 0,1,2 랜덤값
//			// 컴퓨터가 낸 랜덤값 0,1,2 를 가위바위보로
//			switch ((int) random) {
//				case 0:
//					com1 = "가위";
//					System.out.println("컴퓨터 : " + com1);
//					break;
//				case 1:
//					com2 = "바위";
//					System.out.println("컴퓨터 : " + com2);
//					break;
//				case 2:
//					com3 = "보";
//					System.out.println("컴퓨터 : " + com3);
//					break;
//			}
//			String comChoice = (String) (com1+com2+com3);
//			// 비긴경우
//			if (input.equals(comChoice)) {
//				System.out.println("비겼습니다");
//				sameCount++;
//			// 이긴경우
//			} else if (input.equals("바위") && com1.equals("가위")|| // 컴퓨터 첫번째 선택
//					  (input.equals("보") && com2.equals("바위") || // 컴퓨터 두번째 선택
//					  (input.equals("가위") && com3.equals("보")))) { // 컴퓨터 세번째 선택
//				System.out.println("이겼습니다!");
//				System.out.printf(name + " : ");
//				winCount++;
//				break;
//			// 진 경우
//			} else {
//				System.out.println("졌습니다 ㅠ");
//				loseCount++;
//				continue;
//			}
//		}
//
//		System.out.printf("비긴횟수 %d, 진 횟수 %d, 이긴 횟수 %d,"
//				,sameCount,loseCount,winCount);

	}
}
