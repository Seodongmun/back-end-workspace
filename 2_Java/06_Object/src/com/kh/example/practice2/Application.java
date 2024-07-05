package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;
import com.kh.example.practice2.model.Snack;
// Snack과 연결

public class Application {
	
	public static void main(String[] args) {

		// ---------------- 화면 --------------------
		
		Scanner sc = new Scanner(System.in);
		
		Snack snack = new Snack();

		System.out.println("스낵류를 입력하세요");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		// ---------------------------------------------
		// --> 즉, 여기까지는 controller나 model에 직접 접근 X
		
		// 데이터들을 서버한테 요청!
		// 서버한테 전달할 때는 controller로!!
		SnackController controller = new SnackController();
		
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로!
		System.out.println(controller.saveDate(kind, name, flavor, numOf, price));
		// 사용자입력값을 서버로 보낸뒤
		// set,get 으로 
		System.out.println(controller.confirmDate());
		// 

	}

}
