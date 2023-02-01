package com.esercitazioniSpringORM.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esercitazioniSpringORM.web.dao.CategoryDAO;
import com.esercitazioniSpringORM.web.model.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryDAO c;
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {

		Category category = new Category();
		
		category.setName("provaNomeCategoria");
		
		c.add(category);
		
		return null;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		Category category = c.getByID(17);
		category.setName("provaUpdateNome");
		
		c.update(category);
		
		return null;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String delete() {
		
		c.delete(16);
		
		return null;
		
	}
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String get() {
		Category category = c.getByID(15);
		
		return category.getName() + " " + category.getDescription() + " " + category.getIdParentCategory();
	}
	
	
}
