package com.esercitazioneSpringDataAccess.web.dao.impl;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.esercitazioneSpringDataAccess.web.dao.CategoryDao;
import com.esercitazioneSpringDataAccess.web.dao.model.Category;

public class CategoryDaoImpl implements CategoryDao{

	private JdbcTemplate conn;

	public CategoryDaoImpl(DataSource ds) {
		
		conn = new JdbcTemplate(ds);
	}
	
	@Override
	public void add(Category c) {
		
		String sql = "insert into category(name, description, id_parent_category) values (?,?,?)";
		
		conn.update(sql, c.getName(), c.getDescription(), c.getIdParentCategory());
		
	}

	@Override
	public Category getCategory(int id) {
		
		return conn.queryForObject("select name, description from category where id = ?",
				categoryMapper, "id");
	}
	
	
	//lambda expression for mapping the resultset from DB
	private final org.springframework.jdbc.core.RowMapper<Category> categoryMapper = (resultSet, rowNumb) -> {
		Category categ = new Category();
		categ.setId(resultSet.getInt("id"));
		categ.setName(resultSet.getString("name"));
		categ.setDescription(resultSet.getString("description"));
		
		
		
		return categ;
	};
	
	
	
}
