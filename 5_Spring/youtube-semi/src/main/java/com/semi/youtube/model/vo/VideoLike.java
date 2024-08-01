package com.semi.youtube.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class VideoLike {
	private int likeCode;
	private String id; // member
	private int videoCode; // video
	
	
}
