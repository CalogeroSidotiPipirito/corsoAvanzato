package com.esercitazioniSpringORM.web.dao;

import com.esercitazioniSpringORM.web.model.Category;

public interface CategoryDAO {
	
	public void add(Category c);
	
	public void update(Category c);
	
	public void delete(int id);
	
	public Category getByID(int id);
	
	

}
