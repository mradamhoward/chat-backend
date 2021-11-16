package com.terabulk.seller.controllers;


import com.terabulk.seller.models.CategorySelect;
import com.terabulk.seller.repository.CategorySelectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/seller/categorySelect")
public class CategorySelectController {

    @Autowired
    private CategorySelectRepository catRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/index/0/all")
    public List<String> getCategorySelectsIndex0(){
//        Query query = new Query();
//        query.addCriteria(Criteria.where("categoryIndex").is(0));
//
//        MatchOperation matchStage = Aggregation.match(new Criteria("categoryIndex").is(0));
//
//        GroupOperation groupOperation = Aggregation.group("subCategories");
//
//
//
//        Aggregation aggregation
//                = Aggregation.newAggregation(matchStage, groupOperation);
//
//        AggregationResults<String> output
//                = mongoTemplate.aggregate(aggregation, "categorySelect", String.class);
        MatchOperation matchStage = Aggregation.match(new Criteria("categoryIndex").is(0));
        GroupOperation groupOperation = Aggregation.group("category");
        Aggregation aggregation = Aggregation.newAggregation(matchStage, groupOperation);
        AggregationResults<String> output = mongoTemplate.aggregate(aggregation, "categorySelect", String.class);

        return output.getMappedResults();
    }

    @GetMapping("/index/0")
    public List<String> getCategorySelectIndex0(@RequestParam String cat){
        MatchOperation matchStage = Aggregation.match(new Criteria("category").is(cat));
        GroupOperation groupOperation = Aggregation.group("subCategories");
        Aggregation aggregation = Aggregation.newAggregation(matchStage, groupOperation);
        AggregationResults<String> output = mongoTemplate.aggregate(aggregation, "categorySelect", String.class);
        return output.getMappedResults();
    }
    @GetMapping("/index/1")
    public List<String> getCategorySelectIndex1(@RequestParam String cat){
        return catRepo.findByCategoryAndCategoryIndex(cat, 1).getSubCategories();
    }

}
