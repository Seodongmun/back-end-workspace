package com.kh.overriding.model;

public class VIPCustomer extends Customer {
	
	private double saleRatio; // 할인율

	public VIPCustomer(String name) {
		
		// 접근제한자가 protected
		this.name = name;
		this.grade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.1;
		
		
	}

	@Override
	public String toString() {
		return "VIPCustomer [saleRatio=" + saleRatio + ", name=" + name + ", grade=" + grade + ", bonusPoint="
				+ bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
	/*
	 * 오버라이딩의 조건
	 * - 부모 클래스의 메서드명, 매개변수, 리턴타입 모두 동일
	 * - 접근제어자를 좁은 범위로 변경할 수 없다.
	 * 	-> 부모 클래스 매서드가 protected라면,
	 * 	   범위가 같거나 넓은 protected나 public으로만 변경 가능
	 * 
	 * @Override (어노테이션)
	 * - 명시 안 해줘도 오버라이딩
	 * - 어노테이션을 붙이는 이유
	 * 		- 해당 메서드가 오버라이딩 된 메서드라는 것을 컴퍼일러에게 알려주는 역할
	 * 		- 자식 메서드에서 재정의를 잘못한 경우 컴파일 에러 표시
	 * */
	
	@Override
	public int calcPrice(int price) {
		this.bonusPoint += price * bonusRatio;
		return  (price - (int)(price * saleRatio));
	}
	
	
	
	
	
	
	
	
	
	
}


















