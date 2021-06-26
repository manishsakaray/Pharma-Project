package com.pharma.model;

public class RetrieveOffers {

	private int prod_id;
	private String name;
	private int cost;
	private int discount;
	
	public RetrieveOffers(int prod_id, String name, int cost, int discount) {
		super();
		this.prod_id = prod_id;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
