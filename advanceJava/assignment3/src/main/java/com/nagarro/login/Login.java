package com.nagarro.login;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.model.AdminDetailsModel;
import com.nagarro.model.Products;
import com.nagarro.services.PasswordEncryptor;

/**
 * This Servlet Verifies the user.
 *
 */
public class Login  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(AdminDetailsModel.class).addAnnotatedClass(Products.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session loginSession = sessionFactory.openSession();
				
		Query<AdminDetailsModel> query = loginSession.createQuery("from AdminDetailsModel where adminUserName = :username and adminPassword = :password",AdminDetailsModel.class);
		query.setParameter("username", request.getParameter("username"));
		String encyptPassword=PasswordEncryptor.encrypt(request.getParameter("password"));
		query.setParameter("password", encyptPassword);
		
		AdminDetailsModel user = (AdminDetailsModel) query.uniqueResult();
		
		loginSession.close();
		
		if(user !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("message", null);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("productManagement.jsp");
			requestDispatcher.forward(request, response);
			}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("message", "*Invalid Details !! Try with another one*");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	
	}
	
}
