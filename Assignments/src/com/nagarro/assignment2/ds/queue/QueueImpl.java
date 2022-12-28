package com.nagarro.assignment2.ds.queue;

import com.nagarro.assignment2.nodes.LLNode;
import java.util.Iterator;

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
 * LinkedListImpl Class : This class defines the structure of Queue and contains all 
 *  							the related operation methods.
 * 
 * ***/


public class QueueImpl< T extends Comparable<T>> implements Queue<T>,Iterable<T> {
	
	int size;
	LLNode front;
	LLNode rear;
	
	/**
	 * This method checks whether queue is empty or not
	 * @return true if empty
	 **/
	boolean isQueueEmpty()
	{
		if(rear==null && front==null && getSize()==0)
			{
				return true;
			}
		return false;
	}
	/**
	 * This method return the number of elements in queue
	 **/
	public int getSize()
	{
		return size;
	}
	/**
	 * This method insert the given data at the front of queue
	 * 
	 * @para data in node
	 **/
	public void enqueue(T data)
	{

		LLNode newNode= new LLNode(data);
		
		if(isQueueEmpty())
			{
				front=newNode;
				rear=newNode;
				size++;
				return;
			}
		
		
		LLNode last = front;
		
		while(last.next!=null)
			{
				last=last.next;
			}
		
		last.next=newNode;
		rear=last.next;
		size++;
		return;
	}
	/**
	 * This method deletes the  data from the rear of stack
	 * 
	 * @para data in node
	 **/
	public T dequeue() 
	{
		if(isQueueEmpty())
			{
				System.out.println("\nWARNING: Deletion operation failed .Queue is empty.");
			
				return null;
			}
	
		else
			{	
				T deletedElement=(T) front.data;
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
		if(isQueueEmpty())
		{
			System.out.println("\nWARNING: Could not find Front element.Queue is empty.");
		
			return null;
		}
		
		return (T) front.data;
	}
	
	
	/**
	 * This method checks given data pesence in the queue
	 * 
	 * @para data in node
	 **/
	public boolean hasContains(T item)
	{
		if(isQueueEmpty())
		{
			System.out.println("\nERROR:No elements present. Queue is empty.");
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
	 * This method find the middle node of  queue
	 * @return middle node
	 **/
	public LLNode centreElements()
	{
		if(isQueueEmpty())
		{	System.out.println("\nWARNING: Queue is empty, could not find centre node");
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
	 * This method sort the  elements of queue in ascending order.
	 **/
	public void sort() 
	{
		if(isQueueEmpty())
			{
				System.out.println("Error: Sorting not possible.Queue is Empty.");
		
				return;
			}

		else if(getSize()==1)
  			{
	  
	  			return;
  			}

		LLNode current = front;
		LLNode index = null;
		T temp;

		if (front != null)
		{
		while (current != null)
			{
				index = current.next;

				while (index != null)
					{
						if (compareTwoValues((T) current.data, (T) index.data)) 
							{
								temp = (T)current.data;
								current.data = index.data;
								index.data = temp;
							}
						index = index.next;
					}
				current = current.next;
			}
		
		}
	}
	/**
	 * This method reverse the order elements in the queue
	 **/
	public void reverse()
	{
		if(isQueueEmpty())
		{
			System.out.println("Error:Reversing of Queueis not possible as Queue is Empty.");
			
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
	 * This method displays the whole queue
	 **/
	public void display() 
	{
		if(isQueueEmpty())
		{
			System.out.println("\nERROR: No elements to display as Queue is empty.");
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
	
	public boolean compareTwoValues(T value1, T value2) {
	    return value1.compareTo(value2) > 0;
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
