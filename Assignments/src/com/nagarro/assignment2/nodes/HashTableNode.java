package com.nagarro.assignment2.nodes;

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
 * HashTableNodes Class : This class defines structure of HashTable node
 * 
 * ***/
public class HashTableNode {

	public int key;
	public Object value;
	public HashTableNode next;
	
	
	
	
	public HashTableNode(int key, Object value)
	{
		this.key=key;
		this.value=value;
		this.next=null;
	}
	

	public HashTableNode()
	{
		
		this.next=null;
	}
	
}
