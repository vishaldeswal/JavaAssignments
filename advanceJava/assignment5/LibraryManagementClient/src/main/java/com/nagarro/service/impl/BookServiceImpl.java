package com.nagarro.service.impl;

import java.text.DateFormat;
import java.util.Calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.Constant;
import com.nagarro.model.Book;
import com.nagarro.model.Librarian;
import com.nagarro.service.BookService;

@Component
public class BookServiceImpl implements BookService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public boolean isloginSuccess(Librarian librarian) {
		String url = Constant.LIBRARIAN_API_URL;

		ResponseEntity<Librarian> createResponse = restTemplate.postForEntity(url, librarian, Librarian.class);

		return createResponse.getStatusCodeValue() == 200;
	}
	
	@Override
	public boolean addLibrarian(Librarian librarian) 
	{	String url = Constant.ADD_LIBRARIAN_API_URL;
		ResponseEntity<Librarian> createResponse = restTemplate.postForEntity(url, librarian, Librarian.class);
		return createResponse.getStatusCodeValue() == 200;
	}

	@Override
	public Book[] showBooks() {
		String url = Constant.BOOK_API_URL + "view";
		ResponseEntity<Book[]> responseBookList = restTemplate.getForEntity(url, Book[].class);
		return responseBookList.getBody();
	}

	@Override
	public boolean addBooks(Book book) {
		String url = Constant.BOOK_API_URL + "add";
		ResponseEntity<Book> responseAddBook = restTemplate.postForEntity(url, book, Book.class);
		return responseAddBook.getStatusCodeValue() == 200;
	}

	@Override
	public void Delete(int bookId) {
		String url = Constant.BOOK_API_URL + "delete/" + bookId;
		restTemplate.delete(url);
	}

	@Override
	public String getCurrentDate() {
		DateFormat Date = DateFormat.getDateInstance();
		Calendar calendar = Calendar.getInstance();
		String currentDate = Date.format(calendar.getTime());
		return currentDate;
	}

	@Override
	public Book findById(int bookId) {
		String url = Constant.BOOK_API_URL + "view/" + bookId;
		ResponseEntity<Book> bookResponse = restTemplate.getForEntity(url, Book.class);

		return bookResponse.getBody();
	}

	@Override
	public void upadteBook(Book book) {
		String url = Constant.BOOK_API_URL + "update";

		restTemplate.put(url, book, Book.class);
	}

}
