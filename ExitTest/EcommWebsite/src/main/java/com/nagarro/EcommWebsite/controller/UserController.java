package com.nagarro.EcommWebsite.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.EcommWebsite.entity.User;
import com.nagarro.EcommWebsite.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUsers();
	}
	
	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {

		return userService.registerNewUser(user);
	}
	
	@PostMapping({ "/registerNewVendor" })
	public User registerNewVendor(@RequestBody User user) {

		return userService.registerNewVendor(user);
	}
	
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accesible to admin.";
	}
	
	@GetMapping({"/forVendor"})
	@PreAuthorize("hasRole('Vendor')")
	public String forVendor() {
		return "This URL is only accesible to vendor.";
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only accesible to default user.";
	}
}
