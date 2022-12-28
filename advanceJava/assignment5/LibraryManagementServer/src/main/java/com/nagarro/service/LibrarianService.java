package com.nagarro.service;

import org.springframework.stereotype.Service;

import com.nagarro.model.Librarian;

@Service
public interface LibrarianService {
	public Librarian librarian(Librarian librarian);
	public Librarian register(Librarian librarian);
	
	
}
