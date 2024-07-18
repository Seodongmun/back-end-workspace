package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Member {
	
	private int member_no;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private char gender;
	private String address;
	private String phone;
	private char status;
	private int enroll_date;

}
//member_no INT AUTO_INCREMENT PRIMARY KEY,
//member_id VARCHAR(20) NOT NULL UNIQUE,
//member_pwd VARCHAR(20) NOT NULL,
//member_name VARCHAR(20) NOT NULL,
//gender CHAR(1) CHECK(gender IN ('M', 'F')),
//address VARCHAR(50),
//phone VARCHAR(20),
//status CHAR(1) CHECK(status IN ('Y', 'N')) DEFAULT 'N',
//enroll_date DATE DEFAULT (current_date)