package com.nagarro.service;

import org.springframework.stereotype.Service;

import com.nagarro.model.Author;

@Service
public interface AuthorService {

	public Author[] showAuthors();
}
