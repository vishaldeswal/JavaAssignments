package com.nagarro.EcommWebsite.entity;

public class SalesReportResult {
	
	public SalesReportResult(Integer productId, String productName, Double revenue) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.revenue = revenue;
	}
	Integer productId;
	String productName;
	Double revenue;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	
	

}
