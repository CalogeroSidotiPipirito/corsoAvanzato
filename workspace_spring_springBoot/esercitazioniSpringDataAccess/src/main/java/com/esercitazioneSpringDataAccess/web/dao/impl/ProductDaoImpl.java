package com.esercitazioneSpringDataAccess.web.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.esercitazioneSpringDataAccess.web.dao.ProductDao;
import com.esercitazioneSpringDataAccess.web.dao.model.Product;

public class ProductDaoImpl implements ProductDao{
	
	private JdbcTemplate conn;

	public ProductDaoImpl(DataSource ds) {
		conn = new JdbcTemplate(ds);
	}

	@Override
	public void add(Product p) {

		String sql = "insert into product(name, id_category, description, unit_price, units_measure) values (?,?,?,?,?)";
		
		conn.update(sql, p.getName(), p.getIdCategory(), p.getDescription(), p.getUnitPrice(), p.getUnitsMeasure());
	}	
	
	

}
