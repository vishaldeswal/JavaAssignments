package com.nagarro.assignment2.ds.priorityqueue;

import com.nagarro.assignment2.ValidInputChecker;
import com.nagarro.assignment2.nodes.LLNode;
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
 * PriorityQueueInput Class : This class defines user interaction capabilties of PriorityQueue
 *  						and contains their related methods.
 * 
 * ***/

public class PriorityQueueInput {
	
	
	/**
	 * This method print choices for user to use different operation of priority queue.
	 **/
	public static void priorityQueueOperation()
	{
		boolean choice=false; 
		PriorityQueueImpl<Integer> list= new PriorityQueueImpl<Integer>(); 
		
		do {
			System.out.println("\n___PRIORITY_QUEUE___\n");
			System.out.println("Choose operation:\n1)Enqueue\n2)Dequeue\n3)Peek\n4)Contains\n5)Size\n6)Centre Node\n7)Reverse\n8)Display \n");
			
			int input= ValidInputChecker.takeValidIntInput(1,8);
			
		
			switch(input)
			{
			case 1:
				doEnqueue(list);
				break;
			case 2:
				doDequeue(list);
				break;
			case 3:
				printFront(list);
				break;
			case 4:
				checkPresence(list);
				break;
			case 5:
				printSize(list);
				break;
			case 6:
				printCentreNode(list);
				break;
			case 7:
				list.reverse();
				break;
			case 8:
				list.display();
				break;
			default:
				System.out.println("ERROR: Invalid Input.");
				
				
			}
			
			System.out.println("\n\nDo you want to continue?\n 1)YES\n 2)NO");
			
			int ch=ValidInputChecker.takeValidIntInput(1, 2);
				
			switch(ch)
				{ case 1:
					choice=true;
					break;
		  		  case 2:
					choice=false;
					break;
		  		 }	 

			
		}while(choice==true);
	}
	/**
	 * This method takes input of data from user and calls enqueue operation of Priority Queue.
	 * 
	 * @param map: object of PriorityQueueImpl
	 **/
	public static void doEnqueue(PriorityQueueImpl list) 
	{
		int data=0;
		System.out.println("\nEnter the element to enqueue in Priority queue:\n");
		try {
			data= ValidInputChecker.sc.nextInt();
			
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		list.enqueue(data);
	}
	/**
	 * This method calls dequeue() operation of Priority Queue.
	 * 
	 * @param map: object of PriorityQueueImpl
	 **/
	public static void doDequeue(PriorityQueueImpl list) 
	{
		Object obj=list.dequeue();
		if(obj!=null)
		{
			int deletedElement=((Integer)obj).intValue();
		}
	}
	
	
	/**
	 * This method calls peek() operation of Priority Queue which prints Front element.
	 * 
	 * @param map: object of PriorityQueueImpl
	 **/
	static public void printFront(PriorityQueueImpl list) 
	{
		
		Object obj=list.peek();
		
		if(obj!=null)
		{	int top= ((Integer)obj).intValue();
			System.out.println("Front element of priority queue= "+top);
		}
	}
	
	
	
	/**
	 * This method calls hasContains() operation of Priority Queue 
	 * which checks element present in priority queue or not.
	 * 
	 * @param map: object of PriorityQueueImpl
	 * @return true if present
	 **/
	static public void checkPresence(PriorityQueueImpl list) 
	{
		int elementCheck=0;
		System.out.println("\nEnter the element to check presence in priority Queue:\n");
		try {
			elementCheck= ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		
		String s=(list.hasContains(elementCheck))? "Element present in Priority Queue" : "Element absent in Priority Queue";
		System.out.println("\n"+s);
	}
	
	
	/**
	 * This method calls getSize() of priority queue and print the size of priority queue.
	 * 
	 * @param map: object of PriorityQueueImpl
	 **/
	static public void printSize(PriorityQueueImpl list) 
	{
		int size=list.getSize();
		System.out.println("Size of Priority Queue: "+size);
	}
	
	
	/**
	 * This method calls centreElements() of Priority Queue and print the data of that node.
	 * 
	 * @param map: object of PriorityQueueImpl
	 **/
	static public void printCentreNode(PriorityQueueImpl list) 
	{
		LLNode centreNode= list.centreElements();
		if(centreNode!=null)
		{
			System.out.println("Centre Node is ("+centreNode.data+")");
		}
	}
	
	

}
