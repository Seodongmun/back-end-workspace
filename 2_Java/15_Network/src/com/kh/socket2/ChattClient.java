package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
   키보드로 입력받은 데이터를 읽어서 서버로 보낸다
   다시 서버가 보낸 메시지를 받아서 클라이언트 자신의 콘솔창에 출력한다
   
   클라이언트측 로직
   1. 소켓 생성
   2. 스트림 생성
   
 * */

public class ChattClient {
	
	public static void main(String[] args) {
//		1. 소켓 생성
		try {
//			본인의 주소
			InetAddress ip = InetAddress.getLocalHost();
//			2. 서버의 포트번호 60000을 받는 소켓
			Socket s = new Socket("192.168.10.21", 60000);

			
//			2. 스트림 생성
//			(System.in) 은 입력받은값 
//			키보드로 입력받은 데이터를 읽어서 서버한테 보낸다 (s.getOutputStream(),true)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
//			다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			while(true) {
				String line = br.readLine();
				pw.println(line);
				String serverMsg = br2.readLine();
				System.out.println("내가 보낸 메세지 : " + serverMsg);
				
				
			}
			
			
			
			

		} catch (Exception e) {
			System.out.println("서버연결에 실패했습니다");
		}
		
		
		
		
	}

}