package com.nagarro.EcommWebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.EcommWebsite.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {
	
	

}
