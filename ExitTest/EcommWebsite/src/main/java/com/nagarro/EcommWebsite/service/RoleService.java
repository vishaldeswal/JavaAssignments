package com.nagarro.EcommWebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.EcommWebsite.dao.RoleDao;
import com.nagarro.EcommWebsite.entity.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao; 
	
	public Role createNewRole(Role role) {
		 return roleDao.save(role); //return the information that is saved
	}

}
