package com.nagarro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.constant.Constant;

import com.nagarro.model.Tshirt;
import com.nagarro.model.User;

@Component
public class TshirtDao {
	
	@Autowired(required=true)
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * Checks whether the credentials are correct or not
	 * @param user The details given by user
	 * @return returns true if the credentials match database
	 */
	@Transactional
	public boolean checkUser(User user) {
	
		User queryValue = hibernateTemplate.get(User.class, user.getUsername());
		try {
			if(queryValue.getPassword().equals(user.getPassword()) ) {
				return true;
			}
			else {
				return false;
			}
			}catch(Exception exception) {
				return false;
			}
		}
		

	/**
	 * This method searches the data from the data according to the input provided
	 * @param input the input provided by the user
	 * @return list of the object of Tshirt model
	 */
	public List<Tshirt> search(Tshirt input){
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tshirt.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session searchSession = sessionFactory.openSession();
		Transaction searchTransaction = searchSession.beginTransaction();
		Query<Tshirt> query ;
		List<Tshirt> result;
				if (input.getOutputPreference().equalsIgnoreCase(Constant.SORT_BY_RATING)) {
					query = searchSession.createQuery(Constant.SEARCH_QUERY+"order by rating DESC",Tshirt.class);
				} else if (input.getOutputPreference().equalsIgnoreCase(Constant.SORT_BY_PRICE)) {
					query = searchSession.createQuery(Constant.SEARCH_QUERY+"order by price",Tshirt.class);
				} else {
					query = searchSession.createQuery(Constant.SEARCH_QUERY+"order by rating DESC,price",Tshirt.class);
				}
				query.setParameter("color", input.getColor());
				query.setParameter("size", input.getSize());
				query.setParameter("gender", input.getGenderRecommendation());
				query.setParameter("universal", Constant.UNIVERSAL_GENDER);
				result = query.list();
				
				searchTransaction.commit();
				searchSession.close();
				
		return result;
	}
	
}
