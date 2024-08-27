package com.semi.youtube.model.vo;

import java.util.ArrayList;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Member  {
	private String id;
	private String password;
	private String email;
	private String phone;
	
	
	
	
}
