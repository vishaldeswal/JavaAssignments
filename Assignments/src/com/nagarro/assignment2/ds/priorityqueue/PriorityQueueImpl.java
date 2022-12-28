package com.nagarro.assignment2.ds.priorityqueue;

import com.nagarro.assignment2.ds.queue.*;
import java.util.Iterator;
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
 * LinkedListImpl Class : This class defines the structure of Priority Queue and contains all 
 *  							the related operation methods.
 * 
 * ***/


public class PriorityQueueImpl< T extends Comparable<T>> implements Queue<T>, Iterable<T>{
	
	int size;
	LLNode front;
	LLNode rear;
	/**
	 * This method checks whether priority queue is empty or not
	 * @return true if empty
	 **/
	boolean isPriorityQueueEmpty()
	{
		if(front == null && rear == null && getSize()==0)
			{
				return true;
			}
		return false;
	}
	/**
	 * This method return the number of elements in priority queue
	 **/
	public int getSize()
	{
		return size;
	}
	
	/**
	 * This method insert the given data at the front of priority queue
	 * 
	 * @para data in node
	 **/
	public void enqueue(T data)
	{	LLNode newNode=new LLNode(data);
		
		if(isPriorityQueueEmpty())
			{
				front=newNode;
				rear=newNode;
				size++;
				return;
			}
		
		
		
		if(isLessThan((T)front.data ,(T)newNode.data))
			{
				newNode.next=front;
				front=newNode;
				size++;
				return;
			}
		else 
			{
				LLNode prevNode=front;
				LLNode nextNode=front.next;
				
				while(nextNode!= null)
					{
						if(isGreaterEqualsTo((T)prevNode.data,(T)newNode.data) && isGreaterThan((T)newNode.data, (T)nextNode.data))
							{
								newNode.next=prevNode.next;
								prevNode.next=newNode;
								size++;
								return;
							}
						prevNode=prevNode.next;
						nextNode=prevNode.next;
						
					}
				prevNode.next=newNode;
				rear=prevNode.next;
				size++;
			}
		return;
	}
	
	/**
	 * This method deletes the  data from rear of priority queue
	 * 
	 * @para data in node
	 **/
	public T dequeue() 
	{
		if(isPriorityQueueEmpty())
		{
			System.out.println("\nWARNING:Could not do delete operation.Priority Queue is empty.");
		
			return null;
		}

	else
		{	
			T deletedElement=(T)front.data;
			if(front.next==null)
			{
				front=front.next;
				rear=front;
				System.out.println(deletedElement + " is deleted");
				size--;
				return deletedElement;
			}
			front=front.next;
			System.out.println(deletedElement + " is deleted");
			size--;
    
			return deletedElement;
		}
	}
	
	/**
	 * This method returns the front of queue
	 * 
	 * 
	 **/
	public T peek() 
	{
		if(isPriorityQueueEmpty())
		{
			System.out.println("\nWARNING:Could not find front Element.Priority Queue is empty.");
		
			return null;
		}
		
		return (T)front.data;
		
	}
	
	
	/**
	 * This method checks given data pesence in the priority queue
	 * 
	 * @para data in node
	 **/
	public boolean hasContains(T item) 
	{
		if(isPriorityQueueEmpty())
		{
			System.out.println("\nERROR:Priority Queue is empty.");
		}
		else
		{
			LLNode newNode=front;
			while(newNode!=null)
				{
					if(newNode.data==item)
						{
							return true;
						}
					newNode=newNode.next;
				}
		}	
	return false;
	}
	
	/**
	 * This method find the middle node of  priority queue
	 * @return middle node
	 **/
	public LLNode centreElements()
	{
		if(isPriorityQueueEmpty())
		{	System.out.println("\nWARNING: Priority Queue is empty, could not find centre node");
			return null;
		}
	
	
	LLNode slowPointer=front;
	LLNode fastPointer=front;
	
	
	while(fastPointer.next!=null && fastPointer.next.next!=null)
		{	
	   
		slowPointer=slowPointer.next;
		fastPointer=fastPointer.next.next;
	   
		}
	
	return slowPointer;
	}
	
	/**
	 * This method reverse the order elements in the priority queue
	 **/
	public void reverse() 
	{
		if(isPriorityQueueEmpty())
		{
			System.out.println("WARNING: Reversing is not possible as Priority Queue is Empty.");
			
			return;
		}
	
	
	else if(getSize()==1)
		{
			return;
		}
	
	LLNode prevNode = front;
	LLNode currNode = front.next;
	
	while (currNode != null) 
		{
			LLNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
	
	front.next = null;
	rear=front;
	front = prevNode;
		
	}
	
	/**
	 * This method displays the whole Priority queue
	 **/
	public void display()
	{
		if(isPriorityQueueEmpty())
		{
			System.out.println("\nWARNING:No elements to dispaly as Priority Queue is empty.");
			return;
		}
	
	LLNode show = front;
	while(show != null)
	{
		System.out.print("( "+show.data+" )->");
		show=show.next;
	}
	System.out.print(" NULL");
	return;
	}
	
	public boolean isGreaterThan(T value1, T value2) {
	    return value1.compareTo(value2) > 0;
	}
	
	public boolean isLessThan(T value1, T value2) {
	    return value1.compareTo(value2) < 0;
	}
	
	public boolean isGreaterEqualsTo(T value1, T value2) {
	    return value1.compareTo(value2) > 0	|| value1.compareTo(value2) == 0 ;
	}
	
	
	/**
	 * Custom iterator
	 **/
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() 
		{	LLNode<T> current= null;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current==null && front != null)
			{
				return true;
			}
			
			else if(current !=null)
			{
				return current.next != null;
			}	
			
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(current==null && front != null)
			{
				current=front;
				return (T)front.data;
			}
			else if(current != null)
			{
				T element = (T) current.data;
				current=current.next;
				return element;
			}
			return null;
		}
		
	};
	}

}
