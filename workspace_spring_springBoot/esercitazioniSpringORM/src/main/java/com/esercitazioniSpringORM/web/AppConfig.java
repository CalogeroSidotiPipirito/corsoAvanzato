package com.esercitazioniSpringORM.web;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.esercitazioniSpringORM.web.dao.CategoryDAO;
import com.esercitazioniSpringORM.web.dao.impl.CategoryDAOImpl;



@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.esercitazioniSpringORM.web.controller")
@EnableTransactionManagement
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
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDBconnection());
		emf.setJpaVendorAdapter(va);
		emf.setPackagesToScan(getClass().getPackage().getName());
		
		return emf;
	}
	
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		
		JpaTransactionManager jtm = new JpaTransactionManager(getEntityManager().getObject());
		
		return jtm;
		
	}
	
	
	@Bean
	public CategoryDAO getCategoryService() {
		return new CategoryDAOImpl();
	}
	
	
/*	@Bean
	public CustomerDao getCustomerService() {
		return new CustomerDaoImpl(getDBconnection());
	}
	
	
	
	
	@Bean
	public ProductDao getProductService() {
		return new ProductDaoImpl(getDBconnection());
	}
	
	*/
	
	

}
