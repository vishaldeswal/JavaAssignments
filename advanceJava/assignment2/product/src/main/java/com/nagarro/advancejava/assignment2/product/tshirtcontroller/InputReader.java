package com.nagarro.advancejava.assignment2.product.tshirtcontroller;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nagarro.advancejava.assignment2.product.tshirtmodel.Tshirt;
import com.nagarro.advancejava.assignment2.product.constants.Constant;
import com.nagarro.advancejava.assignment2.product.*;
import com.nagarro.advancejava.assignment2.product.database.*;

/***
* Author: Vishal Deswal
* Email: vishal.deswal@nagarro.com
* 
* Description: Read CSV files from java Program and search the required data for user.
* 
* ProductCsvReader Class : This class read csv files and loads data in database .
* 
* ***/


public class InputReader {
	
	/*This method read csv file and do manipulation to store it in informational form in program.*/
	public static void readFile(File file){
		
		
		Tshirt newTshirt;
		try {
	        // Create an object of file reader class with CSV file as a parameter.
	        FileReader filereader = new FileReader(Constant.SOURCE_FOLDER+file.getName());
	  
	        // create csvParser object with
	        // custom separator semi-colon
	        CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
	  
	        // create csvReader object with parameter
	        // filereader and parser
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	        						  .withSkipLines(1)
	                                  .withCSVParser(parser)
	                                  .build();
	  
	        // Read all data at once
	        List<String[]> allData = csvReader.readAll();
	        SessionFactory sf = HibernateUtility.getSessionFactory();
	        //created a new session to insert in table
	        Session session= sf.openSession();
	        //Transaction to add one row in table 
	        Transaction tx = null; 
	        
	        
	        for (String[] row : allData) {
	           
	            newTshirt=manipulateLine(row);
	            
	            try{	//Transaction started
	            		tx=session.beginTransaction();
	            		//Saving data in database
	            		session.save(newTshirt);
	            		//Commit the changes in database
	            		tx.commit();
	            		//Thread.sleep(3000);
	            	
	            }
	            catch(Exception e) {
	            		tx.rollback();
	            }
	        }
	        //Close the session.
	        session.close();
	        
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	/*This method breaks the rows of csv file into corresponding columns.*/
	private static Tshirt manipulateLine(String[] record){
		String id, name, color, gender, size, avail;
		double price , rating;
		boolean availability;
		
		
			
			id=record[0];
			name=record[1];
			color=record[2];
			gender=record[3];
			size=record[4];
			price=Double.parseDouble(record[5]);
			rating=Double.parseDouble(record[6]);
			avail=record[7];
			
			if(avail.charAt(0)=='Y')
				availability=true;
			else
				availability=false;
			
			Tshirt newTshirt = new Tshirt();
			newTshirt.setId(id);
			newTshirt.setName(name);
			newTshirt.setColor(color);
			newTshirt.setGenderRecom(gender);
			newTshirt.setSize(size);
			newTshirt.setPrice(price);
			newTshirt.setRating(rating);
			newTshirt.setAvailability(availability);
			
			
			return newTshirt;
			
	
		
	}

}
