package com.terabulk.seller.repository;

import com.terabulk.seller.models.CategorySelect;
import com.terabulk.seller.models.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConversationRepo extends MongoRepository<Conversation, String> {
    Conversation findByEmail(String email);
}
