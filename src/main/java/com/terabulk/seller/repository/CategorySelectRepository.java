package com.terabulk.seller.repository;

import com.terabulk.seller.models.CategorySelect;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CategorySelectRepository extends MongoRepository<CategorySelect, String> {
    CategorySelect findByCategoryAndCategoryIndex(String category, int index);
    List<String> findByCategoryIndex(int index);
    boolean existsByCategory(String cat);
}
