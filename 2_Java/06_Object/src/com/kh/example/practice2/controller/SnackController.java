package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;
//Snack과 연결

public class SnackController {
	
	// 스낵의 캡슐화된 정보를 사용.
	 private Snack s = new Snack();
	 
	// 컨트롤 내의 클래스에서만 사용하기위해 privat로 지정
	
	
	// 데이터를 setter를 이용해 저장하고 "저장 완료되었습니다" 반환
	// INSERT (DB)
	 
	
	public String saveDate(String kind, String name, String flavor, int numOf, int price) {
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		System.out.println(s);
		return "저장 완료되었습니다";
	}
	
//	저장된 데이터 (saveDate) 를 반환하는 메서드 (결과 화면 확인)
//  SELECT (DB)
	
	public Snack getS() {
		return s;
	}

	public void setS(Snack s) {
		this.s = s;
	}

	public String confirmDate() {
		
		return s.getKind() + " ( " + s.getName() + " - " + s.getFlavor()+ " ) " + s.getNumOf()+ " 개 " +s.getPrice()+ " 원" ;
	}
	
}







