package com.nagarro.EcommWebsite.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.EcommWebsite.configuration.JwtRequestFilter;
import com.nagarro.EcommWebsite.dao.OrderDetailDao;
import com.nagarro.EcommWebsite.dao.ProductDao;
import com.nagarro.EcommWebsite.dao.UserDao;

import com.nagarro.EcommWebsite.entity.OrderDetail;
import com.nagarro.EcommWebsite.entity.OrderInput;
import com.nagarro.EcommWebsite.entity.OrderProductQuantity;
import com.nagarro.EcommWebsite.entity.Product;
import com.nagarro.EcommWebsite.entity.SalesReportResult;
import com.nagarro.EcommWebsite.entity.User;



@Service
public class OrderDetailService {
	
	private static  final String ORDER_PLACED="placeOrder";

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserDao userDao;
	
	public void placeOrder(OrderInput orderInput) {
		
		List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();
		
		for (OrderProductQuantity o: productQuantityList){
			Product product =productDao.findById(o.getProductId()).get();

			String currentUser=JwtRequestFilter.CURRENT_USER;
			User user= userDao.findById(currentUser).get();

			OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderFullName(orderInput.getFullName());
				orderDetail.setOrderFullAddress(orderInput.getFullAddress());
				orderDetail.setOrderContactNumber(orderInput.getContactNumber());
				orderDetail.setOrderAlternateContactNumber(orderInput.getAlternateContactNumber());
				orderDetail.setOrderStatus(ORDER_PLACED);
				if(product.getStockQuantity()-o.getQuantity()>=0) {
					product.setStockQuantity(product.getStockQuantity()-o.getQuantity());
				}
				
				orderDetail.setOrderAmount(product.getProductDicountedPrice()*o.getQuantity());
				orderDetail.setProduct(product);
				orderDetail.setUser(user);
				
			productDao.save(product);
			orderDetailDao.save(orderDetail);
		}
		
		}

	public ArrayList<ArrayList<String>> getSalesReport(String brandName, String categoryType, Date startDate, Date endDate) {
		return orderDetailDao.getSalesReport(brandName, categoryType, startDate, endDate, JwtRequestFilter.CURRENT_USER);
		
		
		
			
		}
		
		 
		
				
		 
		
	

}
