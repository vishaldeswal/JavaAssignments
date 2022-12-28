package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookService bookService;

	/**
	 * This method can be called to save book to database
	 * @param book data of book
	 * @return data of book saved
	 */
	@PostMapping("/add")
	public Book saveBook(@RequestBody Book book) {
		bookService.addBook(book);
		return book;
	}

	/**
	 * This method can be called to update book to database 
	 * @param book data to be updated
	 */
	@PutMapping("/update")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}

	/**
	 * This method can be called to delete book from database
	 * @param bookId bookId of book
	 */
	@DeleteMapping("/delete/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		Book book = bookService.findByBookId(bookId);
		bookService.deleteBook(book);
	}

	/**
	 * This method can be called to get list of books from database
	 * @return list of books
	 */
	@GetMapping("/view")
	public List<Book> bookList() {
		return bookService.getBookList();
	}

	/**
	 * This method can be called to get a book by bookId
	 * @param bookId bookId of book
	 * @return
	 */
	@GetMapping("view/{bookId}")
	public Book bookById(@PathVariable("bookId") int bookId) {
		return bookService.findByBookId(bookId);
	}
}
