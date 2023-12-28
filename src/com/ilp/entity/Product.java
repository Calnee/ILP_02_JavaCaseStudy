package com.ilp.entity;

import java.util.ArrayList;

public class Product {

	private String productCode;
	private String productName;
	private ArrayList<Services> services;
	
	public Product(String productCode, String productName, ArrayList<Services> services) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.services = services;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ArrayList<Services> getServices() {
		return services;
	}

	public void setServices(ArrayList<Services> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", services=" + services + "]";
	}
	
}
