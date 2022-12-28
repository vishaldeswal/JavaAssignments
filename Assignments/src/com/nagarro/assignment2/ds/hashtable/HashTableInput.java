package com.nagarro.assignment2.ds.hashtable;

import com.nagarro.assignment2.ValidInputChecker;

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
 *  HashTableInput Class : This class defines user interaction capabilties of Hashtable 
 *  						and contains their related methods.
 * 
 * ***/

public class HashTableInput {
	
	/**
	 * This method print choices for user to use differnt operation of HashTable.
	 **/
	public static void hashTableOperation()
	{
		boolean choice=false; 
		HashTableImpl<Integer> map  = new HashTableImpl<Integer>(); 
		
		do 
			{
				System.out.println("\n___HASH_TABLE___\n");
				System.out.println("Choose operation:\n1)Insert by key\n2)Delete by key\n3)Value contains check\n4)Get Value by key\n5)Size\n6)Display\n");
			
				int input= ValidInputChecker.takeValidIntInput(1,9);
			
		
				switch(input)
					{
						case 1:
							doInsert(map); 
							break;
						case 2:
							doDelete(map);
							break;
						case 3:
							checkValuePresent(map);
							break;
						case 4:
							printValueForKey(map);
							break;
						case 5:
							printSize(map);
							break;
						case 6:
							map.display();
							break;
						default:
							System.out.println("ERROR: Invalid Input.");
				
				
					}
			
				System.out.println("\n\nDo you want to continue?\n 1)YES\n 2)NO");
			
				int ch=ValidInputChecker.takeValidIntInput(1, 2);
				
				switch(ch)
					{ 
						case 1:
							choice=true;
							break;
						case 2:
							choice=false;
							break;
					}	 

			
		}while(choice==true);
	}
	
	
	/**
	 * This method takes input of key and pair from user and calls insert operation of HashTable.
	 * 
	 * @param map: object of HashTableImpl
	 **/
	public static void doInsert(HashTableImpl<Integer> map)
	{
		int key=0,value=0;
		try 
			{
				System.out.println("\nEnter the Key for map entry:\n");
				key= ValidInputChecker.sc.nextInt(); //input the key
		
				System.out.println("\nEnter the value for key:\n");
				value= ValidInputChecker.sc.nextInt(); // input value
			}
		catch(Exception e)
			{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
			}
		
		map.insert(key, value); //inert (key, pair) in hashTable
	}
	
	
	
	/**
	 * This method takes input of key  calls deletes operation of HashTable.
	 * 
	 * @param map: object of HashTableImpl
	 **/
	public static void doDelete(HashTableImpl<Integer> map)
	{
		int key=0;
		
		System.out.println("\nEnter the key for deletion from map:\n");
		try 
			{
				key= ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
		{
			System.out.println("Error:Enter the valid integer.");
			ValidInputChecker.sc.nextLine();
		}
		
		map.delete(key);
	}
	
	
	/**
	 * This method takes input of value and instruct whether it is present in HashTable
	 * or not
	 * @param map: object of HashTableImpl
	 **/
	public static void checkValuePresent(HashTableImpl<Integer> map)
	{
		Integer value=0;
		System.out.println("\nEnter the value to check presence in HashMap:\\n");
		try 
			{
				value= ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
			{
				System.out.println("Error:Enter the valid integer.");
				ValidInputChecker.sc.nextLine();
			}
		boolean present=map.hasContains(value);
		String s=(present)? "Element present in HashMap" : "Element absent in Hashmap";
		System.out.println("\n"+s);
		
	}
	
	/**
	 * This method prints number of record in hashTable
	 * @param map: object of HashTableImpl
	 **/
	public static void printSize(HashTableImpl<Integer> map)
	{
		int size=map.getSize();
		System.out.println("Size of HashMap: "+size);
	}
	
	
	/**
	 * This method prints value for the inpyted key if present.
	 * @param map: object of HashTableImpl
	 **/
	public static void printValueForKey(HashTableImpl<Integer> map)
	{
		Integer key=0;
		System.out.println("\nEnter the key to print coresponding value:\\n");
		try 
			{
				key= ValidInputChecker.sc.nextInt();
			}
		catch(Exception e)
			{
				System.out.println("Error:Enter the valid integer.");
				ValidInputChecker.sc.nextLine();
			}
		map.getValue(key);
	}
}
