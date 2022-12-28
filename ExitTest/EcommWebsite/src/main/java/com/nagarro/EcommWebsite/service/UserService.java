package com.nagarro.EcommWebsite.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.EcommWebsite.dao.RoleDao;
import com.nagarro.EcommWebsite.dao.UserDao;
import com.nagarro.EcommWebsite.entity.Role;
import com.nagarro.EcommWebsite.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerNewUser(User user) {
		
		Role role=roleDao.findById("User").get();
		Set<Role> roles= new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userDao.save(user);

	}
	
public User registerNewVendor(User user) {
		
		Role role=roleDao.findById("Vendor").get();
		Set<Role> roles= new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userDao.save(user);

	}

	
	public void initRolesAndUsers() {
		Role adminRole = new Role();
		
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);
		
		Role userRole = new Role();
		
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created user.");
		roleDao.save(userRole);
		

		Role vendorRole = new Role();
		
		vendorRole.setRoleName("Vendor");
		vendorRole.setRoleDescription("Seller role");
		roleDao.save(vendorRole);
		
		//Adding one admin user
		User adminUser= new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin@123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		
		Set<Role> adminRoles= new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		
		
	}
	
	public String getEncodedPassword(String password) {
		return  passwordEncoder.encode(password);
	}
}
