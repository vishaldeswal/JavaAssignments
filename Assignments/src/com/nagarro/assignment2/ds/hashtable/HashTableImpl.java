package com.nagarro.assignment2.ds.hashtable;

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
 *  HashTableImpl Interface : This class defines the structure of hashtable and contains all 
 *  							the related operation methods.
 * 
 * ***/



public class HashTableImpl<T> implements HashTable<T>{
	
	HashTableNode[] arrayHash = new HashTableNode[10]; //Array to map (key, value) with hashKey of size(10).
	private int size; 					// number of (key,value) pair stored in Hash Table
	
	
	/**
	 * This Constructor initialize size with 0 and arrayHash[i].next with null
	 **/
	public HashTableImpl()
	{
		this.size=0;
		for(int i=0; i<10; i++)
			arrayHash[i]=new HashTableNode();
	}
	
	
	/**
	 * This method finds the hash-key for corresponding key.
	 *@param  key of HashTable Entry
	 *@return HashKey
	 **/
	public int getHashKey( int key)
	{
		return key%10;  
	}
	
	
	/**
	 * This method return the total number of (key, pair) store in HashTable
	 *@return size
	 **/
	public int getSize()
	{
		return size;
	}
	
	
	

	/**
	 * This method insert the (key, value) pair in HashTable
	 *@param key :key of HashTable Entry
	 *@param value: value mapped to above key
	 **/
	public void insert(int key, T value)
	{	
		int hashIndex=getHashKey(key);
		HashTableNode newNode= new HashTableNode(key,value);
		
		if(arrayHash[hashIndex].next == null) // if no records at HashKey
		{
			arrayHash[hashIndex].next=newNode;
			size++;
			return;
		}
		
		else
		{														// insert the new record at last of present records 
			HashTableNode lastNodeAtIndex = arrayHash[hashIndex];
			while(lastNodeAtIndex.next != null)
			{
				lastNodeAtIndex=lastNodeAtIndex.next;
			}
			lastNodeAtIndex.next=newNode;
			size++;
			return;
			
		}
		
	}
	
	
	/**
	 * This method gets the value mapped to given key.
	 *@param key :key of HashTable Entry
	 *@return value: mapped to given key if key present in HashTable
	 *			
	 **/
	
	public T getValue(int key)
	{	int hashIndex=getHashKey(key);
		T value=null;
		HashTableNode arrayValue= arrayHash[hashIndex];
		while(arrayValue != null) //traverse whole hashTable
		{
			if(arrayValue.key==key)
			{
				value= (T) arrayValue.value;
				break;
			}
			arrayValue=arrayValue.next;
		}
		if(value!=null)
		{
			System.out.println("\nValue for this key is "+value);
			return value;
		}
		else
		{
			System.out.println("\nNo value for corresponding key.\n");
			return null;
		}	
		
	}
	/**
	 * This method deletes the first (key,pair) for given key. 
	 *@param key :key of HashTable Entry
	 *@return value: mapped to given key if key present in HashTable
	 *			
	 **/
	public T delete(int key)
	{
		int hashIndex=getHashKey(key);
		
		HashTableNode prevNode= arrayHash[hashIndex]; //points to node which just before deletion node 
		HashTableNode currNode= arrayHash[hashIndex].next;// point to deletion node.
		
		while(currNode != null)
		{
			if(currNode.key==key)
			{
				break;
			}
			prevNode=currNode;
			currNode=currNode.next;
		}
		
		if(currNode==null)
		{
			System.out.println("There is no value with the key:"+ key);
			return null;
		}
		else if(prevNode!=null)
		{
			prevNode.next=currNode.next;
			size--;
		}
		System.out.println("\n("+currNode.key+", "+currNode.value+" ) is deleted from hashMap.");
		return (T) currNode.value;
	}
	
	/**
	 * This method checks whether given value present in any stored (key, value) pair in HashTable. 
	 *@param value: mapped to given key if key present in HashTable.
	 *	@return true if present.		
	 **/
	public boolean hasContains(T value)
	{
		int hashIndex=0;
		while(hashIndex<10) //to traverse arrayHash 
		{
			HashTableNode currNode=arrayHash[hashIndex].next;
			
			if(currNode==null)  //No entry at given hashKey
			{
				hashIndex++;
				continue;
			}
			
			while(currNode!=null)   // traverse all record of one hash key. if records present at hashkey
			{
				if( (T) currNode.value == value) //check given value present in these records
				{
					return true;
				}
				currNode=currNode.next;
			}
			hashIndex++;
		}
		return false;
	}
	
	/**
	 * This method displays the whole hashTable.		
	 **/
	public void display()
	{
		int hashIndex=0;
		
		while(hashIndex < 10) //to traverse arrayHash 
		{	
			
			
			if(arrayHash[hashIndex].next==null) //No entry at given hashKey
				{
				System.out.print("\nArr["+hashIndex+"]->NULL");
				}
			
			else                              //entry present at given hashKey
			{	
				HashTableNode currNode= arrayHash[hashIndex].next; //currNode at first record og given hashKey 
				
				System.out.print("\nArr["+hashIndex+"]->");
				while(currNode!=null)           // traverse all record of one hash key.
				{
					System.out.print("( "+currNode.key+", "+currNode.value+" )->"); //print records
					currNode=currNode.next;
				}
				System.out.print("NULL");
			}
			hashIndex++;  //goes to second hashkey.
			System.out.print("\n");
		}
		return;
	}

}
