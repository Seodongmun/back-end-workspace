package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Engineer extends Employee {
	
	
	private String tech;
	private int bonus;
	public Engineer() {
	}
	public Engineer(String name ,  int bonus , String tech, int salary) {
		super(name, salary);
		this.tech = tech;
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Engineer [tech=" + tech + ", bonus=" + bonus + ", getName()=" + getName() + ", getSalary()="
				+ getSalary() + "]";
	}
	
	
	
	
}
