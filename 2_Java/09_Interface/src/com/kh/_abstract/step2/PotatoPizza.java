package com.kh._abstract.step2;

public class PotatoPizza extends Pizza {

	public PotatoPizza(int price, String brand, String topping) {
		super(price, brand, topping);
	}

	@Override
	public void makePizza() {
		System.out.println(this.brand + "의 " + this.topping + " 피자 가격은 " + this.toping + "원");
		System.out.println("피자 반죽과 함께 도우를 빚다.");
		System.out.println("토핑은 " + this.topping + "를 포함시킨다.");
		System.out.println("피자를 180도에서 10분간 구운다.");
		System.out.println("피자를 8등분으로 자른다.");
		System.out.println("피자를 포장한다.");

	}
	
//	public abstract void info();
//	public abstract void topping();
	
//	 * 도미노피자의 포테이토 피자 가격은 20000원
//	 * 피자 반죽과 함께 도우를 빚다.
//	 * 토핑은 감자를 포함시킨다.
//	 * 피자를 180도에서 10분간 구운다.
//	 * 피자를 8등분으로 자른다.
//	 * 피자를 포장한다.
}
