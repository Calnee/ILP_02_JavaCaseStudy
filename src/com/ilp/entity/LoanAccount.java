package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product{

	private double chequeDeposit;

	public LoanAccount(String productCode, String productName, ArrayList<Services> services) {
		super(productCode, productName, services);
		this.setChequeDeposit(0.03);
	}

	public double getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}
}
