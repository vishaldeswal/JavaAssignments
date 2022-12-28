package com.nagarro.assignment2.ds.stack;

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
 * LinkedListImpl Class : This class defines the structure of Stack and contains all 
 *  							the related operation methods.
 * 
 * ***/

public class StackImpl< T extends Comparable<T>> implements Stack<T>, Iterable<T> {
	
	int size;
	LLNode head;
	LLNode top;
	
	/**
	 * This method checks whether stack is empty or not
	 * @return true if empty
	 **/
	boolean isStackEmpty() 
	{
		if(getSize()==0)
			{
				return true;
			}
		return false; 
	}
	
	/**
	 * This method return the number of elements in stack
	 **/
	public int getSize()
	{
		return size;
	}
	

	/**
	 * This method insert the given data at the top of stack
	 * 
	 * @para data in node
	 **/
	public void push(T data)
	{
		LLNode newNode= new LLNode(data);
		
		if(isStackEmpty())
			{
				head=newNode;
				top=newNode;
				size++;
				return;
			}
		
		
		LLNode last = head;
		
		while(last.next!=null)
			{
				last=last.next;
			}
		
		last.next=newNode;
		top=last.next;
		size++;
		return;
	}
	
	/**
	 * This method deletes the  data at the top of stack
	 * 
	 * @para data in node
	 **/
	public T pop() 
	{
		if(isStackEmpty())
			{
				System.out.println("\nWARNING:Could not do delete opeartion.Stack is empty.");
			
				return null;
			}
		else if(getSize()==1)
			{	
				T deletedElement= (T)top.data;
				System.out.println("\n"+deletedElement + " is deleted.");
				head=null;
				top=null;
				size--;
				return deletedElement;
			}
		else 
			{
				LLNode secondLastNode = head;
		
				while(secondLastNode.next.next!=null)
					{
						secondLastNode=secondLastNode.next;
					}
		
			T deletedElement=(T) secondLastNode.next.data;
			System.out.println("\n"+deletedElement + " is deleted.");
			secondLastNode.next=null;
			top=secondLastNode;
			size--;
		
			return deletedElement;
	}
	
	}
	
	/**
	 * This method returns the top of stack
	 * 
	 *
	 **/
	public T peek()
	{
		if(isStackEmpty())
			{
				System.out.println("\nERROR: Could not find top element.Stack is empty.");
				return null;
			}
		
		return (T)top.data;
	}
	
	
	/**
	 * This method checks given data pesence in the stack
	 * 
	 * @para data in node
	 **/
	public boolean hasContains(T item)
	{	if(isStackEmpty())
			{
				System.out.println("\nERROR:No elements present. Stack is empty.");
			}
		else
			{
				LLNode newNode=head;
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
	 * This method find the middle node of  stack
	 * @return middle node
	 **/
	public LLNode centreElements() 
	{
		if(isStackEmpty())
		{	System.out.println("\nWARNING: Stack is empty, could not find centre node");
			return null;
		}
	
	
	LLNode slowPointer=head;
	LLNode fastPointer=head;
	
	
	while(fastPointer.next!=null && fastPointer.next.next!=null)
		{	
	   
		slowPointer=slowPointer.next;
		fastPointer=fastPointer.next.next;
	   
		}
	
	return slowPointer;
	}
	
	/**
	 * This method sort the  elements of stack in ascending order.
	 **/
	public void sort() 
	{
		if(isStackEmpty())
		{
			System.out.println("Error:Sorting not possible as Stack is Empty.");
		
			return;
		}

		else if(getSize()==1)
  		{
	  
	  		return;
  		}

		LLNode current = head;
		LLNode index = null;
		T temp;

		if (head != null)
		{
			while (current != null)
				{
				index = current.next;

				while (index != null)
					{
						if (compareTwoValues((T) current.data, (T) index.data)) 
							{
								temp = (T) current.data;
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
	 * This method reverse the order elements in the Stack
	 **/
	public void reverse() 
	{
		if(isStackEmpty())
		{
			System.out.println("Error:Reversing not possible as stack is Empty.");
			
			return;
		}
	
	
	else if(getSize()==1)
		{
			return;
		}
	
	LLNode prevNode = head;
	LLNode currNode = head.next;
	
	while (currNode != null) 
		{
			LLNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
	
	head.next = null;
	top=head;
	head = prevNode;
	
	}
	
	
	/**
	 * This method displays the whole stack
	 **/
	public void display() 
	{	if(isStackEmpty())
			{
				System.out.println("\nERROR:No elements to display as stack is empty.");
				return;
			}
		
		LLNode show = head;
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
		
		return new Iterator<T>() 
		{	LLNode<T> current= null;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current==null && head != null)
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
			if(current==null && head != null)
			{
				current=head;
				return (T)head.data;
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
