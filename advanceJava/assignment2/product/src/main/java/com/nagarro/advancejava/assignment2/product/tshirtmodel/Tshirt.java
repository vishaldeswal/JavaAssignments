package com.nagarro.advancejava.assignment2.product.tshirtmodel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * Tshirt Class : This class is an entity in database and stores the attribute about all the tshirt present in data.
 * 					and operation to get attribute about any particular tshirt.
 * 
 * ***/
@Entity
@Table
public class Tshirt {
	@Id
	String id;
	
	String name;
	String color;
	String genderRecom;
	String size;
	double price;
	double rating;
	boolean availability;
	
	public Tshirt() {
	
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getGenderRecom() {
		return genderRecom;
	}


	public void setGenderRecom(String genderRecom) {
		this.genderRecom = genderRecom;
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


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID= "+ id +" , Name= "+ name +", Color= "+ color+", Gender= "+ genderRecom+", Size= "+ size
				+", Price= "+ String.format("%.2f", price)+ ", Rating= "+  String.format("%.2f", rating)+", Availability= "+ availability;
	}
	
	public boolean equals(Object obj) {
		Tshirt other= (Tshirt) obj;
		
		if(id==null) {
			if(other.id != null) {
				return false;
			}
		}
		else if(!id.equals(other.id)) {
			return false;
		}

		if(name==null) {
			if(other.name != null) {
				return false;
			}
		}
		else if(!name.equals(other.name)) {
			return false;
		}

		if(color==null) {
			if(other.color != null) {
				return false;
			}
		}
		else if(!color.equals(other.color)) {
			return false;
		}
		

		if(genderRecom==null) {
			if(other.genderRecom != null) {
				return false;
			}
		}
		else if(!genderRecom.equals(other.genderRecom)) {
			return false;
		}
		
		if(size==null) {
			if(other.size != null) {
				return false;
			}
		}
		else if(!size.equals(other.size)) {
			return false;
		}
		
		if(availability != other.availability)
			return false;
		
		return true;
	}

}
