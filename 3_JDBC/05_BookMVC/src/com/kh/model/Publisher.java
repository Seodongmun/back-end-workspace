package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class Publisher {
	
	private int pubNo;
	private String pubName;
	private String phone;
	
	
//	  pub_no INT AUTO_INCREMENT PRIMARY KEY,
//    pub_name VARCHAR(20) NOT NULL,
//    phone VARCHAR(20)
	
	

}
