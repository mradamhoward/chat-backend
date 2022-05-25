package com.terabulk.seller.repository;


import com.terabulk.seller.models.SellerItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SellerItemRepo extends MongoRepository<SellerItem, String> {
    List<SellerItem> findBySellerId(String sellerId);
}