package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.parent.Employee;

/*
 * 다형성(polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 생성하는 것
 * 
 */

public class Application {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Employee e1 = new Employee("우현성", 10000);
		Engineer e2 = new Engineer("이동엽", 5000, "자바", 200);
		Manager m1 = new Manager("윤유진",7000,"개발팀");
		Secretary s1 = new Secretary("송준호", "우현성" ,6000);
		
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(m1);
//		System.out.println(s1);
		
		Employee e3 = new Engineer("이동엽", 5000, "자바", 200);
		Employee m2 = new Manager("윤유진",7000,"개발팀");
		Employee s2 = new Secretary("송준호","우현성" ,6000);
		
		// 다형성 + 객체 배열
		Employee[] empArr = {e1,e3,m2,s2};
		
		
//		for(Employee employee : empArr) {
//			
//			System.out.println(employee);
//		}
	
		
		EmployeeController control = new EmployeeController();
		Employee result = control.findEmployeeByName("윤유진", empArr);
		System.out.println(result);
		
		control.getAnnualSalary(result);
		int resultAnnual = control.getAnnualSalary(result);
		System.out.println(resultAnnual);
		
		System.out.println(control.getTotalSalary(empArr));
	}

}
