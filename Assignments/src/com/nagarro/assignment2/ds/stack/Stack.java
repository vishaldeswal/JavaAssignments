package com.nagarro.assignment2.ds.stack;

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
 * Stack Interface : This gives blueprint for StackImpl class.
 * 
 * ***/
public interface Stack<T> {
	
	void push(T data);
	T pop();
	T peek();
	boolean hasContains(T item);
	int getSize();
	LLNode centreElements();
	void sort();
	void reverse();
	void display();
	

}
