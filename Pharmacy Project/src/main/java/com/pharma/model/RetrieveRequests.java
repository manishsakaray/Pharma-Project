package com.pharma.model;

public class RetrieveRequests {

	private int req_id;
	private String message;
	private String time_stamp;
	
	public RetrieveRequests(int req_id, String message, String time_stamp) {
		super();
		this.req_id = req_id;
		this.message = message;
		this.time_stamp = time_stamp;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}	
	
}
