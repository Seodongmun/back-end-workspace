package com.kh.file;

import java.io.File;
import java.io.IOException;

/*
   File 클래스
   - 파일과 디렉터리를 다루는데 사용되는 클래스
 * */

public class FileTest {
	
	public static void main(String[] args) {
//		문자열을 file 객체로 생성
		File file = new File("src/test.txt");
		
		System.out.println("파일명 : " + file.getName());
//		파일명 : test.txt
		System.out.println("절대 경로 : " + file.getAbsolutePath());
//		절대 경로 : D:\back-end-workspace\2_Java\13_IO\src\test.txt
		System.out.println("상대 경로 : " + file.getPath());
//		상대 경로 : src\test.txt
		System.out.println("파일 용량 : " + file.length());
//		파일 용량 : 18
		System.out.println("파일 존재 여부 : " + file.exists());
//		파일 존재 여부 : true
		System.out.println("디렉터리 여부 : " + file.isDirectory());
//		디렉터리 여부 : false
		
//		만약 존재하지 않는 경로를 제시하면 IOException 발생
		File newFile = new File("src/temp/test.txt");
		try {
//			존재하지 않는 폴더부터 만든다
			File tempDir = new File("src/temp");
			if(!tempDir.isDirectory()) {
				tempDir.mkdir();
			}
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}




















