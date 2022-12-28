package com.nagarro.EcommWebsite.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer orderId;
	private String orderFullName;
	
	
	@Column(name = "orderDate", insertable = true, updatable = false)
	@CreatedDate
	private LocalDate orderDate;
	private String orderFullAddress;
	private String orderContactNumber;
	private String orderAlternateContactNumber;
	private String orderStatus;
	private Double orderAmount;
	
	@OneToOne
	private Product product; 
	
	@OneToOne
	private User user;
	
	
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String orderFullName, String orderFullAddress, String orderContactNumber,
			String orderAlternateContactNumber, String orderStatus, Double orderAmount, Product product, User user) {
		super();
		this.orderFullName = orderFullName;
		this.orderFullAddress = orderFullAddress;
		this.orderContactNumber = orderContactNumber;
		this.orderAlternateContactNumber = orderAlternateContactNumber;
		this.orderStatus = orderStatus;
		this.orderAmount = orderAmount;
		this.product = product;
		this.user = user;
	}
	public String getOrderFullName() {
		return orderFullName;
	}
	public void setOrderFullName(String orderFullName) {
		this.orderFullName = orderFullName;
	}
	public String getOrderFullAddress() {
		return orderFullAddress;
	}
	public void setOrderFullAddress(String orderFullOrder) {
		this.orderFullAddress = orderFullOrder;
	}
	public String getOrderContactNumber() {
		return orderContactNumber;
	}
	public void setOrderContactNumber(String orderContactNumber) {
		this.orderContactNumber = orderContactNumber;
	}
	public String getOrderAlternateContactNumber() {
		return orderAlternateContactNumber;
	}
	public void setOrderAlternateContactNumber(String orderAlternateContactNumber) {
		this.orderAlternateContactNumber = orderAlternateContactNumber;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
