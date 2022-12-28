package com.nagarro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.model.Book;
import com.nagarro.repository.BookRepository;
import com.nagarro.service.BookService;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	//This method returns list of books present in database
	@Override
	public List<Book> getBookList() {
		return bookRepository.findAll();
	}
	
	//This method save books to database
	@Override
	public void addBook(Book book) {
		if (bookRepository.findById(book.getBookId()).isEmpty()) {
			bookRepository.save(book);
		}
	}

	//This method returns book by particular bookId present in database
	@Override
	public Book findByBookId(int bookId) {
		Optional<Book> optional = bookRepository.findById(bookId);
		return optional.get();
	}
	
	//This method updates book present in database
	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	//This method deletes boos present in database
	@Override
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
}
