package com.terabulk.seller.config;

import com.terabulk.seller.models.CategorySelect;
import com.terabulk.seller.repository.CategorySelectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SetupCategorySelects {

    @Autowired
    private CategorySelectRepository catRepo;

    @Bean
    public void setupCategorySelect(){
        insertCategorySelect("Electronics", 0, Arrays.asList("Mobile Phones", "Computers", "Audio", "TVs", "Printers", "PC Accessories"));
        insertCategorySelect("Health & Beauty", 0, Arrays.asList("Face Cream", "Razors", "Aftershave", "Toothpaste", "Toothbrush", "Body wash"));
        insertCategorySelect("Computers", 1, Arrays.asList("Laptops", "Desktops", "Servers"));
        insertCategorySelect("Laptops", 2, Arrays.asList("Windows", "Apple", "Gaming"));
        insertCategorySelect("Windows", 3, Arrays.asList("Everyday", "Home", "Office"));
        insertCategorySelect("Everyday", 4, Arrays.asList("Basic", "With graphics cars", "Premium"));
    }

    public void insertCategorySelect(String category, int index, List<String> cats){
        CategorySelect catSelect = new CategorySelect();
        catSelect.setCategory(category);
        catSelect.setCategoryIndex(index);
        catSelect.setSubCategories(cats);
        if(!catRepo.existsByCategory(category)){
            catRepo.save(catSelect);
        }
    }
}
