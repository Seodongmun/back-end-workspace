package com.kh.array.practice1;

import java.util.Arrays;

import com.kh.array.practice1.model.Student;

public class Application {

	public static void main(String[] args) {

		// Student 배열의 객체타입 5개 생성
		Student[] arr = new Student[5];

//		[null, null, null, null, null]
//		System.out.println(Arrays.toString(arr));

		arr[0] = new Student("박성철", "자바", 100);
		arr[1] = new Student("이진우", "디비", 95);
		arr[2] = new Student("이준용", "자바", 97);
		arr[3] = new Student("김경주", "화면", 98);
		arr[4] = new Student("김현호", "자바", 95);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
//			Student [name=박성철, subject=자바, score=100]
//			Student [name=이진우, subject=디비, score=95]
//			Student [name=이준용, subject=자바, score=97]
//			Student [name=김경주, subject=화면, score=98]
//			Student [name=김현호, subject=자바, score=95]

		}

		System.out.println();
		for (Student student : arr) {
			System.out.println(student);
		}
		
		
		
		
	}

}
