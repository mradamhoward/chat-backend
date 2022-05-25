package com.terabulk.seller.repository;

import com.terabulk.seller.models.SellerConversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerConversationRepo extends MongoRepository<SellerConversation, String> {
    SellerConversation findBySellerEmail(String email);
}
