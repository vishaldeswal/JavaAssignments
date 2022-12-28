package com.nagarro.EcommWebsite.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.EcommWebsite.configuration.JwtRequestFilter;
import com.nagarro.EcommWebsite.dao.ProductDao;
import com.nagarro.EcommWebsite.dao.UserDao;
import com.nagarro.EcommWebsite.entity.Product;
import com.nagarro.EcommWebsite.entity.Role;
import com.nagarro.EcommWebsite.entity.User;
@Service

public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	
	public Product addNewProduct(Product product, String vendorUserName) {
		
		User vendor=userDao.findById(vendorUserName).get();
		product.setVendor(vendor);
		return productDao.save(product);
	}
	
	public List<Product> getAllProducts(){
		return (List<Product>)productDao.findAll();
	}
	
	public List<Product> getVendorProducts(){
		return (List<Product>)productDao.findProductByVendorName(JwtRequestFilter.CURRENT_USER);
	}
	
	public String deleteProductDetails(Integer productId) {
		try {
		productDao.deleteById(productId);
		}
		catch(Exception e) {
			return "Delete operation cannot be executed on this product as order have been placed for this product. ";
		}
		return "";
	}
	
	public Product getProductDeatilsById(Integer productId) {
		return productDao.findById(productId).get();
	}
	
	public List<Product>  getProductDetails(boolean isSingleProductCheckout, Integer productId) {
		
		if(isSingleProductCheckout) {
			
			List<Product> list = new ArrayList<>();
			Product product= productDao.findById(productId).get();
			list.add(product);
			return list;
		}
		else {
			
		}
		return new ArrayList<>();
	}
	
public List<String> getBrandName(){
		return productDao.getBrandName();
	}

public List<String> getCategoryName(){
	return productDao.getCategoryName();
}

}
