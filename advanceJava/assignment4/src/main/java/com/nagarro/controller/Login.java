package com.nagarro.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagarro.dao.TshirtDao;
import com.nagarro.model.User;

@Controller
@SessionAttributes("username")
public class Login {
	@Autowired(required=true)
	private TshirtDao tshirtDao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	/**
	 * This method checks and verifies that 
	 * the user provinding credentials are valid or not
	 * @param user input given by user
	 * @param model To declare session variable or to store username as object
	 * @return redirection to next page as input given 
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute User user, Model model) {
		System.out.println(user.getUsername());
				
		boolean isUserFound = tshirtDao.checkUser(user);
		
		if(isUserFound) {	
			model.addAttribute("username", user.getUsername());
			return "searchTshirt";
		}else {
			return "error";
		}
			
	}
	
	/**
	 * This method redirects the search button to searchTshirt page
	 * @return returns the redirection to SearchTshirt.jsp page
	 */
	@RequestMapping("search-btn")
	public String searchButton() {
		return "searchTshirt";
	}
	
	/**
	 * This method redirects the logout button to login page
	 * @return returns the redirection to index.jsp page
	 */
	@RequestMapping("logout-btn")
	public String logoutButton() {
		return "index";
	}
}
