package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
   Properties
   - HashMap 구버전인 Hashtable(Object, Object)을 상속받아 구현한 것
   - (String, String) 형태로 단순화된 컬렉션 클래스
   - 주로 환경설정과 관련된 속성(property)을 저장하는데 사용
   
 * */

public class B_Properties {
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// key value 둘다 String값
		// (키값 중복 X,순서 없음) Properties == Map 특징과 같음
		// 중복허용, 순서 있는 것은 List뿐
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		
		Enumeration en = prop.propertyNames();
			// 마지막 요소까지 (조건)
		while(en.hasMoreElements()) {
								// 다음요소가 있는지
			String key = (String) en.nextElement();
			// nextElement Object 속성이라서 String으로 형변환
			String value = prop.getProperty(key);
			System.out.println(key + " : " + value);
		}
		
		Set<Entry<Object, Object>> entrySet = prop.entrySet();
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			
		}
	}
}










