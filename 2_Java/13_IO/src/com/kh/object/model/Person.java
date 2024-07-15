package com.kh.object.model;

import java.io.Serializable;
import java.util.Objects;


// 객체를 직렬화로 통과하려면 반드시 implements Serializable
public class Person implements Serializable{
	
	private String name;
	private String id;
	public Person() {
	}
	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
}
