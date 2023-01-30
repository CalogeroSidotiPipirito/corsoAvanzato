package com.esercitazioneSpringDataAccess.web;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.esercitazioneSpringDataAccess.web.dao.CategoryDao;
import com.esercitazioneSpringDataAccess.web.dao.CustomerDao;
import com.esercitazioneSpringDataAccess.web.dao.ProductDao;
import com.esercitazioneSpringDataAccess.web.dao.impl.CategoryDaoImpl;
import com.esercitazioneSpringDataAccess.web.dao.impl.CustomerDaoImpl;
import com.esercitazioneSpringDataAccess.web.dao.impl.ProductDaoImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.esercitazioneSpringDataAccess.web.controller")
public class AppConfig {
	
	
	@Bean
	public DataSource getDBconnection() { //create object for the connection to DB through JDBC
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("123456");
		ds.setUrl("jdbc:mariadb://localhost:3306/esercitazionispring");
		
		return ds;
	}
	
	
	@Bean
	public CustomerDao getCustomerService() {
		return new CustomerDaoImpl(getDBconnection());
	}
	
	
	@Bean
	public CategoryDao getCategoryService() {
		return new CategoryDaoImpl(getDBconnection());
	}
	
	
	@Bean
	public ProductDao getProductService() {
		return new ProductDaoImpl(getDBconnection());
	}
	
	
	
	

}
