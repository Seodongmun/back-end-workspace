package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	private int bk_no;
	private String bk_title;
	private String bk_author;
	private int bk_price;
	private int bk_pub_no;
	
	public Book(String bk_title, String bk_author) {
		this.bk_title = bk_title;
		this.bk_author = bk_author;
	}
	
//	bk_no INT PRIMARY KEY AUTO_INCREMENT,
//    bk_title VARCHAR(50) NOT NULL,
//    bk_author VARCHAR(20) NOT NULL,
//    bk_price INT,
//    bk_pub_no INT,

}
