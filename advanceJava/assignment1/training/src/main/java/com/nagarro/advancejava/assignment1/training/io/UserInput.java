package com.nagarro.advancejava.assignment1.training.io;


/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * UserInput Class : This class mainly stores the user input for the search. 
 * 
 * ***/

public class UserInput {
	String color;
	String size;
	String genderRecom;
	int outputPreference;
	
	public UserInput(String color, String size, String genderRecom, int outputPreference) {
		this.color=color;
		this.size=size;
		this.genderRecom=genderRecom;
		this.outputPreference= outputPreference;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getGenderRecom() {
		return genderRecom;
	}
	
	public int getOuputPreference() {
		return outputPreference;
	}

	@Override
	public String toString() {
		
		return "Color: "+color+" ,Size: "+size+" ,Gender Recommendation: "+genderRecom+" ,Output Preference: "+outputPreference;
	}
	
}
