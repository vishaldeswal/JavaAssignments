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
 * PremiumCalculator Class : Class which has getCarPremium() method to calculate the insurance cost on the basis of carModel, cartype and insurance type. 
 * 
 * ***/


public class PremiumCalculator {
	
	/*Calculate the total insurance cost*/
	static double getCarPremium(Car newCar) 
	{
		double insuranceCost=0;
		double premiumCost=0;
			
			/*Checking the carType and calculating cost according to that*/
			
			if(newCar.getCarType().equalsIgnoreCase("Hatchbach")) 
			{
				insuranceCost=CarType.HATCHBACK.getInsurancePercent() * newCar.getCarPrice();
			}
			else if(newCar.getCarType().equalsIgnoreCase("Sedan"))
			{
				insuranceCost=CarType.SEDAN.getInsurancePercent() * newCar.getCarPrice();
			}
			
			else
			{
				insuranceCost=CarType.SUV.getInsurancePercent() * newCar.getCarPrice();
			}
			
			
			/*Checking the insuranceType and calculating cost according to that */
			
			if(newCar.getInsuranceType().equalsIgnoreCase("Premium")) 
			{
				premiumCost= InsuranceType.PREMIUM.getPremiumPercent() * insuranceCost;
			}
			
			else
			{
				premiumCost=InsuranceType.BASIC.getPremiumPercent() * insuranceCost;;
			}
			
			return insuranceCost+premiumCost;
	}
	

}
