package project.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor @Data
public class Sign_up {
	
	private String id;
	private String pwd;
	private String addr;
	private String phone;
	private String email;
	private String name;
	private int age;
	private char gender;
	

}
