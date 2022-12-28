package com.nagarro.assignment2.ds.stack;

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
 * StackInput Class : This class defines user interaction capabilties of Stack
 *  						and contains their related methods.
 * 
 * ***/
public class StackInput {


	/**
	 * This method print choices for user to use different operation of stack.
	 **/

	public static void stackOperation()
	{	
		boolean choice=false; 
		StackImpl<Integer> list= new StackImpl<Integer>(); 

		do {
			
			System.out.println("\n___STACK___\n");
			System.out.println("Choose operation:\n1)Push\n2)Pop\n3)Peek\n4)Contains\n5)Size\n6)Centre Node\n7)Sort the Stack\n8)Reverse the Stack\n9)Display \n");
			
			int input= ValidInputChecker.takeValidIntInput(1,9);
		
		switch(input)
		{
			case 1:
				doPush(list);
				break;
			case 2:
				doPop(list);
				break;
			case 3:
				printTop(list);
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
	 * This method takes input of data from user and calls push operation of Stack.
	 * 
	 * @param map: object of StackImpl
	 **/
	static public void doPush(StackImpl list) 
	{	int data=0;
		System.out.println("\nEnter the element to push in Stack:\n");
		try {
			data= ValidInputChecker.sc.nextInt();
			
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		list.push(data);
	}
	
	/**
	 * This method calls pop() operation of Stack.
	 * 
	 * @param map: object of StackImpl
	 **/
	static public void doPop(StackImpl list) 
	{
		Object obj=list.pop();
		if(obj!=null)
		{
			int deletedElement= ((Integer)obj).intValue();
		}
		
	}
	
	/**
	 * This method calls peek() operation of Priority Queue which prints top element.
	 * 
	 * @param map: object of PriorityQueueImpl
	 **/
	static public void printTop(StackImpl list) 
	{
		Object obj=list.peek();
		
		
		if(obj!=null)
		{	int top= ((Number)obj).intValue();
			System.out.println("Top element of Stack= "+top);
		}
	}
	
	/**
	 * This method calls hasContains() operation of stack 
	 * which checks element present in stack or not.
	 * 
	 * @param map: object of StackImpl
	 * @return true if present
	 **/
	static public void checkPresence(StackImpl list) 
	{
		int elementCheck=0;
		System.out.println("\nEnter the element to check presence in Stack:\n");
		try {
			elementCheck= ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		String s=(list.hasContains(elementCheck))? "Element present in Stack" : "Element absent in Stack";
		System.out.println("\n"+s);
	}
	
	/**
	 * This method calls getSize() of stack and print the size of stack.
	 * 
	 * @param map: object of StackImpl
	 **/
	static public void printSize(StackImpl list) 
	{
		int size=list.getSize();
		System.out.println("Size of Stack: "+size);
	}
	
	/**
	 * This method calls centreElements() of stack and print the data of that node.
	 * 
	 * @param map: object of StackImpl
	 **/
	static public void printCentreNode(StackImpl list) 
	{
		LLNode centreNode= list.centreElements();
		if(centreNode!=null)
		{
			System.out.println("Centre Node is ("+centreNode.data+")");
		}
		
	}
	
}
