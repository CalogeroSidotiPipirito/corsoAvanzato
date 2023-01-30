package com.esercitazioneSpringDataAccess.web.dao;

import com.esercitazioneSpringDataAccess.web.dao.model.Category;

public interface CategoryDao {

	public void add(Category c);
	public Category getCategory(int id);
	
}
