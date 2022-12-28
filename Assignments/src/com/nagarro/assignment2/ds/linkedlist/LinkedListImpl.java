package com.nagarro.assignment2.ds.linkedlist;

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
 * LinkedListImpl Class : This class defines the structure of linkedlist and contains all 
 *  							the related operation methods.
 * 
 * ***/

public class LinkedListImpl< T extends Comparable<T>> implements LinkedList<T>, Iterable<T> {
	
	int size;
	LLNode<T> head;
	
	
	
	
	
	/**
	 * This method insert the given data at the end of linkedlist
	 * 
	 * @para data in node
	 **/
	public void insertAtLast(T data)
	{
		
		LLNode<T> newNode= new LLNode<T>(data);
		
		if(isLinkedListEmpty()) 
			{
				head=newNode;
				size++;
				return;
			}
		
		
		LLNode last = head;
		
		while(last.next!=null)
			{
				last=last.next;
			}
		
		last.next=newNode;
		size++;
		return;
	}
	
	
	/**
	 * This method insert the given data at the begining of  linkedlist
	 * 
	 * @para data in the new Node
	 **/
	public void insertAtFirst(T data)
	{	
		LLNode newNode= new LLNode(data);
		
		if(isLinkedListEmpty())
			{
				head=newNode;
				size++;
				return;
			}
		
		else
			{
			
				newNode.next=head;
				head=newNode;
				size++;
				return;
			}
		
	}
	
	/**
	 * This method insert the given data at the given position of linkedlist
	 * @para data in node
	 * @para position of to insert node
	 **/
	public void insertAtPosition(T data,int position) 
	{
		if(position > this.getSize()+1 || position <= 0 ) //check valid position
			{
				System.out.println("\nWARNING:Invalid Position input.(Position > 0 and Position <= Size(LinkdList)+1.)");
				return;
			}
		
		
		else if(position==1)
			{
				insertAtFirst(data);
				return;
			}
		
		else if(position== this.getSize()+1)
			{
				insertAtLast(data);
				return;
			}
		
		else
			{	
				LLNode newNode= new LLNode(data);
				LLNode nodeAtPos= head;
				int countVisitedNodes=1;
			
				while(countVisitedNodes < position-1)
					{
						nodeAtPos=nodeAtPos.next;
						countVisitedNodes++;
					}
				
				newNode.next=nodeAtPos.next;
				nodeAtPos.next=newNode;
				size++;
			}
	}
	
	/**
	 * This method delete the node from last of  linkedlist
	 * @return deleted node
	 **/
	public T deleteFromLast()  
	{
		if(isLinkedListEmpty())
			{
				System.out.println("\nWARNING: Deletion Failed.List is empty.");
				
				return null;
			}
		
		else if(getSize()==1)
			{
				T deletedElement = deleteFromFirst();
				
				return deletedElement;
			}
		
		else 
			{
				LLNode<T> secondLastNode = head;
			
				while(secondLastNode.next.next!=null)
				{
					secondLastNode=secondLastNode.next;
				}
			
				T deletedElement= (T) secondLastNode.next.data;
				System.out.println(deletedElement + " is deleted.");
				secondLastNode.next=null;
				size--;
			
				return deletedElement;
		}
		
	}
	
	/**
	 * This method delete the node from begining of  linkedlist
	 * @return deleted node
	 **/
	public T deleteFromFirst()
	{	
		if(isLinkedListEmpty())
			{
				System.out.println("\nWARNING: Deletion Failed.List is empty.");
				
				return null;
			}
		
		else
			{	
				T deletedElement=(T) head.data;
				head=head.next;
				System.out.println(deletedElement + " is deleted");
				size--;
		    
				return deletedElement;
			}
		
	}
	/**
	 * This method delete the node from given postion  linkedlist
	 * @return deleted node
	 **/
	
	public T deleteFromPosition(int position)
	{

		if(isLinkedListEmpty())
		{
			System.out.println("\nWARNING: Deletion Failed.List is empty.");
			
			return null;
		}
		
		if(position > this.getSize() || position <= 0 )
		{
			System.out.println("\nWARNING:Invalid Position input.(Position > 0 and Position <= Size(LinkdList)+1.)");
			
			return null;
		}
		
		
		else if(position==1)
		{
			T deletedElement=deleteFromFirst();
			
			return deletedElement;
		}
		
		else if(position== this.getSize())
		{
			T deletedElement=deleteFromLast();
			
			return deletedElement;
		}
		
		else
		{	
			LLNode<T> nodeAtPos= head;
			int countVisitedNodes=1;
			
			while(countVisitedNodes < position-1)
				{
					nodeAtPos=nodeAtPos.next;
					countVisitedNodes++;
				}
			
			T deletedElement= (T) nodeAtPos.next.data;
			System.out.print(deletedElement+ "is deleted");
			nodeAtPos.next=nodeAtPos.next.next;
			size--;
			
			return deletedElement;
		}
		
	}
	
	
	/**
	 * This method find the middle node of  linkedlist
	 * @return middle node
	 **/
	public LLNode<T> findCentreElement() 
	{ 	
		if(isLinkedListEmpty())
			{	
				System.out.println("\nWARNING: List is empty, could not find centre node");
				return null;
			}
		
		
		LLNode<T> slowPointer=head;
		LLNode<T> fastPointer=head;
		
		
		while(fastPointer.next!=null && fastPointer.next.next!=null)
			{	
		   
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
		   
			}
		
		return slowPointer;
	}
	/**
	 * This method reverse the order elements in the  linkedlist
	 **/
	public void reverse()
	{
		
		if(isLinkedListEmpty())
			{
				System.out.println("\nWARNING:Reversing not possible as Linked List is Empty.\n");
				
				return;
			}
		
		
		else if(getSize()==1)
			{
				return;
			}
		
		LLNode<T> prevNode = head;
		LLNode<T> currNode = head.next;
		
		while (currNode != null) 
			{
				LLNode<T> nextNode = currNode.next;
				currNode.next = prevNode;
				prevNode = currNode;
				currNode = nextNode;
			}
		
		head.next = null;
		head = prevNode;
		
	}
	
	/**
	 * This method sort the  elements of linkedlist in ascending order.
	 **/
	public void sort() 
	{ 
		if(isLinkedListEmpty())
			{
				System.out.println("WARNING: Sorting not possible as Linked List is Empty.");
			
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
	 * This method displays the whole linkedlist
	 **/
	public void display() {
		
		LLNode<T> show= head;
		
		if(isLinkedListEmpty())
		{
			System.out.println("\nWARNING:No elements to display as List is empty.");
			return;
		}
		
		
		while(show!=null)
		{	System.out.print("( "+show.data+" )-->");
			show= show.next;
		}
		System.out.print(" NULL\n");
	}
	
	/**
	 * This method return the number of elements in linkedlist
	 **/
	public int getSize()
	{
		return size;
	}
	
	
	/**
	 * This method checks whether linkedlist is empty or not
	 * @return true if empty
	 **/
	boolean isLinkedListEmpty()
	{
		if(head==null && size==0)
			return true;
		else
			return false;
	}
	
	/**
	 * This method compare to generic types and return true if obj1 is greater than second.
	 **/
	public boolean compareTwoValues(T value1, T value2) {
	    return value1.compareTo(value2) > 0;
	}
	
	/**
	 * Custom iterator
	 **/
	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() 
			{	
				LLNode<T> current= null;

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
