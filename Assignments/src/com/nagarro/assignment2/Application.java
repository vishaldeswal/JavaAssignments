package com.nagarro.assignment2;

import com.nagarro.assignment2.*;

import com.nagarro.assignment2.ds.hashtable.HashTableInput;
import com.nagarro.assignment2.ds.linkedlist.LinkedListInput;
import com.nagarro.assignment2.ds.priorityqueue.PriorityQueueInput;
import com.nagarro.assignment2.ds.queue.QueueInput;
import com.nagarro.assignment2.ds.stack.StackInput; 

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
 * Application Class : This is main class where all functions are called and output is shown based on that.
 * 
 * ***/


public class Application {

	public static void main(String []args) {
		
		
		boolean choice=false;  // choice of user to re-continue the program.
		boolean validInput1;	//To check user entered valid input in Switch 1
		boolean validInput2;	//To check user entered valid input in Switch 2
		int choose=0;
		
		do {
			validInput1=false;
			validInput2=false;
			
			System.out.println("Choose your data structure:\n");
			System.out.println("1)LinkedList\n2)Stack\n3)Queue\n4)Priority Queue\n5)HashTable\n6)Exit");
			
			
			 choose= ValidInputChecker.takeValidIntInput(1,6); //take input and check "choose" variable gets only 
			 													//integer value between 1 to 6.
		
			switch(choose) //Switch 1
			{
				case 1:
					LinkedListInput.linkedListOperation(); //Enter into the linkedlist operation menu.
					break;
				case 2:
					StackInput.stackOperation();  //Enter into the stack operation menu.
					break;
				case 3:
					QueueInput.queueOperation(); //Enter into the queue operation menu.
					break;
				case 4:
					PriorityQueueInput.priorityQueueOperation(); //Enter into the priorty queue operation menu.
					break;
				case 5:
					HashTableInput.hashTableOperation(); //Enter into the HashTable operation menu.
					break;
				case 6:
					System.out.println("Exited");
					System.exit(0); // End the program
					break;
				
					
				
			}
			
			
			
			
			
		
		System.out.println("\n\nUSE ANOTHER DATA STRUCTURE?\n 1)YES\n 2)NO");
		
		
		
			
			
			int ch=ValidInputChecker.takeValidIntInput(1, 2); //take input and check "ch" variable gets only 
															//integer value between 1 or 2.
			
			switch(ch) //Switch 2
			{ case 1:
				choice=true;
				validInput2=true;
				break;
	  		  case 2:
				choice=false;
				validInput2=true;
				break;
	  		  
	  
			}	 
			

		
		
		}while(choice==true);
		

		
		
	}	
		
}
