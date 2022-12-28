package com.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.Constant;
import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService{
	
	RestTemplate restTemplate = new RestTemplate();
	
	public Author[] showAuthors(){
		String url = Constant.AUTHOR_API_URL+"view";
		ResponseEntity<Author[]> responseBookList = restTemplate.getForEntity(url, Author[].class); 
		return responseBookList.getBody();
	}
}
