package com.nagarro.advancejava.assignment1.training.tshirtmodel;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * Tshirt Class : This class stores the attribute about all thetshit present in data.
 * 					and operation to get attribute about any particular tshirt.
 * 
 * ***/

public class Tshirt {
	String id;
	String name;
	String color;
	String genderRecom;
	String size;
	double price;
	double rating;
	boolean availability;
	
	public Tshirt(String id,String name,String color,String genderRecom,String size,double price,
			double rating,boolean availability) {
		this.id=id;
		this.name=name;
		this.color=color;
		this.genderRecom=genderRecom;
		this.size=size;
		this.price=price;
		this.rating=rating;
		this.availability=availability;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getGenderRecom() {
		return genderRecom;
	}
	
	public String getSize() {
		return size;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getRating() {
		return rating;
	}
	
	public boolean isAvailability()
	{
		return availability;
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
