package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	/**
	 * This method can be called to save author to database
	 * @param author data of author
	 */
	@PostMapping("/add")
	public void saveAuthor(Author author) {
		authorService.addAuthor(author);
	}

	/**
	 * This method can be called to update author to database
	 * @param author data of author
	 */
	@PutMapping("/update")
	public void updateAuthor(Author author) {
		authorService.updateAuthor(author);
	}

	/**
	 * This method can be called to delete author to database
	 * @param authorId authorId of author
	 */
	@DeleteMapping("/delete/{authorId}")
	public void deleteAuthor(@PathVariable int authorId) {
		Author author = authorService.findByAuthorId(authorId);
		authorService.deleteAuthor(author);
	}

	/**
	 * This method can be called to get list of author present in database
	 * @return author
	 */
	@GetMapping("/view")
	public List<Author> authorList() {
		return authorService.getAuthorList();
	}

	/**
	 * 
	 * @param authorId authorId authorId of author
	 * @return author
	 */
	@GetMapping("view/{authorId}")
	public Author authorById(@PathVariable("authorId") int authorId) {
		return authorService.findByAuthorId(authorId);
	}

}
