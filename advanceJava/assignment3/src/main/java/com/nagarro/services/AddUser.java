package com.nagarro.services;

import java.io.IOException;
import org.hibernate.exception.ConstraintViolationException;
import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import com.nagarro.model.AdminDetailsModel;
import com.nagarro.model.Products;

public class AddUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(AdminDetailsModel.class)
				.addAnnotatedClass(Products.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		AdminDetailsModel newUser = new AdminDetailsModel();
		newUser.setAdminUserName(request.getParameter("username"));

		String encryptedPass = PasswordEncryptor.encrypt(request.getParameter("password"));

		try {
			if (encryptedPass != null) {
				newUser.setAdminPassword(encryptedPass);

				Session RegisterSession = sessionFactory.openSession();
				Transaction registerTransaction = RegisterSession.beginTransaction();

				RegisterSession.save(newUser);

				registerTransaction.commit();
				RegisterSession.close();

				HttpSession session = request.getSession();
				session.setAttribute("message", "User Successfully Added");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				try {
					requestDispatcher.forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else {
				HttpSession session = request.getSession();
				session.setAttribute("message", "User not added due to some problem.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				try {
					requestDispatcher.forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ConstraintViolationException e) {
			HttpSession session = request.getSession();
			session.setAttribute("message", "Username already Taken.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.jsp");
			try {
				requestDispatcher.forward(request, response);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (PersistenceException e) {
			HttpSession session = request.getSession();
			session.setAttribute("message", "Username already Taken.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.jsp");
			try {
				requestDispatcher.forward(request, response);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
