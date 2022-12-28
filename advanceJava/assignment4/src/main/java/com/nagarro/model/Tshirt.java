package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Tshirt {
	
	@Id
	private String iD;
	private String name;
	private String color;
	private String genderRecommendation;
	private String size;
	private double price;
	private double rating;
	private String tshirtAvailability;
	@Transient
	private String outputPreference;
	public String getOutputPreference() {
		return outputPreference;
	}
	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGenderRecommendation() {
		return genderRecommendation;
	}
	public void setGenderRecommendation(String genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getTshirtAvailability() {
		return tshirtAvailability;
	}
	public void setTshirtAvailability(String tshirtAvailability) {
		this.tshirtAvailability = tshirtAvailability;
	}
	public Tshirt() {
		super();
	}
	
	
}
