package com.nagarro.assignment2;

import com.nagarro.assignment2.ds.linkedlist.*;

import com.nagarro.assignment2.ds.stack.*;
import com.nagarro.assignment2.nodes.*;
import com.nagarro.assignment2.ds.queue.*;
import com.nagarro.assignment2.ds.priorityqueue.*;
import com.nagarro.assignment2.ds.hashtable.*;
import java.util.Scanner;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Implement following data structure and its operation:
 * 				1)LinkedList
 * 				2)Stack
 * 				3)Queue
 * 				4)PriorityQueue
 * 				5)HashTable
 * 
 * ValidInputChecker Class : This class contain valid input checking methods. 
 * 
 * ***/



public class ValidInputChecker {
	final public static Scanner sc = new Scanner(System.in);
	
	/**
	 * This method checks whether entered value int and is between given range (left, right).
	 * @param left :lower bound of range.
	 * @param right : upper bound of range.
	 * @return input :valid integer between range (left,right).
	 */
	public static int takeValidIntInput(int left, int right)
	 {	boolean validInput1=false;
	    int input=0;
	    while(validInput1==false)
			{
				try {
						System.out.print("\n\nYour choice: ");	
						input=sc.nextInt();
						if(input>=left && input<=right)
						{
							
							validInput1=true;
						}
						else 
						{
							System.out.println("ERROR:- Only Enter "+left+" to "+right+" as input.Try Again");	
						}
						
						
					}catch(Exception e)
						{
							System.out.println("ERROR:- Invalid Input.Try again. ");
							sc.nextLine();
						}
				
				
				
				}
			
		
	 
	 	return input; 
	  }
		 
	 
	
	

	
	



}
