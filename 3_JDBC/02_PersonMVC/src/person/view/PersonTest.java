package person.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		PersonTest pt = new PersonTest();
		
//		이 부분은 테스트 용도로만!
//		pt.addPerson();
//		pt.updatePerson();
//		pt.removePerson();
//		pt.searchAllPerson();
		pt.searchPerson();
		
	}
	
//	각 Controller에 메서드들 연결하는 건 각 메서드들에서 구현
	
//	person 테이블에 데이터 추가 - INSERT
	public void addPerson() {
//		~~님, 회원가입 완료!
		try {
		System.out.println("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.println("나이를 입력하세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("주소를 입력하세요 : ");
		String addr = sc.nextLine();
		pc.addPerson(name,age,addr);
		System.out.println(name + "님 회원가입 완료!");
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
			addPerson();
		}
	}
	
//	person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() {
//		~~님, 정보 수정 완료!
		try {
		System.out.println("수정할 이름");
		String name = sc.nextLine();
		System.out.println("수정할 나이");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 주소");
		String addr = sc.nextLine();
		pc.updatePerson(name,age,addr);
		System.out.println(name + "님 정보 수정 완료");
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
			updatePerson();
		}
	}
	
//	person 테이블에 데이터 삭제 - DELETE
	public void removePerson() {
//		~~님, 회원 탈퇴 완료!
		try {
		System.out.println("1. 삭제할 아이디");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("2. 삭제할 이름");
		String name = sc.nextLine();

		pc.removePerson(id,name);
		System.out.println(name + "님 회원 탈퇴 완료");
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
			removePerson();
		}
	}
	
//	person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {
//		~~명 선택
		ArrayList<Person>list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
		
	}
	
//	person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson() {
		try {
		System.out.println("불러올 사람의 id를 입력하세요");
		int searchId = Integer.parseInt(sc.nextLine());
		pc.searchPerson(searchId);
		} catch (Exception e) {
			System.out.println("다시 입력해 주세요");
			searchPerson();
		}
	}
}
