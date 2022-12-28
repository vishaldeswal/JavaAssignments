package com.nagarro.EcommWebsite.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
	private String productName;
	@Lob
	@Column( length = 100000 )
	private String productDescription;
	private String brandName;
	private String categoryType;
	private Double productDicountedPrice;
	private Double productActualPrice;
	private Integer stockQuantity;
	
	@ManyToOne
	@JoinColumn(name="vendorUsername")
	private User vendor;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="product_images",
			joinColumns= {
					@JoinColumn(name="product_id")
			},
			inverseJoinColumns= {
					@JoinColumn(name="image_id")
			}
	)
	private Set<ImageModel> productImages;
	
	
	public Set<ImageModel> getProductImages(){
		return productImages;
	}
	
	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages=productImages;
	}
	
	public User getVendor() {
		return vendor;
	}
	public void setVendor(User vendor) {
		this.vendor = vendor;
	}
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public Double getProductDicountedPrice() {
		return productDicountedPrice;
	}
	public void setProductDicountedPrice(Double productDicountedPrice) {
		this.productDicountedPrice = productDicountedPrice;
	}
	public Double getProductActualPrice() {
		return productActualPrice;
	}
	public void setProductActualPrice(Double productActualPrice) {
		this.productActualPrice = productActualPrice;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	

}
