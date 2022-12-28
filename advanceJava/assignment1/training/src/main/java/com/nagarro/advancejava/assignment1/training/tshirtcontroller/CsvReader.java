package com.nagarro.advancejava.assignment1.training.tshirtcontroller;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.nagarro.advancejava.assignment1.training.tshirtmodel.Tshirt;
import com.nagarro.advancejava.assignment1.training.constants.Constant;
import com.nagarro.advancejava.assignment1.training.*;

/***
* Author: Vishal Deswal
* Email: vishal.deswal@nagarro.com
* 
* Description: Read CSV files from java Program and search the required data for user.
* 
* CsvReader Class : This class read csv files and manipulate the tshirtinfo hashmap .
* 
* ***/


public class CsvReader {
	
	/*This method read all the valid files from the source folder and insert data in tshirtInfo hashMap*/
	public static void readCSV(){
		
		int i;
		HashSet<Tshirt> tshirtSet;
		File file =  new File(Constant.SOURCE_FOLDER);
		File files[]= file.listFiles();
		
		for(i=0; i< files.length; i++) {
			if(files[i].getName().endsWith(Constant.SOURCE_FILE_FORMAT)) {
					tshirtSet=readFile(files[i]);
					synchronized(App.tshirtinfo) {
						App.tshirtinfo.put(files[i].getName(), tshirtSet);
					}
			}		
		}
		
	}
	
	
	/*This method read csv file and do manipulation to store it in informational form in program.*/
	public static HashSet<Tshirt> readFile(File file){
		
		HashSet<Tshirt> tshirtSet= new HashSet<Tshirt>();
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
	  
	        // Print Data.
	        for (String[] row : allData) {
	           
	            newTshirt=manipulateLine(row);
	            
	            tshirtSet.add(newTshirt);
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
		return tshirtSet;
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
			
			return new Tshirt(id, name, color, gender, size, price, rating, availability);
			
	
		
	}

}
