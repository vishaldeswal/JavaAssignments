package com.nagarro.EcommWebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.EcommWebsite.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	

}
