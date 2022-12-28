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
 * Car Class : Class which stores all the information about the cars like
 * 				carModel
 * 				carType
 * 				insuranceType
 * 				carPrice 
 * 				and have related methods to manipulate and display them. 
 * 
 * ***/

public class Car {
	
	private String carModel;
	private String carType;
	private String insuranceType;
	private long carPrice;
	
	
	Car() //Constructor to initaialize data members with valid values.
	{
		carModel="";
		carType="";
		insuranceType="";
		carPrice = 0l;
	}
	
	public void setCarModel(String model){   // to intialize carModel data member with valid input.
		carModel= model;
	}
	
	public void setCarType(String cartype){	// to intialize carType data member with valid input.
		carType= cartype;
	}
	
	public void setInsuranceType(String iType){	// to intialize insuranceType data member with valid input.
		insuranceType=iType;
	}
	
	public void setCarPrice( long price){  // to intialize carPrice data member with valid input.
		carPrice=price;
	}
	
	public String getCarModel() { //to get the carModel data member value.
		return carModel;
	}
	public String getCarType() {	//to get the carType data member value.
		return carType;
	}
	public String getInsuranceType() { //to get the insuranceType data member value.
		return insuranceType;
	}
	public long getCarPrice() { // to get the carPrice data member value.
		return carPrice;
	}
	
	public void display() // method to display all the information about the car.
	{
		System.out.println("Car model: "+getCarModel());
		System.out.println("Car Type: "+getCarType());
		System.out.println("Car Price: "+getCarPrice());
		System.out.println("Insurance Type: "+getInsuranceType());
	}
}
