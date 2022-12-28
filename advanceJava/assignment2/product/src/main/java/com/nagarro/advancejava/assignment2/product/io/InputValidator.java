package com.nagarro.advancejava.assignment2.product.io;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;


import com.nagarro.advancejava.assignment2.product.database.HibernateUtility;
import com.nagarro.advancejava.assignment2.product.tshirtmodel.Tshirt;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * InputValidator Class : This class validate whether user input is correct according to the information present in our data.
 * 
 * ***/

public class InputValidator {
	
	public static String validateColor(String color) {
				Session session = HibernateUtility.getSessionFactory().openSession();
				
				String findQuery = "from Tshirt";
				Query query = session.createQuery(findQuery);
				List<Tshirt> tshirtSet = query.list();
				
				session.close();
				
				for(Tshirt t: tshirtSet) {
					if(t.getColor().equalsIgnoreCase(color))
						return t.getColor();
				}
			
		
		System.out.println("Tshirt color not entered correctly");
		return null;
	}
	
	public static String validateSize(String size) {
		if(size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L") || size.equalsIgnoreCase("XL")|| size.equalsIgnoreCase("XXL")) {
			return size.toUpperCase();
		}
		else
		{
			System.out.println("Size not entered correctly");
			return null;
		}
	}
	
	public static String validateGender(String gender) {
		if(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("U")){
			return gender.toUpperCase();
		}
		else
		{
			System.out.println("Gender recommendation not entered correctly");
			return null;
		}
	}
	
	public static int validateOutputPreference(int preference) {
		if(preference==1 ||preference==2 ||preference==3){
			return preference;
		}
		else
		{
			System.out.println("Preference not entered correctly");
			return 0;
		}
	}
	

}
