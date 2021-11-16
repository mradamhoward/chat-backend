package com.terabulk.seller.controllers;

import com.terabulk.seller.models.ProductCategoriesAggregation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.terabulk.seller.models.Product;
import com.terabulk.seller.repository.ProductRepository;

import java.util.List;


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
}
