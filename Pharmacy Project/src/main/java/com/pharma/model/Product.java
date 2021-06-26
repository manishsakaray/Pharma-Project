package com.pharma.model;

public class Product {

	private String name;
	private int cost;
	private int discount;
	
	public Product(String name, int cost, int discount) {
		super();
		this.name = name;
		this.cost = cost;
		this.discount = discount;
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
