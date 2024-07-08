package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {
	
	// DB가 없어서 임시 저장공간임!
	private Employee employee = new Employee();
	
	// 데이터 저장하는 메소드 ( 타입이 다른경우 매개변수가 다른경우 ( 오버로딩 ) )
	public void add(int empNo, String name,char gender,String phone) {
		
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		
	}
	
	// 데이터 저장하는 메소드
	// 추가정보 입력 메소드
	public void add(int empNo,String name,char gender,String phone,String dept,int salary,double bonus) {
		
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
		
	}
	
	// 전화번호 정보 수정하는메소드
	public void modify(String phone) {
		
		employee.setPhone(phone);
		
	}
	
	// 사원 연봉 정보 수정하는 메소드
	public void modify(int salary) {
		
		employee.setSalary(salary);
	}
	
	// 보너스 율 정보 수정하는 메소드
	public void modify(double bonus) {
		
		employee.setBonus(bonus);
		
	}
	
//	리턴타입 Employee
//  수정한 set 데이터들을 전부 employee에 저장한뒤 return해준다
//	그래서 return값이 employee
	
	public Employee info() {
		
	 	return employee;
	}
	
	
}
