package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto1 {

	public static void main(String[] args) {
		
		ArrayList<Integer> lotto = new ArrayList<Integer>();

		// 기존 로또 번호는 6개, 보너스 번호가 필요해서 1개 더 추가
		while (lotto.size() < 7) {
			// while의 조건에 num값이 6개 될때까지 반복
			int num = (int) (Math.random() * 45 + 1);
			// contains : 해당하는 번호가 있는지 구별할수있음
			// num값에 중복되지 않는 경우만 배열에 add
			// 하지만 중복된 값이 있을경우 출력이 안돼서 6개가 나오지않음
			if (!lotto.contains(num)) {
				lotto.add(num);
				
			}
		}
		
		// 0 ~ 6까지 범위 지정해서 로또 번호 6개 따로, 보너스 번호 따로!
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = lotto.get(6);

		
		
		int count = 0;
		while (true) {
			
			count++;
			
			ArrayList<Integer> myLotto = new ArrayList<>();

			while (myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				if (!myLotto.contains(num)) {
					myLotto.add(num);
					
				}
			}
			
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("내 번호 : " + myLotto);
			
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			// 멈추는 조건! 로또 번호와 내 번호가 정확히 일치! 1등 당첨!
			if(lottoList.equals(myLotto)) {
				System.out.println("1등 당첨 횟수 : " + count);
				break;
			}
			
			int match = 0;
			
			for(Integer num : lottoList) {
				if(myLotto.contains(num)) {
					match++;
					
				}
			}

			// 3등 당첨
			if (match == 5) {
				if (myLotto.contains(bonus)) {
					// 2등 당첨 & 보너스 번호
					System.out.println("2등 당첨! 보너스 번호 : " + bonus + ", 횟수 : " + count);
					break;
				} else {
					System.out.println("3등 당첨! 횟수 : " + count);
					break;
				}
			} else if (match == 4) {
				System.out.println("4등 당첨! : 횟수 " + count);
				break;
			}else if (match == 3) {
				System.out.println("5등 당첨! : 횟수 "+ count);
				break;
			}
			
			
		}

	}

}
