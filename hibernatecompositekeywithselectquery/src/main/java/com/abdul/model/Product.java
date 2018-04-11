package com.abdul.model;

import java.io.Serializable;

public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;
    private int productId;
    private double price;
    private String proName;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
    
	
}
