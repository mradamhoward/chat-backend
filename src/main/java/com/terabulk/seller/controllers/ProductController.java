package com.terabulk.seller.controllers;

import com.google.common.base.CaseFormat;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.terabulk.seller.models.Category;
import com.terabulk.seller.models.ProductCategoriesAggregation;
import com.terabulk.seller.models.ProductSpecification;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.terabulk.seller.models.Product;
import com.terabulk.seller.repository.ProductRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/seller/products")
public class ProductController {

	@Autowired
	private ProductRepository prodRepo;

	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		try {
			prodRepo.save(product);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}		
	}

	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return prodRepo.findAll();
	}

	@GetMapping("/categories")
	public List<ProductCategoriesAggregation> getCategories(){
			return prodRepo.aggCategories();
	}

	@GetMapping("/subcategory1s")
	public List<String> getSubCategory1sFromCategory(@RequestParam String category){
		return prodRepo.findSubCategory1sOfCategory(category).getSubCategory1();
	}

	@GetMapping("/subcategory2s")
	public List<String> getSubCategory2sFromCategory(@RequestParam String category){
		return prodRepo.findSubCategory2sOfCategory(category).getSubCategory2();
	}

	@GetMapping("/subcategory3s")
	public List<String> getSubCategory3sFromCategory(@RequestParam String category){
		return prodRepo.findSubCategory3sOfCategory(category).getSubCategory3();
	}

	@GetMapping("/subcategory4s")
	public List<String> getSubCategory4sFromCategory(@RequestParam String category){
		return prodRepo.findSubCategory4sOfCategory(category).getSubCategory4();
	}

	@PostMapping("/bulk/csv")
	public void csvBulkAdd(@RequestParam String csvFileUrl){

		File csvData = new File("C:\\Users\\Adam\\paddybaba\\seller-backend\\src\\main\\resources\\amazon_co-ecommerce_sample.csv");
		String path = "C:\\Users\\Adam\\paddybaba\\seller-backend\\src\\main\\resources\\marketing_sample_for_amazon_com-ecommerce__20200101_20200131__10k_data.csv";
		Reader in = null;
		try {
			in = new FileReader(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Iterable<CSVRecord> records = null;
		try {
			records = CSVFormat.EXCEL.withHeader().parse(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (CSVRecord record : records) {
			String title = record.get("Product Name");
			String manufacturer = record.get("Brand Name");
			String price = record.get("Selling Price");//£23.32
			String desc = record.get("About Product");
			String color = record.get("Color");
			ProductSpecification ps = new ProductSpecification();
			ps.setSpecification(record.get("Product Specification"));
			String img = record.get("Image");



			String category = record.get("Category");
			String[] categorySplit = category.split(" \\| ");

			Product product = new Product();
			product.setModel(color);
			product.setFeaturedImage(img);
			product.setTitle(title);
			product.setDescription(desc);
			product.setProductUrl(product.getId());
			product.setSupplierCountry("Ireland");
			product.setSupplierRoute("razer-2");
			ArrayList<String> supplierContactEmails = new ArrayList<String>();
			supplierContactEmails.add("kim@northkorea.com");
			supplierContactEmails.add("buzz@nasa.com");
			supplierContactEmails.add("elon@tesla.com");
			supplierContactEmails.add("kev@wellsfargo.com");
			supplierContactEmails.add("charlie@tesla.com");
			supplierContactEmails.add("eddie@boeing.com");
			supplierContactEmails.add("test@razer2.com");

			Random rand = new Random();

// Obtain a number between [0 - 49].
			int n = rand.nextInt(7);
			product.setSupplierContactEmail(supplierContactEmails.get(n));



			try{
				System.out.println("categorySplit[0] " + categorySplit[0]);
				System.out.println("categorySplit[1] " + categorySplit[1]);
				System.out.println("categorySplit[2] " + categorySplit[2]);
				System.out.println("categorySplit[3] " + categorySplit[3]);
				System.out.println("categorySplit[4] " + categorySplit[4]);

				product.setCategory(categorySplit[0]);
				product.setSubCategory1(categorySplit[1]);
				product.setSubCategory2(categorySplit[2]);
				product.setSubCategory3(categorySplit[3]);
				product.setSubCategory4(categorySplit[4]);
			} catch (Exception e) {

			}

			HashSet<ProductSpecification> set = new HashSet<>();
			set.add(ps);
			product.setSpecifications(set);
			product.setBrand(manufacturer);
			product.setSupplierName("razer-2");
			try{
				product.setPrice(Double.parseDouble(price.substring(1)));
			} catch (Exception e){

			}

			prodRepo.save(product);
			System.out.println(price);

		}

	}
}
