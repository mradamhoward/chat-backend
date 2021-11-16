package com.terabulk.seller.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.terabulk.seller.models.WebSocketChatMessage;

public interface WebSocketChatMessageRepository extends MongoRepository<WebSocketChatMessage, String>{
	List<WebSocketChatMessage> findBySenderAndRecipient(String sender, String recipient, Sort sort);
}
