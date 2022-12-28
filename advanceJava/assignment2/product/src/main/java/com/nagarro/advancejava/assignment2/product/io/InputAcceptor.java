package com.nagarro.advancejava.assignment2.product.io;

import java.util.Scanner;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * InputAcceptor Class : This class helps to take input from the user. 
 * 
 * ***/


public class InputAcceptor {
	public static Scanner sc=new Scanner(System.in);;
	
	public static UserInput enterInput() throws IOException{
		
		String color;
		String size;
		String genderRecom;
		int outputPreference;
		System.out.println("Enter the Tshirt Color: ");
		while((color=InputValidator.validateColor(sc.next()))==null) {
			sc.nextLine();
			continue;
		}
		sc.nextLine();
		
		System.out.println("Enter the Tshirt Size(S,M,L,XL,XXL):");
		while((size=InputValidator.validateSize(sc.next()))==null) {
			sc.nextLine();
			continue;
		}
		sc.nextLine();
		
		System.out.println("Gender Recommedation(F,M,U):");
		while((genderRecom=InputValidator.validateGender(sc.next()))==null) {
			sc.nextLine();
			continue;
		}
		sc.nextLine();
		
		System.out.println("Output Preference: \n 1)Sort By Price\n 2)Sort By Rating \n 3)Sort by Price and Rating:");
		while((outputPreference=InputValidator.validateOutputPreference(sc.nextInt()))==0) {
			
			continue;
		}
		sc.nextLine();
		
		
		return new UserInput(color, size, genderRecom, outputPreference);
		
	} 
	
	public static int userContinueInput()
	{	
		int choice=0;
	    boolean validinput=false;
	
		while(validinput==false) {
			
			try {
				System.out.println("\n\nDo you want to enter again?\n 1)Yes 2)no");
				choice= sc.nextInt();
			
				if(choice==1 || choice==2)
				validinput=true;
				
				else
					System.out.println("Enter valid options");
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input.try again");
				sc.nextLine();
			}
			
		}
		
		return choice;
	}
}
