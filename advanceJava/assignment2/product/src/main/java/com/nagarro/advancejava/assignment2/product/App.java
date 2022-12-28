package com.nagarro.advancejava.assignment2.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.nagarro.advancejava.assignment2.product.constants.Constant;
import com.nagarro.advancejava.assignment2.product.database.HibernateUtility;
import com.nagarro.advancejava.assignment2.product.io.InputAcceptor;
import com.nagarro.advancejava.assignment2.product.io.UserInput;
import com.nagarro.advancejava.assignment2.product.tshirtcontroller.UpdationCheck;
import com.nagarro.advancejava.assignment2.product.tshirtmodel.Tshirt;


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
{
    public static void main( String[] args )
    {	
    	
    	/*Stores the tshirts which fullfills the user requirements.*/
        List<Tshirt> result = null; 
        
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
       
        	
        	//Resulted Tshirt List
        	result=input.findTshirts();
        
        	
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

