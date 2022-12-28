package com.nagarro.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.query.Query;
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
 * Servlet implementation class EditData Takes input from editPage.jsp and
 * Updates in the database
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 1, // 1 MB
		maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class EditData extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(AdminDetailsModel.class)
				.addAnnotatedClass(Products.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		HttpSession session = request.getSession();
		AdminDetailsModel user = (AdminDetailsModel) session.getAttribute("user");
		int productID = Integer.parseInt((String) session.getAttribute("productID"));

		Session hiberanteSession = sessionFactory.openSession();
		Query<Products> query = hiberanteSession.createQuery("from Products where user_adminUserName = :username and productID = :productid",Products.class);
		query.setParameter("username", user.getAdminUserName());
		query.setParameter("productid",productID);
		Products editedProduct = (Products) query.uniqueResult();
		hiberanteSession.close();
		
		
		
		Part file = request.getPart("editedimage");
		String imageFileName = file.getSubmittedFileName();
		String uploadPath = null;
		byte[] data = null;
		if(!imageFileName.equals("")) {
			uploadPath = Constant.UPLOAD_PATH + imageFileName;

			try {

				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = file.getInputStream();

				data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();

			}

			catch (Exception e) {
				e.printStackTrace();
			}

			FileInputStream fileinput = new FileInputStream(Constant.UPLOAD_PATH + imageFileName);
			data = new byte[fileinput.available()];
			fileinput.read(data);
		}
		Session editSession = sessionFactory.openSession();
		Transaction editTransaction = editSession.beginTransaction();

		Products product = new Products();
		product.setProductID(productID);

		String newTitle = request.getParameter("editedtitle");
		if (!newTitle.equals(""))
			product.setProductTitle(newTitle);
		else
			product.setProductTitle(editedProduct.getProductTitle());
		

		String newQuantity = request.getParameter("editedquantity");
		if (!newQuantity.equals(""))
			product.setProductQuantity(newQuantity);
		else
			product.setProductQuantity(editedProduct.getProductQuantity());

		String newSize = request.getParameter("editedsize");
		if (!newSize.equals(""))
			product.setProductSize(newSize);
		else
			product.setProductSize(editedProduct.getProductSize());

		if (!imageFileName.equals(""))
			product.setProductImage(data);
		else
			product.setProductImage(editedProduct.getProductImage());
		
		product.setUser(user);
		editSession.saveOrUpdate(product);

		editTransaction.commit();
		editSession.close();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("productManagement.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
