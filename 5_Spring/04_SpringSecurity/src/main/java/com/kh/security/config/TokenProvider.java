package com.kh.security.config;

import java.time.Instant;


import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.Member;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;

@Service
public class TokenProvider {

	private SecretKey secretkey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public String create(Member member) {
		// 토큰 생성기
		return Jwts.builder()
				.signWith(secretkey)
				.setClaims(Map.of(
						// Claims는 여러 정보를 담을수 있다
						// 보안에 중요한 정보는 넣지 않는다 ex) pwd
						"id", member.getId(),
						"name" , member.getName(),
						"role" , member.getRole()
						))
				.setIssuedAt(new Date())
				.setExpiration(Date.from(Instant.now().plus(1,ChronoUnit.DAYS)))
				.compact();

	}
	
	public Member validate(String token) {
		Claims claims = Jwts
				.parser()
				.setSigningKey(secretkey)
				.parseClaimsJws(token)
				.getBody();
		
		return Member.builder()
				.id((String) claims.get("id"))
				.name((String)claims.get("name"))
				.role((String)claims.get("role"))
				
				.build();
	}
	
	
	
	
	
	
	
}





