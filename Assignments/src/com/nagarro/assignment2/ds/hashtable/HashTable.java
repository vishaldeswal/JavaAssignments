package com.nagarro.assignment2.ds.hashtable;


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
 *  HashTable Interface : This gives the blueprint to the HashTableImpl class.
 * 
 * ***/

public interface HashTable <T> {
	
	int getSize();
	void insert(int key, T value);
	T delete( int key);
	boolean hasContains(T value);
	T getValue(int key);
	void display();

}
