package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import com.kh.list.model.Person;

public class Application {



	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(); 
		ArrayList<Integer> list2 = new ArrayList<>(); 
		HashSet<String> set = new HashSet<>();
		Lotto lotto = new Lotto();

		int count = 0;
		while (list1 != list2) {
			count++;
			
			for (int i = 0; i < 6; i++) { // 로또 번호 6개 생성
				double MyNum = Math.random();
				MyNum = (Math.random() * 45) + 1;
				list1.add((int) MyNum);
				
				Collections.sort(list1);
				System.out.println(list1);

			}
			for (int j = 0; j < 6; j++) { // 내 번호 6개
				double lottoNum = Math.random();
				lottoNum = (Math.random() * 45) + 1;
				list2.add((int) lottoNum);

			}
			if(list1.equals(list2)) {
				break;
			}
			list1.clear();
			list2.clear();
			System.out.println(count);
		}

		
		
		
		// 랜덤 함수 1. 로또 번호 ( 오름차순 정렬 TreeSet 사용 )
		// 랜덤 함수 2. 내 번호 ( 정렬 없음 )
		// 6 개 배열 생성
//		
//		lotto.getLottoNum();
//		lotto.getMyNum();
//		int myNum[] = {lotto.getMyNum(),
//				lotto.getMyNum(),
//				lotto.getMyNum(),
//				lotto.getMyNum(),
//				lotto.getMyNum(),
//				lotto.getMyNum()
//		};
//		System.out.println(Arrays.toString(myNum));
//		
//		int lottoNum[] = {lotto.getLottoNum(),
//				lotto.getLottoNum(),
//				lotto.getLottoNum(),
//				lotto.getLottoNum(),
//				lotto.getLottoNum(),
//				lotto.getLottoNum()
//		};
//		System.out.println(Arrays.toString(lottoNum));
		// 로또 번호 출력
		// 중복없이
		// 오름차순
//		int count = 0;
//		while (true) {
//			count++;
//			if(myNum.equals(lottoNum)){
//				break;
//			}
//			System.out.println(count);
//		}
//
	}

}
