package com.nagarro.assignment1;

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
 * Application Class : This is main class where all functions are called and output is shown based on that.
 * 
 * ***/

public class Application {
	
	
	
	public static void main(String args[])
	{
		Functions call= new Functions(); //create object of Functions class
		boolean choice=false;            // choice of user to re-continue the program. 
		
		do {
			
		
		Car newCar= new Car();				// create object of Car class
		
		
		call.inputCarModel(newCar);			//To take car model input from user.
		
		if(!call.inputCarType(newCar))      //To take car type input from user and check the status of operation afterwards.
		{
			System.out.println("END: Tries for entering car type are over!!");
			System.out.println("Restart to use again");
			System.exit(0);
		}
		
		if(!call.inputCarPrice(newCar))		//To take car price input from user and check the status of operation afterwards.
		{
			System.out.println("END: tries for entering car price over !!");
			System.out.println("Restart to use again");
			System.exit(0);
		}
		
		if(!call.inputInsuranceType(newCar)) //To take insurance type input from user and check the status of operation afterwards.
		{
			System.out.println("END: Tries for entering insurance type are over!!");
			System.out.println("Restart to use again");
			System.exit(0);
		}
		
		
		newCar.display();			// display all the information of current car.
		System.out.println("(*)Insurance Cost: "+ PremiumCalculator.getCarPremium(newCar)); //display the calculated insurance cost of current car.
		
		
		System.out.println("\n\nCheck another car insurance?\n 1)YES\n 2)NO"); // to check the insurance price of more than one car.
		
		int tries=2;
		
			
			while(tries>0)
			{	try {
						tries--;
						System.out.println("Your choice: ");
						int ch=Functions.sc.nextInt();
						switch(ch)
						{ case 1:
							choice=true;
							tries=0;
							break;
				  		  case 2:
							choice=false;
							tries=0;
							break;
				  		  default:
					  		System.out.println("ERROR:- Invalid Input(other than 1 or 2).Try again.");
				  
						}	  
		
		     		}catch(Exception e){
						System.out.println("\n***WARNING:-Enter the valid input type(1 0r 2)");
						Functions.sc.nextLine();
						}
		
			}
		
		}while(choice==true);
		
	}

}
