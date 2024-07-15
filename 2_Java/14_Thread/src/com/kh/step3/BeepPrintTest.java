package com.kh.step3;

import java.awt.Toolkit;

import com.kh.step2.ComeThread;
import com.kh.step2.GoThread;

public class BeepPrintTest {
	
	public static void main(String[] args) {
		
		BeepThread beep = new BeepThread();
		BeepThread2 beep2 = new BeepThread2();

		Thread bGo = new Thread(beep);
		Thread bGo2 = new Thread(beep2);
		
//		경고음 5번 울리는 작업
		bGo.start();
//		띵띵띵띵띵을 5번 출력하는 작업
		bGo2.start();
	}
	
}
