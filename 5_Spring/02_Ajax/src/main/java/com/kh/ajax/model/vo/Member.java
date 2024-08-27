package com.kh.ajax.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 롬복 쓰려면 xml 추가해야함
@Data @AllArgsConstructor @NoArgsConstructor
public class Member {
	
	private String id;
	private String password;
	private String name;
	
	
	
	
}
