package com.nagarro.advancejava.assignment1.training;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.nagarro.advancejava.assignment1.training.constants.Constant;
import com.nagarro.advancejava.assignment1.training.tshirtmodel.Tshirt;
import com.nagarro.advancejava.assignment1.training.sort.*;
import com.nagarro.advancejava.assignment1.training.io.*;
import com.nagarro.advancejava.assignment1.training.tshirtcontroller.UpdationCheck;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * Application Class : This is main class where all functions are called and output is shown based on that.
 * 
 * ***/

public class App 
{	/*HashMap which store data of tshirts as (key=Filename, value=set of tshirt for given company)
 		HashSet which stores all the tshirt data of one file.*/
	public static HashMap<String, HashSet<Tshirt>> tshirtinfo = new HashMap<String, HashSet<Tshirt>>(); 
	
    public static void main( String[] args )
    {	
    	/*Stores the tshirts which fullfills the user requirements.*/
        ArrayList<Tshirt> result = new ArrayList<Tshirt>(); 
        
        UserInput input=null;
        int choice= 0;
        
        /*Creation of thread which starts after some fixed delay and  re-run after some fixed period of time */
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new UpdationCheck(), Constant.DELAY, Constant.PERIOD, TimeUnit.SECONDS);
        
      do {
        	try {
				input= InputAcceptor.enterInput(); //User's input for search in data 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	result.clear(); //Clear the previous search result 
        	
        	synchronized(App.tshirtinfo) { //synchronized so only one operation(read,write) can be done at a time on tshirtinfo HashMap.
        		for(HashSet<Tshirt> set : tshirtinfo.values()) {
        			for(Tshirt t : set ) {
        				if(t.getColor().equalsIgnoreCase(input.getColor())
        					&& t.getSize().equalsIgnoreCase(input.getSize())
        					&& (t.getGenderRecom().equalsIgnoreCase(input.getGenderRecom()) || t.getGenderRecom().equalsIgnoreCase("u") )
        					&& t.isAvailability()) {
        					
        					result.add(t);
        				}
        			}
        		}
        		
        	}
        	
        	if(input.getOuputPreference()==1)
        		Collections.sort(result, new TshirtRatingComparator()); //sorting result by low price to high price
        	else if(input.getOuputPreference()==2)
        		Collections.sort(result, new TshirtRatingComparator()); //sorting result by low rating to high rating
        	else {
        		Collections.sort(result, new TshirtRatingComparator()); //sorting result by low price to high price
        		Collections.sort(result, new TshirtRatingComparator()); //and low rating to high rating.
        	}
        	
        	System.out.println("Results:\n");
        	if(result.size()==0)
        		System.out.println("Sorry nothing available for you right now."); //Printing results matched accoding to user input
        	else {
        	for(Tshirt t : result )
        	{	
        		System.out.println(t);
        	}
        	}	
        	
        	choice= InputAcceptor.userContinueInput(); //taking input to search another time.
        	
        }while(choice==1); 
        
        scheduler.shutdown();  //Closing the thread.
    }
}
