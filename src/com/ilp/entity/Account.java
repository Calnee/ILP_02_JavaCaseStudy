package com.ilp.entity;

public class Account {

	private String accountNo;
	private String accountType;
	private double acccountBalance;
	
	private Product product;
	
	public Account(String accountNo, String accountType,Product product, double acccountBalance) {
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.acccountBalance = acccountBalance;
		this.product = product;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAcccountBalance() {
		return acccountBalance;
	}
	public void setAcccountBalance(double acccountBalance) {
		this.acccountBalance = acccountBalance;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", acccountBalance="
				+ acccountBalance + ", product=" + product + "]";
	}
	
	
}
