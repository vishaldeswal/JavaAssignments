package com.nagarro.assignment1;

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
 * InsuranceType Enum : This enum basically stores the all possible Insurance types and their related information.   
 * 
 * ***/

public enum InsuranceType {
	
	BASIC(0.0d), PREMIUM(0.20d);
	
	double premiumPercent;
	
	InsuranceType(double percent)
	{
		premiumPercent= percent;
	}
	
	
	public double getPremiumPercent()
	{
		return premiumPercent;
	}

}
