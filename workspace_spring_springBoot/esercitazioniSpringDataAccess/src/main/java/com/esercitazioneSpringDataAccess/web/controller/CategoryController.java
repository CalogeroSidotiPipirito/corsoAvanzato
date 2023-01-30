package com.esercitazioneSpringDataAccess.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esercitazioneSpringDataAccess.web.dao.CategoryDao;
import com.esercitazioneSpringDataAccess.web.dao.model.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryDao categoryService;
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {
		
		categoryService.add(new Category(0, "TV_1", "TV_1 test in DB", null));
		
		return "welcome";
		
	}
	
	
	@ResponseBody
	@GetMapping("/get")
	public String get() {
		Category c = categoryService.getCategory(16);
		
		System.out.println(c.getName());
		
		
		return "welcome";
	}
	
}
