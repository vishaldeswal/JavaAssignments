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
 * CarType Enum : This enum basically stores the all possible Car types and their related information.   
 * 
 * ***/


public enum CarType {
	
	SEDAN(0.08d), SUV(0.1d), HATCHBACK(0.05d);
	
	
	double insuranceCostPercent;
	
	/*Constructor*/
	CarType(double insuranceCost) 
	{
		insuranceCostPercent = insuranceCost;
	}
	
	/*To find the insurance percenctage of car type.*/
	public double getInsurancePercent() 
	{
		return insuranceCostPercent;
	}
	

}
