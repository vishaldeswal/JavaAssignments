package com.nagarro.assignment2.ds.queue;

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
 * Queue Interface : This gives blueprint for QueueImpl class.
 * 
 * ***/
public interface Queue<T> {
	
	void enqueue(T data);
	int getSize();
	T dequeue();
	T peek();
	boolean hasContains(T item);
	LLNode centreElements();
	void reverse();
	void display();

}
