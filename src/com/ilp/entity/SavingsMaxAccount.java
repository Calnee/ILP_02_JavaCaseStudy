package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product{
 
	private double minimumBalance;

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> services) {
		super(productCode, productName, services);
		this.minimumBalance = 1000;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}	
}
