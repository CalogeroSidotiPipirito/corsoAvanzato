package com.esercitazione1.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class WelcomeRestController {

	
	@RequestMapping("/welcome")
	public String welcome() {
		return "{message: \"welcome\"}";
	}
	
}
