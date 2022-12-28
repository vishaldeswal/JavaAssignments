package com.nagarro.services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.model.AdminDetailsModel;
import com.nagarro.model.Products;

/**
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameter("delete"));
		int productID = Integer.parseInt(request.getParameter("delete"));
		Configuration configuration = new Configuration().configure().addAnnotatedClass(AdminDetailsModel.class).addAnnotatedClass(Products.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session deleteSession = sessionFactory.openSession();
		Transaction deleteTransaction = deleteSession.beginTransaction();
		
		Products product = (Products) deleteSession.get(Products.class, productID);
		deleteSession.delete(product);
		
		deleteTransaction.commit();
		deleteSession.close();
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("productManagement.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
