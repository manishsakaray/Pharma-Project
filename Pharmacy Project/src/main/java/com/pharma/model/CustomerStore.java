package com.pharma.model;

public class CustomerStore {

	private String message;
	private String availability;
	private String time_stamp;
	private int req_id;
	private String latitude;
	private String longitude;
	private String store_name;
	
	public CustomerStore(String message, String availability, String time_stamp, int req_id, String latitude,
			String longitude,String store_name) {
		super();
		this.message = message;
		this.availability = availability;
		this.time_stamp = time_stamp;
		this.req_id = req_id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.store_name = store_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
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

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	
}
