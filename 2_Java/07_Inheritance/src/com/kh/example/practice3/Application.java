package com.kh.example.practice3;

import java.util.Scanner;

import javax.swing.text.View;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Employee view = new Employee();
		EmployeeController employeeController = new EmployeeController();
		
		System.out.println("메뉴 번호를 누르세요 : ");
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			System.out.print("1. 사원 정보 추가 : ");
			int menu1 = Integer.parseInt(sc.nextLine());
			break;
		case 2:
			System.out.print("2. 사원 정보 수정 : ");
			int menu2 = Integer.parseInt(sc.nextLine());
			break;
		case 3:
			System.out.print("3. 사원 정보 출력 : ");
			int menu3 = Integer.parseInt(sc.nextLine());
			break;
		case 9:
			System.out.print("9. 프로그램 종료 : ");
			int menu4 = Integer.parseInt(sc.nextLine());
			break;
		}
		
	}

//	저장할 데이터를 사용자에게 받는 메소드 <menu1>
	public void insertEmp() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 이름 : ");
		String name = sc.nextLine();
		System.out.println("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		System.out.println("전화 번호 : ");
		String phone = sc.nextLine();
		System.out.println("추가 정보를 더 입력하시겠습니까?( Y / N ) : ");
		char choice = sc.nextLine().charAt(0);
		System.out.println("사원 연봉 : "); // 조건 출력
		int salary = Integer.parseInt(sc.nextLine());
		System.out.println("보너스 율 : "); // 조건 출력
		double bonus = Integer.parseInt(sc.nextLine()); 
		
	}

//	수정할 데이터를 사용자에게 받는 메소드 <menu2>
	public void updateEmp() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println("1. 전화번호 : ");
		String phone = sc.nextLine();
		System.out.println("2. 사원 연봉 : ");
		int salary = Integer.parseInt(sc.nextLine());
		System.out.println("3. 보너스 율 : ");
		double bonus = Integer.parseInt(sc.nextLine());

		}
		
	}

//	데이터를 출력하는 메소드
//	public void printEmp() {
//		Scanner sc = new Scanner(System.in);
//		
//
//	}
	//메인 메뉴를 출력하는 메소드 리턴값 있음
	//public employeeMenu() {
	//	
//		return 
	//}



