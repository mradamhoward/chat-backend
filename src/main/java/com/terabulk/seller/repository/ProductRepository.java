package com.terabulk.seller.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.terabulk.seller.models.ERole;
import com.terabulk.seller.models.Product;
import com.terabulk.seller.models.ProductCategoriesAggregation;
import com.terabulk.seller.models.Role;

public interface ProductRepository extends MongoRepository<Product, String> {
  Optional<Product> findByTitle(String title);
  @Aggregation(pipeline = {"{\"$match\": {\"category\": {\"$exists\": true,\"$ne\": null}}}", "{$group: { _id: \"$category\" ,subCategory1: { $addToSet: \"$subCategory1\" },subCategory2: { $addToSet: \"$subCategory2\" },subCategory3: { $addToSet: \"$subCategory3\" },subCategory4: { $addToSet: \"$subCategory4\" }}}"})
  List<ProductCategoriesAggregation> aggCategories();	
  
  @Query("{ 'category' : { '$regex' : ?0 , $options: 'i'}}")
  List<Product> findByCategory(String category);
  @Query("{ 'subCategory1' : { '$regex' : ?0 , $options: 'i'}}")
  List<Product> findBySubCategory1(String category);
  
  @Query("{ 'subCategory2' : { '$regex' : ?0 , $options: 'i'}}")
  List<Product> findBySubCategory2(String category);
  
  @Aggregation(pipeline = {"{ $match : { 'category' : { $regex: ?0, $options: 'i'}}}", "{ $group : { _id: null, subCategory1: { $addToSet: \"$subCategory1\" }, subCategory2: { $addToSet: \"$subCategory2\" } , subCategory3: { $addToSet: \"$subCategory3\" } , subCategory4: { $addToSet: \"$subCategory4\" } }}"})
  ProductCategoriesAggregation findAllCategoriesForSpecific(String category);
  
  @Aggregation(pipeline = {"{ $match : { 'subCategory1' : { $regex: '?0', $options: 'i'}}}", "{ $group : { _id: null, subCategory2: { $addToSet: \"$subCategory2\" } , subCategory3: { $addToSet: \"$subCategory3\" } , subCategory4: { $addToSet: \"$subCategory4\" } }});"})
  ProductCategoriesAggregation findSubCategoriesOfSubCategory1(String cat);
  
  @Aggregation(pipeline = {"{ $match : { 'subCategory2' : { $regex: ?0, $options: 'i'}}}", "{ $group : { _id: null, subCategory3: { $addToSet: \"$subCategory3\" } , subCategory4: { $addToSet: \"$subCategory4\" } }}"})
  ProductCategoriesAggregation findSubCategoriesOfSubCategory2(String cat);

  @Aggregation(pipeline = {"{ $match : { 'category' : { $regex: ?0, $options: 'i'}}}", "{ $group : { _id: null, subCategory1: { $addToSet: \"$subCategory1\" } }}"})
  ProductCategoriesAggregation findSubCategory1sOfCategory(String cat);

  @Aggregation(pipeline = {"{ $match : { 'subCategory1' : { $regex: ?0, $options: 'i'}}}", "{ $group : { _id: null, subCategory2: { $addToSet: \"$subCategory2\" } }}"})
  ProductCategoriesAggregation findSubCategory2sOfCategory(String cat);

  @Aggregation(pipeline = {"{ $match : { 'subCategory2' : { $regex: ?0, $options: 'i'}}}", "{ $group : { _id: null, subCategory3: { $addToSet: \"$subCategory3\" } }}"})
  ProductCategoriesAggregation findSubCategory3sOfCategory(String cat);

  @Aggregation(pipeline = {"{ $match : { 'subCategory3' : { $regex: ?0, $options: 'i'}}}", "{ $group : { _id: null, subCategory4: { $addToSet: \"$subCategory4\" } }}"})
  ProductCategoriesAggregation findSubCategory4sOfCategory(String cat);
}
