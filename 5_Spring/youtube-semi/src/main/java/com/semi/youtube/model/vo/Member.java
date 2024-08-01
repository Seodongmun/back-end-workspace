package com.semi.youtube.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Member {
	private String id;
	private String password;
	private String email;
	private String phone;
}
