package com.semi.youtube.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Subscribe {
	
	private int subCode;
	private String id; // member
	private int channelCode; // channel
	
}
