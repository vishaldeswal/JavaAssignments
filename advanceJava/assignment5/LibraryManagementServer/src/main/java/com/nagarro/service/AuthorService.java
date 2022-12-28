package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.model.Author;

@Service
public interface AuthorService {

	public List<Author> getAuthorList();

	public void addAuthor(Author author);

	public Author findByAuthorId(int authorId);

	public void updateAuthor(Author author);

	public void deleteAuthor(Author author);

}
