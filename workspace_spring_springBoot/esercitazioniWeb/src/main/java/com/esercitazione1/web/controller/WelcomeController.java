package com.esercitazione1.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@ResponseBody
	@RequestMapping("/")
	public String welcome() {
		return "Benvenuto!";
	}
	
	@ResponseBody
	@RequestMapping(path = {"/v1", "/v2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String versions() {
		return "Stampa di versions()!";
	}
	
	@ResponseBody
	@GetMapping("/saluto")
	public String saluto(HttpServletRequest request) {
		return "Ciao " + request.getParameter("name");
	}
	
	
	@GetMapping("/testView")
	public String testView() {
		return "test";
	}
	
}
