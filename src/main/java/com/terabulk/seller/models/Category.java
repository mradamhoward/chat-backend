package com.terabulk.seller.models;

import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Category {
	@Id
	private String id;
	
	private String name;
	
	private String route;
	
	private HashSet<Category> subCats = new HashSet<Category>();
	
	public Category(String name, String route) {
		super();
		this.name = name;
		this.route = route;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public HashSet<Category> getSubCats() {
		return subCats;
	}

	public void setSubCats(HashSet<Category> subCats) {
		this.subCats = subCats;
	}
}
