package com.nagarro.service;

import org.springframework.stereotype.Service;

import com.nagarro.model.Book;
import com.nagarro.model.Librarian;

@Service
public interface BookService {
	
		
	public boolean isloginSuccess(Librarian librarian); 
	
	public boolean addLibrarian(Librarian librarian);
	
	public Book[] showBooks();

	public boolean addBooks(Book book);

	public String getCurrentDate();

	public void Delete(int bookId);

	public Book findById(int bookId);

	public void upadteBook(Book book);
}
