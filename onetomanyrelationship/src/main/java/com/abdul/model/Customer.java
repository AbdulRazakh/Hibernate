package com.abdul.model;

public class Customer {
	
	private int customerId;
	private String customerName;
	
	private int foreingKey;
	
	public int getForeingKey() {
		return foreingKey;
	}
	public void setForeingKey(int foreingKey) {
		this.foreingKey = foreingKey;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

}
