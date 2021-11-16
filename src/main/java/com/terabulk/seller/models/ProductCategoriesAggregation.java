package com.terabulk.seller.models;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ProductCategoriesAggregation {
	@NotNull
	private String id;
	private List<String> category;
	private List<String> subCategory1;
	private List<String> subCategory2;
	private List<String> subCategory3;
	private List<String> subCategory4;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public List<String> getSubCategory1() {
		return subCategory1;
	}
	public void setSubCategory1(List<String> subCategory1) {
		this.subCategory1 = subCategory1;
	}
	public List<String> getSubCategory2() {
		return subCategory2;
	}
	public void setSubCategory2(List<String> subCategory2) {
		this.subCategory2 = subCategory2;
	}
	public List<String> getSubCategory3() {
		return subCategory3;
	}
	public void setSubCategory3(List<String> subCategory3) {
		this.subCategory3 = subCategory3;
	}
	public List<String> getSubCategory4() {
		return subCategory4;
	}
	public void setSubCategory4(List<String> subCategory4) {
		this.subCategory4 = subCategory4;
	}
}
