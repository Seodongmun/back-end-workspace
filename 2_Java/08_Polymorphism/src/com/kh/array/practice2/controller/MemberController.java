package com.kh.array.practice2.controller;

import java.util.Arrays;
import java.util.Objects;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	// 회원가입 필드
	private Member member = new Member();
	
	// 최대 등록 회원수
	private Member[] mArr = new Member[3];
	public int count = 0;
	

	// 새 회원 등록
	public void insertMember (Member insert){
		mArr[count++] = new Member(insert.getId(),
				insert.getPwd(),
				insert.getName(),
				insert.getEmail(),
				insert.getGender(),
				insert.getAge()) ;
//		System.out.println(Arrays.toString(mArr));
	}
	
	// 멤버 아이디 검색 -> 멤버 index를 아이디로 조회
	public int checkId(String id) {
		for(int i = 0; i < mArr.length; i++) {
			// 배열의 초기는 null값이므로 null이 아닌 경우
			if(mArr[i] != null && mArr[i].getId().equals(id)) {
				// 기존 멤버 배열에 아이디가 있는 경우
				return i;
			}
		}
		return -1;
		
	}
	
	
	// 회원 정보 수정
	public void updateMember(String id, String name, String email, String pwd) {
		// 멤버의 index 찾기!
		checkId(id);
		int index = checkId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);

	}

	// 전체 회원 정보 출력 (return member)
	public Member[] printAll() {
		return mArr;
	}

}
