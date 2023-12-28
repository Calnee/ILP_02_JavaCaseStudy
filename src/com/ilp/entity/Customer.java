package com.ilp.entity;

import java.util.ArrayList;

public class Customer {

	private String customerName;
	private String customerCode;
	private ArrayList<Account>accountList;
	
	
	
	public Customer(String customerName, String customerCode, ArrayList<Account> accountList) {
		super();
		this.customerName = customerName;
		this.customerCode = customerCode;
		this.accountList = accountList;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public ArrayList<Account> getAccount() {
		return accountList;
	}
	public void setAccount(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	@Override
	public String toString() {
		return "Customer [customerCode=" + customerCode + ", customerName=" + customerName + ", accountList="
				+ accountList + "]";
	}
	
	
}
