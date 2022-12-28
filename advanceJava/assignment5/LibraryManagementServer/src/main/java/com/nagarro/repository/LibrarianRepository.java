package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, String> {

	@Query("from Librarian where username= ?1 and password=?2")
	public Librarian findByUsernameAndPassword(String username,String password );
	
	
		
		
	
}
