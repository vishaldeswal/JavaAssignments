package com.nagarro.advancejava.assignment2.product.io;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;

import com.nagarro.advancejava.assignment2.product.database.HibernateUtility;
import com.nagarro.advancejava.assignment2.product.tshirtmodel.Tshirt;

/***
 * Author: Vishal Deswal
 * Email: vishal.deswal@nagarro.com
 * 
 * Description: Read CSV files from java Program and search the required data for user.
 * 
 * UserInput Class : This class mainly stores the user input for the search. 
 * 
 * ***/

public class UserInput {
	String color;
	String size;
	String genderRecom;
	int outputPreference;
	
	public UserInput(String color, String size, String genderRecom, int outputPreference) {
		this.color=color;
		this.size=size;
		this.genderRecom=genderRecom;
		this.outputPreference= outputPreference;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getGenderRecom() {
		return genderRecom;
	}
	
	public int getOuputPreference() {
		return outputPreference;
	}

	@Override
	public String toString() {
		
		return "Color: "+color+" ,Size: "+size+" ,Gender Recommendation: "+genderRecom+" ,Output Preference: "+outputPreference;
	}
	
	public List<Tshirt> findTshirts(){
		
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		
		Criteria crit = session.createCriteria(Tshirt.class);
		Criterion unisexCheck = Restrictions.like("genderRecom", "U",MatchMode.EXACT);
		Criterion givenGenderCheck = Restrictions.like("genderRecom",this.genderRecom ,MatchMode.EXACT);
		LogicalExpression orExp = Restrictions.or(unisexCheck,givenGenderCheck);
		crit.add(orExp);
		crit.add(Restrictions.like("color",this.color,MatchMode.EXACT));
		crit.add(Restrictions.like("size",this.size,MatchMode.EXACT));
		crit.add(Restrictions.eq("availability",true));
		switch(this.getOuputPreference()) {
			case 1:
				crit.addOrder(Order.asc("price"));
				break;
			case 2:
				crit.addOrder(Order.desc("rating"));
				break;
			case 3:
				crit.addOrder(Order.asc("price"));
				crit.addOrder(Order.desc("rating"));
				break;	
		}
		
		List<Tshirt> tshirtSet = crit.list();
		
		return tshirtSet;
		
	}
	
}
