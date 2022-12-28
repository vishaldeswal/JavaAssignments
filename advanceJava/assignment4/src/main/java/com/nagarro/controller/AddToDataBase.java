package com.nagarro.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Controller;
import com.nagarro.model.Tshirt;

@Controller
public class AddToDataBase {
	/**
	 * Adding The data from tshirt object to database
	 * @param tshirt Contains data from readCSVFiles()
	 */
	public void addToDataBase(List<Tshirt> tshirt) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tshirt.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session insertSession = sessionFactory.openSession();
		Transaction insertTransaction = insertSession.beginTransaction();
		
		for(Tshirt data: tshirt) {
			insertSession.saveOrUpdate(data);
		}
		
		insertTransaction.commit();
		insertSession.close();
	}
}
