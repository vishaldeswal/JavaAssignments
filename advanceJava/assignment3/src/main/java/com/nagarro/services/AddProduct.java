package com.nagarro.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.constant.Constant;
import com.nagarro.model.AdminDetailsModel;
import com.nagarro.model.Products;

/**
 * This Servlet Takes input from ProductManagement.jsp and adds to database
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 1, // 1 MB
maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class AddProduct extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Products.class)
				.addAnnotatedClass(AdminDetailsModel.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		HttpSession session = request.getSession();
		AdminDetailsModel user = (AdminDetailsModel) session.getAttribute("user");

		Part file = request.getPart("image");
		String imageFileName = file.getSubmittedFileName();
		String uploadPath = Constant.UPLOAD_PATH + imageFileName;

		try {

			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		FileInputStream fileinput = new FileInputStream(Constant.UPLOAD_PATH + imageFileName);
		byte[] data = new byte[fileinput.available()];
		fileinput.read(data);

		Products product = new Products();
		product.setProductTitle(request.getParameter("title"));
		product.setProductQuantity(request.getParameter("quantity"));
		product.setProductSize(request.getParameter("size"));
		product.setProductImage(data);
		product.setUser(user);

		Session addDetailsSession = sessionFactory.openSession();
		Transaction addDetailsTransaction = addDetailsSession.beginTransaction();

		addDetailsSession.save(product);

		addDetailsTransaction.commit();
		addDetailsSession.close();
		
		request.getRequestDispatcher("productManagement.jsp").forward(request, response);

	}

}
