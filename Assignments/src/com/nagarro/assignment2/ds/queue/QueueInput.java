package com.nagarro.assignment2.ds.queue;

import com.nagarro.assignment2.ValidInputChecker;
import com.nagarro.assignment2.ds.stack.StackImpl;
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
 * QueueInput Class : This class defines user interaction capabilties of Queue
 *  						and contains their related methods.
 * 
 * ***/
public class QueueInput {


	/**
	 * This method print choices for user to use different operation of queue.
	 **/

	public static void queueOperation()
	{
		boolean choice=false; 
		QueueImpl<Integer> list= new QueueImpl<Integer>(); 
		
		do {
			System.out.println("\n___QUEUE___\n");
			System.out.println("Choose operation:\n1)Enqueue\n2)Dequeue\n3)Peek\n4)Contains\n5)Size\n6)Centre Node\n7)Sort\n8)Reverse\n9)Display \n");
			
			int input= ValidInputChecker.takeValidIntInput(1,9);
			
		
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
				list.sort();
				break;
			case 8:
				list.reverse();
				break;
			case 9:
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
	 * This method takes input of data from user and calls enqueue operation of Queue.
	 * 
	 * @param map: object of QueueImpl
	 **/
	public static void doEnqueue(QueueImpl list) 
	{
		int data=0;
		System.out.println("\nEnter the element to enqueue in queue:\n");
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
	 * This method calls dequeue() operation of Queue.
	 * 
	 * @param map: object of QueueImpl
	 **/
	public static void doDequeue(QueueImpl list) 
	{
		Object obj= list.dequeue();
		if(obj!=null)
		{
			int deletedElement=((Integer)obj).intValue();
		}
		
	}
	
	/**
	 * This method calls peek() operation of Queue which prints Front element.
	 * 
	 * @param map: object of QueueImpl
	 **/
	static public void printFront(QueueImpl list) 
	{
		Object obj=list.peek();
		
		if(obj!=null)
		{	int top= ((Integer)obj).intValue();
			System.out.println("Front element of Queue= "+top);
		}
	}
	
	
	/**
	 * This method calls hasContains() operation of  Queue 
	 * which checks element present in queue or not.
	 * 
	 * @param map: object of QueueImpl
	 * @return true if present
	 **/
	static public void checkPresence(QueueImpl list) 
	{
		int elementCheck=0;
		System.out.println("\nEnter the element to check presence in Stack:");
		try {
			elementCheck= ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		
		String s=(list.hasContains(elementCheck))? "Element present in Queue" : "Element absent in Queue";
		System.out.println("\n"+s);
	}
	
	
	/**
	 * This method calls getSize() of  queue and print the size of queue.
	 * 
	 * @param map: object of QueueImpl
	 **/
	static public void printSize(QueueImpl list) 
	{
		int size=list.getSize();
		System.out.println("Size of Queue: "+size);
	}
	
	/**
	 * This method calls centreElements() of  Queue and print the data of that node.
	 * 
	 * @param map: object of QueueImpl
	 **/
	static public void printCentreNode(QueueImpl list) 
	{
		LLNode centreNode= list.centreElements();
		if(centreNode!=null)
		{
			System.out.println("Centre Node is ("+centreNode.data+")");
		}
	}
	
}
