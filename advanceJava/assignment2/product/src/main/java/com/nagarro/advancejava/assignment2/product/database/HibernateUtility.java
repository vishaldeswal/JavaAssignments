package com.nagarro.advancejava.assignment2.product.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/***
* Author: Vishal Deswal
* Email: vishal.deswal@nagarro.com
* 
* Description: Read CSV files from java Program and search the required data for user.
* 
* HibernateUtility Class : This is a singleton class which is used to make session of hibernate .
* 
* ***/
public class HibernateUtility {

	public static SessionFactory factory;
	
	private HibernateUtility() {
		
	}
	
	public static synchronized SessionFactory getSessionFactory() {
		if(factory==null) {
			factory= new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
			
		}
		
		return factory;
	}
	
	
}
