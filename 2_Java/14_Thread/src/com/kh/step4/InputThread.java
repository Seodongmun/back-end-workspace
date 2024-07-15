package com.kh.step4;

import javax.swing.JOptionPane;

public class InputThread extends Thread {
	
//	InputThreadTest process 받아온다 
	InputThreadTest process;

	InputThread(InputThreadTest process) {
//		InputThreadTest 의 (process)
//		를 InputTread 에서 사용할수있게 this.사용
		this.process = process;
	}

	public void run() {
//		1. 데이터 입력 작업
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요..");
		System.out.println("입력하신 숫자는 " + input + "입니다");
		process.check = true;
		
	}
	
}
