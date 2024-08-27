package com.kh.api.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class XMLParsing {

	public static void main(String[] args) {
		String serviceKey = "UNmnLkcNtzgMKivBzvyb3TdrsqmthwquJWOHYpkKXK6aXtSdhG1gbTQ6EOqATL5t3ApCJ2hySkej4pCTXuaAZg%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey +"&numOfRows=396";


		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url); // org.w3c.dom
			
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName()); // response
			
			NodeList nList = doc.getElementsByTagName("item");
			System.err.println("파싱할 데이터 수 : " + nList.getLength());
			
			for(int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				// node를 엘레먼트로 바꿔야 사용 가능
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("가게명 : " + getTagValue("MAIN_TITLE", eElement));
					System.out.println("주소 : " + getTagValue("ADDR1", eElement));
					System.out.println("운영시간 : " + getTagValue("USAGE_DAY_WEEK_AND_TIME", eElement).trim());
					System.out.println("------------------------------------------");
					
				}
				
				System.out.println(nNode);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		if(nValue == null) return null;
		return nValue.getNodeValue();
		
		
	}

}







