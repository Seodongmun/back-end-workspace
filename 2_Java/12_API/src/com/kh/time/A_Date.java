package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class A_Date {
	
	/*
	   Date
	   - java.util 패키지에 속한 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
	   - Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 * */
	
	public void method1() {
		
//		기본 생성자로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체 생성
		Date today = new Date();
		System.out.println(today); // Thu Jul 11 11:46:09 KST 2024

		Date when = new Date(0);
		System.out.println(when); // Thu Jan 01 09:00:00 KST 1970
		
		System.out.println("getTime : " + today.getTime()); // 1720666157835 when의 날짜로부터 지금까지의 값
		
//		Deprecated된 기능들!
		System.out.println("getYear : " + (today.getYear() + 1900 + "년"));
		System.out.println("getMonth : " + (today.getMonth() + 1) + "월"); // 기본값 6
		System.out.println("getDate : " + today.getDate() + "일");
		System.out.println("getHours : " + today.getHours() + "시");
		System.out.println("getMintes : " + today.getMinutes() + "분");
		System.out.println("getSeconds : " + today.getSeconds() + "초");
		
//		SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록 (H : 0 ~ 23, h : 1 ~ 12)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 mm월 dd일 (E) a HH시 mm분 ss초");
		String formatDate = sdf.format(today);
		
//		2024년 14월 11일 (목) 오후 12시 14분 12초
		System.out.println(formatDate);
		
	}
	
	/*
	   Calendar
	   - Date 클래스를 개선한 추상 클래스 (JDK 1.1)
	   - 여전히 단점이 존재
	 * */
	public void method2() {
		/*
		   추상 클래스이기 때문에 직접 객체 생성할 수 없다.
		   getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 객체를 반환
		   태국 - BuddhistCalendar, 그 외 - GregorianCalendar
		 * */
		Date today1 = new Date();
		Calendar today = Calendar.getInstance();
		today = new GregorianCalendar();
		System.out.println(today);
		
//		년, 월, 일, 시, 분, 초
//		Date 때는 + 1900 사용 했었음
		System.out.println("YEAR : " + today.get(Calendar.YEAR) + "년");
		System.out.println("MONTH : " + (today.get(Calendar.MONTH) + 1 ) + "월");
		System.out.println("DATE : " + today.get(Calendar.DATE) + "일");
		System.out.println("HOUR : " + today.get(Calendar.HOUR) + "시"); // 0 ~ 11
		System.out.println("HOUR_OF_DAY : " + today.get(Calendar.HOUR_OF_DAY) + "시"); // 0 ~ 23시
		System.out.println("MINUTE : " + today.get(Calendar.MINUTE) + "분");
		System.out.println("SECOND : " + today.get(Calendar.SECOND) + "초");
		
		System.out.println();
		
//		날짜 지정
		Calendar date = Calendar.getInstance();
		date.set(2024, Calendar.JANUARY, 11);
		System.out.println(date.getTime()); // Date 객체로 반환
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd HH:mm:ss");
		
//		SimpleDateFormat 사용 가능
//		24-07-11 12:35:26
		
		String formatDate = sdf.format(date.getTime());
		System.out.println(formatDate);
		
	};
	
	
	public static void main(String[] args) {
		A_Date a = new A_Date();
//		a.method1();
		a.method2();
		
	}

}

















