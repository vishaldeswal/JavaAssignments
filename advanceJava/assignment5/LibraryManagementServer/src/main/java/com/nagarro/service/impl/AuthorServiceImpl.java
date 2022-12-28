package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.model.Author;
import com.nagarro.repository.AuthorRepository;
import com.nagarro.service.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	//This method returns list of authors present in database
	@Override
	public List<Author> getAuthorList() {
		return authorRepository.findAll();
	}

	//This method adds author to database
	@Override
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public Author findByAuthorId(int authorId) {
		return authorRepository.findByAuthorId(authorId);
	}

	//This method updates author present in database
	@Override
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}

	//This method deletes author present in database
	@Override
	public void deleteAuthor(Author author) {
		authorRepository.delete(author);
	}

}
