package com.terabulk.seller.models;

import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stores")
public class Store {
	@Id
	private String id;

	private String name;
	
	private String logoImg;
	
	private String storeUrl;
	
	private HashSet<Category> categories = new HashSet<>();
	
	private HashSet<Category> navCategories = new HashSet<>();
	
	private HashSet<String> featuredImgs = new HashSet<>();
	
	private HashSet<Review> reviews = new HashSet<>();

	private String sellerId;




	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public void addCategory(String name, String route) {
		this.categories.add(new Category(name, route));
	}
	
	public void addNavCategory(String name, String route) {
		this.navCategories.add(new Category(name, route));
	}
	
	
	public void addFeaturedImg(String img) {
		this.featuredImgs.add(img);
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

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public HashSet<Category> getCategories() {
		return categories;
	}

	public void setCategories(HashSet<Category> categories) {
		this.categories = categories;
	}

	public HashSet<Category> getNavCategories() {
		return navCategories;
	}

	public void setNavCategories(HashSet<Category> navCategories) {
		this.navCategories = navCategories;
	}

	public HashSet<String> getFeaturedImgs() {
		return featuredImgs;
	}

	public void setFeaturedImgs(HashSet<String> featuredImgs) {
		this.featuredImgs = featuredImgs;
	}

	public HashSet<Review> getReviews() {
		return reviews;
	}

	public void setReviews(HashSet<Review> reviews) {
		this.reviews = reviews;
	}
}
