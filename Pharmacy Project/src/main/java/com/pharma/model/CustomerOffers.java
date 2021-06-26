package com.pharma.model;

public class CustomerOffers {

	private String prod_name;
	private int cost;
	private int discount;
	private String store_name;
	private String latitude;
	private String longitude;
	
	public CustomerOffers(String prod_name, int cost, int discount, String store_name, String latitude,
			String longitude) {
		super();
	
		this.prod_name = prod_name;
		this.cost = cost;
		this.discount = discount;
		this.store_name = store_name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
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
	
	
	
}
