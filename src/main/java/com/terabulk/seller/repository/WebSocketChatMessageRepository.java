package com.terabulk.seller.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.terabulk.seller.models.WebSocketChatMessage;
import org.springframework.data.mongodb.repository.Query;

public interface WebSocketChatMessageRepository extends MongoRepository<WebSocketChatMessage, String>{
	List<WebSocketChatMessage> findBySenderAndRecipient(String sender, String recipient, Sort sort);
	List<WebSocketChatMessage> findBySenderAndRecipientOrRecipientAndSender(String sender, String recipient, String recipient2, String sender2);
	List<WebSocketChatMessage> findByRecipient(String recipient);
	List<WebSocketChatMessage> findAllBySenderAndRecipientOrRecipientAndSender(String sender, String recipient, String recipient2, String sender2);
	List<WebSocketChatMessage> findBySenderAndRecipientOrRecipientAndSender(String sender, String recipient, String recipient2, String sender2, Sort sort);

}
