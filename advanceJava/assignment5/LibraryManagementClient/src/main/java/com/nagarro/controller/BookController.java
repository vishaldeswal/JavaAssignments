package com.nagarro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.nagarro.model.Author;
import com.nagarro.model.Book;
import com.nagarro.model.Librarian;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;

@Controller
@SessionAttributes("username")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	Author author;
	
	@Autowired
	Book book;
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	/**
	 * This method checks whether the details of librarian are correct or not
	 * @param librarian data of librarian
	 * @param model Object of Model class
	 * @return redirection to next page
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute Librarian librarian, Model model) {
		boolean isCredentialTrue = bookService.isloginSuccess(librarian);
		if(isCredentialTrue) {
			model.addAttribute("username",librarian.getUsername());
			return "redirect:/bookDetails";
		}else {
			return "login";
		}
	}
	
	@GetMapping("/register")
	public String register() {
		return "Registration";
	}
	
	@PostMapping("/addLibrarian")
	public String addLibrarian(@ModelAttribute Librarian librarian) {
		
		bookService.addLibrarian(librarian);
		
		return "login";
		
	}
	
	/**
	 * This method add book to database
	 * @param bookId bookId of book
	 * @param bookName book name of book
	 * @param authorId authorId of author
	 * @return redirection to next page
	 */
	@PostMapping("/addBook")
	public String addBook(@RequestParam("bookId") int bookId, @RequestParam("bookName") String bookName,
			@RequestParam("author") int authorId) {
		
		author.setAuthorId(authorId);
		book.setAuthor(author);
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setDate(bookService.getCurrentDate());
		bookService.addBooks(book);
				
		return "redirect:/bookDetails";
	}
	
	
	/**
	 * This method deletes book from database
	 * @param bookId bookId of book to be deleted
	 * @return redirection to next page
	 */
	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("delete") int bookId) {
		bookService.Delete(bookId);
		
		return "redirect:/bookDetails";
	}
	
	/**
	 * This method updates book in database
	 * @param bookId bookId of book
	 * @param bookName bookName of book
	 * @param authorId authorId of book
	 * @return redirection to next page
	 */
	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("bookId") int bookId,@RequestParam("bookName") String bookName,
			@RequestParam("author") int authorId) {
		author.setAuthorId(authorId);
		book.setAuthor(author);
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setDate(bookService.getCurrentDate());
		bookService.upadteBook(book);
		
		return "redirect:/bookDetails";
	}
	
	/**
	 * This method redirects to showBooks.jsp
	 * @param model model Object of Model Class
	 * @return redirection to next page
	 */
	@RequestMapping("/bookDetails")
	public String redirectToShowPage(Model model) {
		Book[] book = bookService.showBooks();
		model.addAttribute("book", book);
		return "showBooks";
	}
	
	/**
	 * This method redirects to addBook.jsp
	 * @param model model Object of Model Class
	 * @return redirection to next page
	 */
	@RequestMapping("/addBookPage")
	public String addBookBtn(Model model) {
		Author[] author = authorService.showAuthors();
		model.addAttribute("author", author);
		Book[] book = bookService.showBooks();
		model.addAttribute("book", book);
		
		return "addBook";
	}
	
	/**
	 * This method redirects to editPage.jsp
	 * @param bookId bookId of book
	 * @param model Object of Model Class
	 * @return redirection to next page
	 */
	@RequestMapping("/editBookPage")
	public String editBookBtn(@RequestParam("edit") int bookId, Model model) {
		Book book = bookService.findById(bookId);
		Author[] author = authorService.showAuthors();
		model.addAttribute("author", author);
		model.addAttribute("book", book);
		return "editBook";
	}
	
	/**
	 * This method is called to logout
	 * @param httpsession HttpSession variable
	 * @param status SessionStatus variable
	 * @return redirection to next page
	 */
	@RequestMapping("/logout-btn")
	public String logout(HttpSession httpsession, SessionStatus status) {
		status.setComplete();
		httpsession.invalidate();
		
		return "login";
	}
	
	

}
