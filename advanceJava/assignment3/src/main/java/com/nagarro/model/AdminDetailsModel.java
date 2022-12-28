package com.nagarro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class AdminDetailsModel {
	@Id
	private String adminUserName;
	private String adminPassword;
	
	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Products> product;
	
	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}

	public String getAdminUserName() {
		return adminUserName;
	}
	
	public AdminDetailsModel() {
		super();
	}

	public AdminDetailsModel(String adminUserName, String adminPassword, List<Products> product) {
		super();
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.product = product;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
