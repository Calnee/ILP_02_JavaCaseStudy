package com.ilp.entity;

public class Services {

	private String serviceCode;
	private String serviceName;
	private double serviceRate;
	
	public String getServiceCode() {
		return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServiceRate() {
		return serviceRate;
	}
	public void setServiceRate(double serviceRate) {
		this.serviceRate = serviceRate;
	}
	@Override
	public String toString() {
		return "Services [serviceCode=" + serviceCode + ", serviceName=" + serviceName + ", serviceRate=" + serviceRate
				+ "]";
	}
	
}
