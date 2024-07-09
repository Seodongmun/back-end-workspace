package com.kh._abstract.step2;

public abstract class Pizza {

	protected int price;
	protected String brand;
	protected String topping;
	
	
	public Pizza(int price, String brand, String topping) {
		super();
		this.price = price;
		this.brand = brand;
		this.topping = topping;
	}
	
	// 피자 만드는 과정
	public abstract void makePizza();
		
}
