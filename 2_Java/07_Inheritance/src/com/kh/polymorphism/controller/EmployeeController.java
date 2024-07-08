package com.kh.polymorphism.controller;

import java.util.Scanner;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {
	
	private Employee employee = new Employee();
	

//이름으로 사람 찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		
		for (int i = 0; i < empArr.length; i++) {
			if(empArr[i].getName().equals(name));
			// empArr 배열의[i]번째 길이만큼 getName에 있는 사원 정보
			return empArr[i];
			
			
		}
		
		return null;
		
	}

// 찾는 사람의 연봉은?
	public int getAnnualSalary(Employee e) {
		
		if(e instanceof Engineer) { // 특정 (Engineer만)자식 객체 찾는 방법!
			Engineer engineer = (Engineer) e;
//			return getSalary()* 12 + engineer.getBonus();
		}
		return e.getSalary()* 12;
	}

// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
		
		int sum = 0;
		for(Employee employee : empArr) {
			sum += getAnnualSalary(employee);
			
		}
		return sum;
		
	}
	
	
	
	
	
	
	
	
	
	
}