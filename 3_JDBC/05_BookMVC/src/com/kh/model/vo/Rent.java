package com.kh.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Rent {
	
	private int rentNo;
	private int rentMemNo;
	private int rentBookNo;
	private Date rentDate;
	

}
