package com.nagarro.EcommWebsite.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.EcommWebsite.entity.SalesReportResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.EcommWebsite.entity.OrderInput;
import com.nagarro.EcommWebsite.service.OrderDetailService;

@RestController
@CrossOrigin(origins="*")
public class OrderDetailsController {
	@Autowired 
	private OrderDetailService orderDetailService;
	
	@PostMapping({"/placeOrder"})
	@PreAuthorize("hasRole('User')")
	public void placeOrder(@RequestBody OrderInput orderInput) {
		
		orderDetailService.placeOrder(orderInput);
		
	}
	
	@GetMapping({"/getSalesReport/{brandName}/{categoryType}/{startDate}/{endDate}"})
	@PreAuthorize("hasRole('Vendor')")
	public ArrayList<ArrayList<String>> getSalesReport(@PathVariable("brandName") String brandName , @PathVariable("categoryType")String categoryType,@PathVariable("startDate")Date startDate ,@PathVariable("endDate")Date endDate) {
		 return orderDetailService.getSalesReport(brandName,categoryType,startDate,endDate);
	}
}
