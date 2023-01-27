package com.esercitazione1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esercitazione1.web.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/new")
	public ModelAndView newCustomer() {
		return new ModelAndView("newCustomer", "customerInfo", new Customer());
	}
	
	
/*	@PostMapping("/add")
	public ModelAndView addCustomer(@ModelAttribute("customerInfo") Customer customer) {
		return new ModelAndView("newCustomer","customerInfo", customer);
	} */
	
	@PostMapping("/add")
	public ModelAndView showCustomer(@ModelAttribute("customerInfo") Customer customer) {
		return new ModelAndView("showCustomer", "customerInfo", customer);
	}
	
	
	@GetMapping("/")
	public String welcome(ModelMap model) {
		model.addAttribute("name", "Pippo");
		model.addAttribute("messages", "10");
		
		return "welcomeCustomer";
	}
	
}
