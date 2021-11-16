package com.terabulk.seller.models;

import java.util.List;

public class ProductSearchCount {
	List<Product> results;
	long count;
	public List<Product> getResults() {
		return results;
	}
	public void setResults(List<Product> results) {
		this.results = results;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
}
