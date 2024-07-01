package com.kh.practice;

import java.util.Scanner;

import com.kh.loop.C_For;

public class ConditionPractice {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ConditionPractice practice = new ConditionPractice();
//		practice.method1();
//		practice.method2();
//		practice.method3(); --! 
//		practice.method4();
//		practice.method5();
//		practice.method6();
//		practice.method7();
//		practice.method8();
//		practice.method9();
//		practice.method10();
		practice.method11();
	}

    /*
       입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고 짝수가 아니면 "홀수다"를 출력하세요.
       양수가 아니면 "양수만 입력해주세요."를 출력하세요.
    
       숫자를 한 개 입력하세요 : -8
       양수만 입력해주세요.
     */
	public void method1() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		if (num % 2 == 0) {
			System.out.println("짝수다");
		} else if (num < 0) {
			System.out.println("양수만 입력해 주세요");
		} else {
			System.out.println("홀수다");
		}
	}

    /*
        정수 num1과 num2를 입력 받아서 두 수가 같으면 1 다르면 -1을 출력하세요.

        num1 : 2
        num2 : 3
        -1

        num1 : 11
        num2 : 11
        1
     */
    public void method2() {
    	
    	System.out.print("정수입력 : ");
    	int num1 = sc.nextInt();
    	
    	System.out.print("정수입력 : ");
    	int num2 = sc.nextInt();
    	
    	if (num1 == num2) {
    		System.out.println(1);
    	} else {
    		System.out.println(-1);
    	}
    	
    }
    /*
        A 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
        피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요.

        피자 조각 수 : 7
        피자 먹는 사람 수 : 10
        필요한 피자 수 : 2

     */
    public void method3() {
    	
    	System.out.print("피자 조각의 수를 입력하세요 : ");
    	int pizza = sc.nextInt();
    	
    	System.out.print("인원 수를 입력하세요 : ");
    	int people = sc.nextInt();
    	
    	//두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
    	//피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 
    	//한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요
    	
//    	 피자 조각 수 : 7 = 14조각 
//       피자 먹는 사람 수 : 10  피자 나누기 사람.
//       필요한 피자 수 : 2 나머지 값
    	// 한 사람 당 최소 / 한 조각 이상 / 먹으려면 최소 몇 판의 피자
  
    	int needCount = people % pizza;

    	if (pizza / people == 1) {
    		System.out.println(needCount);
    	}else {
    		System.out.println("피자가 부족합니다");
    	}
 
    	
    }
    

    /*
        국어, 영어, 수학 세 과목의 점수를 입력 받고 합계와 평균을 계산하고 합계와 평균을 이용하여 합격 
        / 불합격 처리하는 기능을 구현하세요.
        (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
        합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”
        를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
    
        국어점수 : 88 
        수학점수 : 50 
        영어점수 : 40 
        불합격입니다.

        국어점수 : 88
        수학점수 : 50
        영어점수 : 45
        합계 : 183
        평균 : 61.0
        축하합니다, 합격입니다!
     */
    public void method4() {
    	System.out.print("국어 점수를 입력하세요 : ");
    	int score1 = sc.nextInt();
    	System.out.print("수학 점수를 입력하세요 : ");
    	int score2 = sc.nextInt();
    	System.out.print("영어 점수를 입력하세요 : ");
    	int score3 = sc.nextInt();
    	
    	int average = (score1 + score2 + score3) / 3; // 평균
    	int sum = score1 + score2 + score3; // 합계
    	
		if (40 <= score1 && average >= 60) {
			System.out.println("국어 점수 : " + score1);
			System.out.println("수학 점수 : " + score2);
			System.out.println("영어 점수 : " + score3);
			System.out.println("총점 : " + sum);
			System.out.println("축하합니다, 합격입니다");
			System.out.println("평균점수 : " + average);
		} else if (score1 <= 40 || score2 <= 40 || score3 <= 40) {
			System.out.println("국어 점수 : " + score1);
			System.out.println("수학 점수 : " + score2);
			System.out.println("영어 점수 : " + score3);
			System.out.println("불합격입니다");
		}

    }

    /*
        B 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만원 이상 사면 20%를 할인해준다.
        구매한 옷의 가격을 입력했을 때, 지불해야 할 금액을 출력하세요.
        
        구매한 옷 가격 : 580000
        464000
     */
    public void method5() {
    	System.out.println("금액을 입력하세요 : ");
    	int money = sc.nextInt();
    	// 10만 원 이상 사면 5%
    	// 30만 원 이상 사면 10%
    	// 50만원 이상 사면 20% 할인

		int result = 0;
		if (100000 <= money && money < 300000) {
			result = (int) (((money * 0.05) - money) * -1);
			System.out.println(result);
		} else if (300000 <= money && money < 500000) {
			result = (int) (((money * 0.10) - money) * -1);
		} else if (money >= 500000) {
			result = (int) (((money * 0.20) - money) * -1);
		}

		System.out.println("지불해야할 금액은 : " + result + " 입니다");
	}

    /*
        각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류한다.
        입력받은 각에 따라 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 출력하세요.
     */
    public void method6() {
    	
    	System.out.println("각을 입력하세요 : ");
    	int num = sc.nextInt();
    	
//    	0도 초과 90도 미만은 예각 = 1
//    	90도는 직각 = 2
//    	90도 초과 180도 미만은 둔각 = 3
//    	180도는 평각 = 4
    	
    	if (0 < num && num < 90) {
    		System.out.println("예각 입니다 (1)");
    	}else if (num == 90) {
    		System.out.println("직각 입니다 (2)");
    	}else if (90 < num && num < 180) {
    		System.out.println("둔각 입니다 (3)");
    	}else if (num == 180) {
    		System.out.println("평각 입니다 (4)");
    	}else {
    		System.out.println("180도 초과입니다");
    	}
    	
    }


    /*
       아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
       로그인 성공 시 "로그인 성공", 
       아이디가 틀렸을 시 "아이디가 틀렸습니다.",
       비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다.",
       아이디와 비밀번호 둘 다 틀렸을 시 "로그인 실패" 를 출력하세요.

       아이디 : happy
       비밀번호 : 1234
       로그인 성공!

       아이디 : happy
       비밀번호 : 23467
       비밀번호가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 1234
       아이디가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 23456
       로그인 실패
    */
    public void method7() {
//    	 아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
//         로그인 성공 시 "로그인 성공", 
//         아이디가 틀렸을 시 "아이디가 틀렸습니다.",
//         비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다.",
//         아이디와 비밀번호 둘 다 틀렸을 시 "로그인 실패" 를 출력하세요.
    	System.out.println("아이디를 입력하세요");
    	String id = sc.nextLine();
    	System.out.println("비밀번호를 입력하세요");
    	int pwd = sc.nextInt();
    	
    	if (id.equals("happy") && pwd == 1234) {
    		System.out.println("로그인 성공");
    	} else if (id != ("happy")) {
    		System.out.println("아이디가 틀렸습니다");
    	} else if (pwd != 1234) {
    		System.out.println("비밀번호가 틀렸습니다");
    	}
    	
    	
    	
    }

    /*
        키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 저체중 / 정상체중 / 과체중 / 비만을 출력하세요.
        BMI = 몸무게 / (키(cm) * 키(cm)) * 10000 
        BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
        BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
        
        BMI가 30이상일 경우 고도 비만
        키(cm)를 입력해 주세요 : 162
        몸무게(kg)를 입력해 주세요 : 46
        BMI 지수 : 17.527815881725342
        저체중
     */
    public void method8() {
    	System.out.println("키를 입력하세요");
    	double height = sc.nextDouble();
    	System.out.println("몸무게를 입력하세요");
    	double Weight = sc.nextDouble();
    	
//    	BMI = 몸무게 / (키(cm) * 키(cm)) * 10000 
//      BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
//      BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
    	
    	double bmi = (Weight / (height * height)) * 10000;
    	if (bmi < 18.5) { // 18.5 미만
    		System.out.println("저체중 입니다");
    	}else if (18.5 <= bmi && bmi < 23) { // 18.5 이상 23 미만
    		System.out.println("정상체중 입니다");
    	}else if (23 <= bmi && bmi < 25) { // 23 이상 25 미만
    		System.out.println("과체중 입니다"); 
    	}else if (25 <= bmi && bmi > 30) { // 25이상 30미만
    		System.out.println("비만 입니다");
    	}else {
    		System.out.println("고도비만 입니다"); // 30 이상
    	}
    	
    	System.out.printf("키는 %.1f 입니다\n",Weight);
		System.out.printf("몸무게는 %.1f 입니다\n",height);
		System.out.printf("BMI 지수는 %.1f 입니다\n",bmi);
    	
    	

    }

    /*
        두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
        (단, 양수가 아닌 값을 입력하거나 제시되어 있지 않은 연산 기호를 입력 했을 시 
        "잘못 입력하셨습니다. 프로그램을 종료합니다." 출력)

        숫자 입력 : 15
        숫자 입력 : 4
        연산자를 입력(+,-,*,/,%) : /
        15 / 4 = 3

     */
    public void method9() {
    	System.out.println("양수를 입력하세요");
    	int num1 = sc.nextInt();
    	System.out.print("기호를 입력하세요");
    	sc.nextLine();
    	char giho = sc.nextLine().charAt(0);
    	System.out.println("양수를 입력하세요");
    	int num2 = sc.nextInt();
    	
		if (giho == '+' && num1 > 0 && num2 > 0) {
			System.out.println(num1 + num2);
		} else if (giho == '-') {
			System.out.println(num1 - num2);
		} else if (giho == '*') {
			System.out.println(num1 * num2);
		} else if (giho == '/') {
			System.out.println(num1 / num2);
		} else if (giho == '%') {
			System.out.println(num1 % num2);
		} else {
			System.out.println("잘못입력하였습니다.");
		}

    }

    /*
      아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를, 종료 번호를 누르면 “프로그램이 종료됩니다.”를 출력하세요

        1. 입력
        2. 수정
        3. 조회
        4. 삭제
        9. 종료
        메뉴 번호를 입력하세요 : 3
        조회 메뉴입니다.
     */
    public void method10() {

		System.out.println("1. 입력");

		System.out.println("2. 수정");

		System.out.println("3. 조회");

		System.out.println("4. 삭제");

		System.out.println("5. 종료");

		System.out.println("메뉴 번호를 입력하세요 : ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.println("입력 메뉴입니다");
			break;
		case 2:
			System.out.println("수정 메뉴입니다");
			break;
		case 3:
			System.out.println("조회 메뉴입니다");
			break;
		case 4:
			System.out.println("삭제 메뉴입니다");
			break;
		case 9:
			System.out.println("프로그램이 종료됩니다");
			break;
		default:
			System.out.println("잘못 입력하였습니다");

		}

	}

    /*
        중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
        총점 100점 중 배점으로는 다음과 같다.
        중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)

        이때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력

        총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
        아니면 Fail을 출력하세요.

        중간 고사 점수 : 80
        기말 고사 점수 : 90
        과제 점수 : 50
        출석 횟수 : 15
        ===========결과==========
        중간 고사 점수(20) : 16.0
        기말 고사 점수(30) : 27.0
        과제 점수 (30) : 15.0
        출석 점수 (20) : 15.0
        총점 : 73.0
        PASS

        중간 고사 점수 : 80
        기말 고사 점수 : 30
        과제 점수 : 60
        출석 횟수 : 18
        ===========결과==========
        FAIL [점수 미달] (총점 61.0)

        중간 고사 점수 : 90
        기말 고사 점수 : 100
        과제 점수 : 80
        출석 횟수 : 13
        ===========결과==========
        FAIL [출석 횟수 부족] (13/20)

        중간 고사 점수 : 100
        기말 고사 점수 : 80
        과제 점수 : 40
        출석 횟수 : 10
        ===========결과==========
        FAIL [출석 횟수 부족] (10/20)
        FAIL [점수 미달] (총점 66.0)

     */
    public void method11() {
//        중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
//        총점 100점 중 배점으로는 다음과 같다.
//        중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
//
//        이때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력
//
//        총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
//        아니면 Fail을 출력하세요.
    	  System.out.println("중간고사 점수");
    	  double num1 = sc.nextDouble();
    	  
    	  System.out.println("기말고사 점수");
    	  double num2 = sc.nextDouble();
    	  
    	  System.out.println("과제 점수");
    	  double num3 = sc.nextDouble();
    	  
    	  System.out.println("출석 횟수");
    	  double num4 = sc.nextDouble();
    	  
//    	  배점 = 중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
//    	  출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력
//    	  총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass

			double result1 = (((num1 / 20) * 100) / 100);
			double result2 = (((num2 / 30) * 100) / 100);
			double result3 = (((num3 / 30) * 100) / 100);
			double result4 = (((num4 / 20) * 100) / 100);
			double sum = result1 + result2 + result3 + result4;
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
			System.out.println(sum);
    	  
    	  
    	  
    	  
    	
    }
    
    
    
    
    
    
    
    
    
    
}