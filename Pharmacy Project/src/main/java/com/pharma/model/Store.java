package com.pharma.model;

public class Store {

	private String name;
	private String email;
	private String phone_no;
	private String address;
	private String latitude;
	private String longitude;
	private String area;
	
	public Store(String name, String email, String phone_no, String address, String latitude, String longitude, String area) {
		super();
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.area = area;
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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}
	
}
