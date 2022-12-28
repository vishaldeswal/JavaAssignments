package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public Author findByAuthorId(int authorId);

}
