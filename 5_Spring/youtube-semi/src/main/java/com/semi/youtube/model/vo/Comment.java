package com.semi.youtube.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Comment {
	private int commentCode;
	private String commentText;
	private Date commentDate;
	private String id; // member
	private int videoCode; // video
	private int parentCode;
	
}
