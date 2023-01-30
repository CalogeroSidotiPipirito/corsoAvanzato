package com.esercitazioneSpringDataAccess.web.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.esercitazioneSpringDataAccess.web.dao.CustomerDao;
import com.esercitazioneSpringDataAccess.web.dao.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	private JdbcTemplate conn;

	public CustomerDaoImpl(DataSource ds) {
		
		conn = new JdbcTemplate(ds);
	}

	@Override
	public void add(Customer c) {
		
		String sql = "insert into customer(name, surname, tax_code, email, username, password) values(?,?,?,?,?,?)";
		
		conn.update(sql, c.getName(), c.getSurname(), c.getCf(), c.getEmail(), c.getUsername(), c.getPassword());
		
	}
	
	
	
	
	
}