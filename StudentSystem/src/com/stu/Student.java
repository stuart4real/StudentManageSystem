package com.stu;

public class Student {
	
	private String age;
	private String number;
	private String name;
	private String address;
	
	public Student(String age, String number, String name, String address) {
		
		this.age = age;
		this.number = number;
		this.name = name;
		this.address = address;
	}
	
	public String getAge() {
		
		return this.age;
	}
	
	public void setAge(String age) {
		
		this.age = age;
	}
	
	public String getNumber() {
		
		return this.number;
	}
	
	public void setNumber(String number) {
		
		this.number = number;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getAddress() {
		
		return this.address;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	
	
}
