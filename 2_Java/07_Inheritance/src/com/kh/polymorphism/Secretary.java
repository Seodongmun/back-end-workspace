package com.kh.polymorphism;

import com.kh.polymorphism.model.parent.Employee;

public class Secretary extends Employee{
	
	private String boss;

	public Secretary() {
	}

	public Secretary(String boss,String name, int salary) {
		super(name, salary);
		this.boss = boss;
	}
	

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	@Override
	public String toString() {
		return "Secretary [boss=" + boss + ", getName()=" + getName() + ", getSalary()=" + getSalary() + "]";
	}
	
	

}
