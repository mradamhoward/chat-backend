package com.terabulk.seller.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

	@Id
	private String id;
	
	@TextIndexed(weight=1)
	@NotBlank
	@Size(max = 400)
	private String title;
	 
	@NotBlank
	@Size(max = 20)
	private double price;
	
	@CreatedDate
	private Date created;
	
	@NotBlank
	@Size(max = 80)
	private String supplierRoute;
	
	private String supplierName;
	
	@NotBlank
	@Size(max = 80)
	private long minQuantity;
	
	@TextIndexed(weight=2)
	@NotBlank
	@Size(max = 200)
	private String model;
	
	private String featuredVideo;
	
	private String productUrl;
	
	@TextIndexed(weight=3)
	private String description;
	
	@TextIndexed(weight=10)
	private Set<ProductSpecification> specifications = new HashSet<>();
	
	private Set<String> imgs = new HashSet<>();
	
	@TextIndexed(weight=4)
	private String brand;
	
	@NotBlank
	@Size(max = 200)
	private String featuredImage;
	
	@TextIndexed(weight=5)
	private String category;
	@TextIndexed(weight=6)
	private String subCategory1;
	@TextIndexed(weight=7)
	private String subCategory2;
	@TextIndexed(weight=8)
	private String subCategory3;
	@TextIndexed(weight=9)
	private String subCategory4;
	
	private String supplierCountry;

	private String supplierContactEmail;

	public String getSupplierContactEmail() {
		return supplierContactEmail;
	}

	public void setSupplierContactEmail(String supplierContactEmail) {
		this.supplierContactEmail = supplierContactEmail;
	}
	
	public String getSupplierCountry() {
		return supplierCountry;
	}

	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory1() {
		return subCategory1;
	}

	public void setSubCategory1(String subCategory1) {
		this.subCategory1 = subCategory1;
	}

	public String getSubCategory2() {
		return subCategory2;
	}

	public void setSubCategory2(String subCategory2) {
		this.subCategory2 = subCategory2;
	}

	public String getSubCategory3() {
		return subCategory3;
	}

	public void setSubCategory3(String subCategory3) {
		this.subCategory3 = subCategory3;
	}

	public String getSubCategory4() {
		return subCategory4;
	}

	public void setSubCategory4(String subCategory4) {
		this.subCategory4 = subCategory4;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSupplierRoute() {
		return supplierRoute;
	}

	public void setSupplierRoute(String supplierRoute) {
		this.supplierRoute = supplierRoute;
	}

	public long getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(long minQuantity) {
		this.minQuantity = minQuantity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Set<ProductSpecification> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Set<ProductSpecification> specifications) {
		this.specifications = specifications;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}
	
	public void addImg(String img) {
		this.imgs.add(img);
	}
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getFeaturedVideo() {
		return featuredVideo;
	}

	public void setFeaturedVideo(String featuredVideo) {
		this.featuredVideo = featuredVideo;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getImgs() {
		return imgs;
	}

	public void setImgs(Set<String> imgs) {
		this.imgs = imgs;
	}
}
