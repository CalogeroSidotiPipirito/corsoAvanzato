package com.esercitazioneSpringDataAccess.web.dao.model;

public class Customer {

	private int id;
	private String name;
	private String surname;
	private String cf;
	private String email;
	private String username;
	private String password;

	
	
	public Customer() {
		super();

	}

	public Customer(int id, String name, String surname, String cf, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.cf = cf;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
