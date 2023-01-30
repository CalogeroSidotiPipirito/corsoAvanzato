package com.esercitazioneSpringDataAccess.web.dao.model;

public class Category {

	private int id;
	private String name;
	private String description;
	private Category idParentCategory;

	public Category() {
		super();

	}

	public Category(int id, String name, String description, Category idParentCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.idParentCategory = idParentCategory;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getIdParentCategory() {
		return idParentCategory;
	}

	public void setIdParentCategory(Category idParentCategory) {
		this.idParentCategory = idParentCategory;
	}

}
