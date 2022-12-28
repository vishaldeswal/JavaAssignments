package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.dao.TshirtDao;
import com.nagarro.model.Tshirt;

@Controller
public class SearchTshirt {
	
	@Autowired
	private TshirtDao tshirtDao;
	
	/**
	 * Checks for Tshirt available according to user input
	 * @param tshirt Input provided by user
	 * @param model Model to add attributes so that the values can be forwarded to jsp page 
	 * @return redirects to showTshirt.jsp page
	 */
	@RequestMapping(value="searchTshirt",method=RequestMethod.POST)
	public String searchTshirt(@ModelAttribute Tshirt tshirt, Model model) {
		
		try {
			ReadCSVFiles.readCSVFiles();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		List<Tshirt> product = tshirtDao.search(tshirt);

		model.addAttribute("product", product);
		return "showTshirt";
	}
}
