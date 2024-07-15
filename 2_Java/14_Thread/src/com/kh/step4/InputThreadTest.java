package com.kh.step4;

import javax.swing.JOptionPane;

//	프로세스 - 두 스레드 간의 Communication은 프로세스의 자원으로 해야 한다.
public class InputThreadTest {
//	공유 자원
	boolean check = false;

	public static void main(String[] args) {
//		프로세스를 객체 생성해서 전달
		InputThreadTest process = new InputThreadTest();
		InputThread iThread = new InputThread(process);
		iThread.start();
		
		CountThread count = new CountThread(process);
		count.start();
	}
}

//  InputThreadTest boolean(false)값 -> InputThread process 토스 ->
//  InputThread this.(process) == InputThreadTest (process)
//  process.check = true; 숫자 입력시 종료


















