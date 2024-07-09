package com.kh._abstract.step2;

public class PineApplePizza extends Pizza {

	public PineApplePizza(int price, String brand, String topping) {
		super(price, brand, topping);
	}

	@Override
	public void makePizza() {
		System.out.println(this.brand + "의 " + this.topping + " 가격은 " + this.price + "원");
		System.out.println("피자 반죽과 함께 도우를 빚다.");
		System.out.println("토핑은 " + this.topping + "을 포함시킨다.");
		System.out.println("피자를 180도에서 10분간 구운다.");
		System.out.println("피자를 8등분으로 자른다.");
		System.out.println("피자를 포장한다.");

	}
	
//	public abstract void info();
//	public abstract void 
	
	
	
//	 * 잭슨피자의 파인애플피자 가격은 10000원
//	 * 피자 반죽과 함께 도우를 빚다.
//	 * 토핑은 파인애플을 포함시킨다.
//	 * 피자를 180도에서 10분간 구운다.
//	 * 피자를 8등분으로 자른다.
//	 * 피자를 포장한다.

}
