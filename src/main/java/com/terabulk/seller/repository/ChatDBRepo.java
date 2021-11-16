package com.terabulk.seller.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.terabulk.seller.models.ChatDB;

public interface ChatDBRepo extends MongoRepository<ChatDB, String> {

}
