package com.nagarro.assignment2.ds.linkedlist;

import com.nagarro.assignment2.ValidInputChecker;
import com.nagarro.assignment2.nodes.*;
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
 * LinkedListInput Class : This class defines user interaction capabilties of LinkedList 
 *  						and contains their related methods.
 * 
 * ***/

public class LinkedListInput {
	/**
	 * This method print choices for user to use different operation of Linkedlist.
	 **/
	public static void linkedListOperation()
	{	
		boolean choice=false; 
		LinkedListImpl<Integer> list= new LinkedListImpl<Integer>(); 
		
		do 
		{
			
			System.out.println("\n___LINKED LIST___\n");
			System.out.println("Choose operation:\n1)Insert at back\n2)Insert At postion\n3)Delete from back\n4)Delete from position\n5)Find centre element\n6)Sort the LL\n7)Reverse the LL\n8)Size of LL\n9)Display \n");
			
			int input= ValidInputChecker.takeValidIntInput(1,9);
		
			
			switch(input)
			{
				case 1:
					insertLast(list);
					break;
					
				case 2:
					insertPosition(list);
					break;
				case 3:
					deleteLast(list);
					break;
					
				case 4:
					deletePosition(list);
					break;
					
				case 5:
					findCentre(list);
					break;
				case 6:
					list.sort();
					break;
				case 7:
					list.reverse();
					break;
				case 8:
					printSize(list);
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
	 * This method takes input of data from user and calls insertAtLast operation of linkedlist.
	 * 
	 * @param map: object of LinkedListImpl
	 **/
	static void insertLast(LinkedListImpl list)
	{	int data=0;
		
		System.out.println("\nEnter the element to insert in Linked list last:\n");
		try {
			data= ValidInputChecker.sc.nextInt();
			
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		list.insertAtLast(data);
	}
	
	/**
	 * This method takes input of data from user and calls insertAtPosition operation of linkedlist.
	 * 
	 * @param map: object of LinkedListImpl
	 **/
	static void insertPosition(LinkedListImpl list)
	{	int data=0,position=0;
		try {
			System.out.println("\nEnter the element to insert in Linked list at position:\n");
			data= ValidInputChecker.sc.nextInt();
		
			System.out.println("\nEnter the position.:\n");
			position= ValidInputChecker.sc.nextInt();
		
			
			}
		catch(Exception e)
			{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
			}
		list.insertAtPosition(data, position);
	}
	
	/**
	 * This method calls deleteFromLast() operation of linkedlist.
	 * 
	 * @param map: object of LinkedListImpl
	 **/
	static void deleteLast(LinkedListImpl list)
	{
		list.deleteFromLast();
		
	}
	
	
	/**
	 * This method calls deleteFromPosition operation of linkedlist.
	 * 
	 * @param map: object of LinkedListImpl
	 **/
	static void deletePosition(LinkedListImpl list)
	{	int position=0;
		try {
			System.out.println("\nEnter the position of node to delete:\n");
			position = ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
			{
				System.out.println("Error:Enter the valid integer.");
				ValidInputChecker.sc.nextLine();
			}
			
		list.deleteFromPosition(position);
	}
	
	
	/**
	 * This method calls findCentreElement() of linkedlist and print the data fo that node.
	 * 
	 * @param map: object of LinkedListImpl
	 **/
	static void findCentre(LinkedListImpl list)
	{
		LLNode centreNode= list.findCentreElement();
		if(centreNode!=null)
		{
			System.out.println("Centre Node is ("+centreNode.data+")");
		}
	}
	
	
	/**
	 * This method calls getSize() of linkedlist and print the size of LinkedList.
	 * 
	 * @param map: object of LinkedListImpl
	 **/
	static void printSize(LinkedListImpl list)
	{
		int size=list.getSize();
		System.out.println("Size of LinkedList: "+size);
	}
	

}
