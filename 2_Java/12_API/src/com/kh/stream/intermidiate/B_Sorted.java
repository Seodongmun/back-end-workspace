package com.kh.stream.intermidiate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.Student;

/*
   - 스트림은 최종 처리 되기 전에 중간 단계에서 요소들을 정렬해 최종 처리 순서르 변경할 수 있다
   - Stream<T>은 요소 객체가 Comparable 인터페이스를 구현해야 정렬할 수 있다.
 * */

public class B_Sorted {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("김현호", "우현성", "김경주", "주준영", "조창현", "김진주");
		
		names.stream()
//			오름차순 정렬
			.sorted()
//			내림차순 정렬
			.sorted(Comparator.reverseOrder())
			.forEach(name -> System.out.println(name + " "));
		
		List<Student> students = Arrays.asList(
				new Student("김현호", 20 , "남자", 80, 50),
				new Student("우현성", 19 , "남자", 75, 60),
				new Student("김경주", 18 , "여자", 50, 100),
				new Student("주준영", 21 , "남자", 60, 45),
				new Student("조창현", 19 , "남자", 70, 90),
				new Student("김진주", 22 , "여자", 80, 50));
		
		System.out.println("============= 오름차순 ==============");
		students.stream()
			.sorted()
			.forEach(Student -> System.out.println(Student));
		
		System.out.println("============= 내림차순 ==============");
		students.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(Student -> System.out.println(Student));
		
	}
	
}
























