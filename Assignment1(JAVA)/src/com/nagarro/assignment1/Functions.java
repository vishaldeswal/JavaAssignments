package com.nagarro.assignment1;

import java.util.Scanner;
import com.nagarro.assignment1.*;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Car Type can have 3 possible values Hatchback, Sedan and SUV and insurance premium calculation rules for 3 types are as follows:

				Hatchback: 5% of Car cost price
				Sedan: 8% of Car cost price
				SUV: 10% of Car cost price

				Insurance Type can have 2 possible values Basic and Premium. 
				If Insurance Type entered is Premium, increase the premium value 
				by 20% of the value calculated from car type.
 * 
 * Functions Class : 
 * 
 * ***/

public class Functions {
	
	public static final  Scanner sc= new Scanner(System.in);
	
	/*Takes user input and intialize newCar.carModel of class "Car". */
	public void inputCarModel( Car newCar) {  
		String carModel;
		
		System.out.println("Enter the car model:");
		
		carModel= sc.nextLine();
		
		
		
		newCar.setCarModel(carModel);
		
		}
	
	
	/*Takes user input and intialize newCar.carType of class "Car" 
	 * if it happens succesfully return true otherwise false. */
	
	public boolean inputCarType( Car newCar) { 
		
		int tries=2;			//tries to enter car type, if entered the incorrect input. 
		boolean successCall=false;
		
		System.out.println("Choose Car type(1,2,3):\n 1)Hatchback\n 2)Sedan\n 3)SUV");
		int choice;
		
		
		while(tries > 0)
		{	tries--;
			System.out.println("Your Choice:");
			try {					// exception handling if user input any non-numeric value.
				choice= sc.nextInt();
			
				switch(choice)
				{ case 1:
					newCar.setCarType("Hatchback");
					successCall=true;
					tries=0;
					break;
				
				  case 2:
					  newCar.setCarType("Sedan");
					  successCall=true;
					  tries=0;
					  break;
				
				  case 3:
					  newCar.setCarType("SUV");
					  successCall=true;
					  tries=0;
					  break;	
				
				  default:
					  System.out.println("ERROR: Wrong input.Try again");
					  successCall=false;
					  
				
			
				}
		      }catch(Exception E)
			 {
			System.out.println("\n***WARNING:-Enter the valid input type");
			sc.nextLine();
			successCall=false;
			}
			
		}
		return successCall;		// returning the status of operation happened in function.
		}
	
	
	/*Takes user input and intialize newCar.InsuranceType of class "Car" 
	 * if it happens succesfully return true otherwise false.*/
	public boolean inputInsuranceType( Car newCar) {  
		
		int tries=2;				//tries to enter insurance type, if entered the incorrect input. 
		boolean successCall=false;
		
		System.out.println("\nChoose Insurance type(1,2,3):\n 1)Basic\n 2)Premium\n");
		int choice;
		
		
		while(tries > 0)
		{	tries--;
			System.out.println("Your Choice:");
			choice= sc.nextInt();
		try {				// exception handling if user input any non-numeric value.		
			switch(choice)
			{ case 1:
				newCar.setInsuranceType("Basic");
				successCall=true;
				tries=0;
				break;
				
			case 2:
				newCar.setInsuranceType("Premium");
				successCall=true;
				tries=0;
				break;
			
				
			default:
				System.out.println("ERROR: Wrong input.Try again");
				successCall=false;
				
				
			
			}
		}
		catch(Exception e)
			{
			System.out.println("\n***WARNING:-Enter the valid input type");
			sc.nextLine();
			successCall=false;
			}
		}
		return successCall;				// returning the status of operation happened in function.
		}
	
	
	/*Takes user input and intialize newCar.carPrice of class "Car" if it happens succesfully return true otherwise false.*/
	public boolean inputCarPrice( Car newCar) { 
		long carPrice=0l;
		boolean successCall=false;
		try {
		
		System.out.println("Enter the car price:");
		carPrice= sc.nextLong();
		successCall=true;

		
		
		}
		catch(Exception e)
		{successCall=false;
		System.out.println("\n***WARNING:-Enter the valid input type");
		sc.nextLine();
		}
		
		
		newCar.setCarPrice(carPrice);
		return successCall;
		}
	

}
