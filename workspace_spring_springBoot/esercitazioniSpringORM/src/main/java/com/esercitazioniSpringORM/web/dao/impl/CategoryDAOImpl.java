package com.esercitazioniSpringORM.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.esercitazioniSpringORM.web.dao.CategoryDAO;
import com.esercitazioniSpringORM.web.model.Category;

public class CategoryDAOImpl implements CategoryDAO{
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Category c) {
		
		em.persist(c);
		
	}
	
	
	@Override
	@Transactional
	public void update(Category c) {

		em.merge(c);
	}
	
	
	@Override
	@Transactional
	public void delete(int id) {
		Category category = getByID(id);
		
		em.remove(category);
	}

	@Override
	public Category getByID(int id) {
		
		return em.find(Category.class, id);
		
	}






}
