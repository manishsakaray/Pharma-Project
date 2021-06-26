package com.pharma.model;

public class Customer {
	
	private String phone_no;
	private String name;
	private String email;
	private String username;
	private String password;
	private String area;
	
	public Customer(String phone_no, String name, String email, String username, String password, String area) {
		super();
		this.phone_no = phone_no;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.area = area;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
