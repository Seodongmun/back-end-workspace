package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Rent {
	
	private int rent_no;
	private int rent_mem_no;
	private int rent_book_no;
	private int rent_date;
	
//	  rent_no INT PRIMARY KEY AUTO_INCREMENT,
//    rent_mem_no INT,
//    rent_book_no INT, 
//    rent_date DATE DEFAULT (current_date)
	
}
