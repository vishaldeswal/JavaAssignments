package com.nagarro.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.encryptor.PasswordEncryptor;
import com.nagarro.model.Librarian;
import com.nagarro.repository.LibrarianRepository;
import com.nagarro.service.LibrarianService;

@Component
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	LibrarianRepository librarianRepository;

	// This method searches for the Librarian is present in database
	public Librarian librarian(Librarian librarian) {

		return librarianRepository.findByUsernameAndPassword(librarian.getUsername(), librarian.getPassword());
	}

	public Librarian register(Librarian librarian) {

		return librarianRepository.save(librarian);
	}

}
