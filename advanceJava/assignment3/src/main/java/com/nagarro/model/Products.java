package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Products {

	@Id
	@GeneratedValue
	private int productID;
	private String productTitle;
	private String productQuantity;
	private String productSize;
	@Lob
	private byte[] productImage;

	@ManyToOne
	private AdminDetailsModel user;

	public AdminDetailsModel getUser() {
		return user;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int productID, String productTitle, String productQuantity, String productSize, byte[] productImage,
			AdminDetailsModel user) {
		super();
		this.productID = productID;
		this.productTitle = productTitle;
		this.productQuantity = productQuantity;
		this.productSize = productSize;
		this.productImage = productImage;
		this.user = user;
	}

	public void setUser(AdminDetailsModel user) {
		this.user = user;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

}
