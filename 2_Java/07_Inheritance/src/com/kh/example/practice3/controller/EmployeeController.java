package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {
	
	private Employee employee = new Employee();
	
	// 데이터 저장하는 메소드
	public void add(int empNo, String name,char gender,String phone) {
		
		employee.setEmpNo(empNo);
		employee.setName(phone);
		employee.setGender(gender);
		employee.setPhone(phone);

	}
	
	// 데이터 저장하는 메소드
	// 추가정보 입력 메소드
	public void add(int empNo,String name,char gender,String phone,String dept,int salary,double bonus) {
		
		employee.setEmpNo(empNo);
		employee.setName(phone);
		employee.setGender(gender);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);

	}
	
	// 전화번호 정보 수정하는메소드
	public void modify(String phone) {
		
		
	}
	
	// 사원 연봉 정보 수정하는 메소드
	public void modify(int salary) {
		
	}
	
	// 보너스 율 정보 수정하는 메소드
	public void modify(double bonus) {
		
	}
	
//	데이터 정보 메소드
//	public info() {
//		
//		employee.getEmpNo();
//		employee.getName();
//		employee.getGender();
//		employee.getPhone();
//		employee.getDept();
//		employee.getSalary();
//		employee.getBonus();
//		
//	}
	
	
}
