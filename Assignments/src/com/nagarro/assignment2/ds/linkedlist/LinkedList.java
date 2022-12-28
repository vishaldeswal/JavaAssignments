package com.nagarro.assignment2.ds.linkedlist;

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
 * LinkedList Interface : This gives blueprint for LinkedListImpl class.
 * 
 * ***/

public interface LinkedList<T> {
	
	void insertAtLast(T data);
	void insertAtPosition(T data,int position);
	T deleteFromLast();
	int getSize();
	T deleteFromPosition(int position);
	LLNode findCentreElement();
	
	void reverse();
	void sort();
	void display();
	
}
