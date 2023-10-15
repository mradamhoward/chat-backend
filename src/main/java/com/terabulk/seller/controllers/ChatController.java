package com.terabulk.seller.controllers;

import com.terabulk.seller.models.*;
import com.terabulk.seller.rabbitmq.RabbitMQSender;
import com.terabulk.seller.repository.ConversationRepo;
import com.terabulk.seller.repository.ProfileRepo;
import com.terabulk.seller.repository.SellerConversationRepo;
import com.terabulk.seller.repository.WebSocketChatMessageRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)	
@RestController
public class ChatController {

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	private SimpMessagingTemplate brokerMessagingTemplate;
	
	@Autowired
	private WebSocketChatMessageRepository chatMsgRepo;

	@Autowired private SimpMessagingTemplate messagingTemplate;

	@Autowired private MongoTemplate mongoTemplate;

	@Autowired private ConversationRepo conversationRepo;

	@Autowired private SellerConversationRepo sellerConversationRepo;

	@Autowired private ProfileRepo profileRepo;

	@MessageMapping("/chat")
	public void sendMessage(@Payload WebSocketChatMessage message) {
		System.out.println(message.getRecipient());
		System.out.println(message.getContent());
		chatMsgRepo.save(message);
		messagingTemplate.convertAndSendToUser(message.getRecipient(), "/queue/messages", message);
	}

		@GetMapping("/messages")
		public List<WebSocketChatMessage> findChatMessages (@RequestParam String sender,
															@RequestParam String recipient) {
			Query query = new Query();
			Criteria criteria = new Criteria();
			criteria.orOperator(Criteria.where("sender").is(sender).and("recipient").is(recipient), Criteria.where("recipient").is(sender).and("sender").is(recipient));
			query.addCriteria(criteria);

			List<WebSocketChatMessage> msgs = mongoTemplate.find(query, WebSocketChatMessage.class);


			return msgs;
		}

	@GetMapping("/conversation/contacts")
	public List<String> getConversationContactsByEmail(@RequestParam String email){
		return conversationRepo.findByEmail(email).getContacts();
	}

	@PutMapping("/conversation/update")
	public String updateConversationContact(@RequestParam String email, @RequestParam String contact){
		Conversation conversation = conversationRepo.findByEmail(email);
		if(conversation == null){
			conversation = new Conversation();
			conversation.setEmail(email);
		}


		boolean isContactThere = false;

		for(String c: conversation.getContacts()){
			if(c.equalsIgnoreCase(contact)){
				isContactThere = true;
			}
		}

		if(!isContactThere){
			conversation.getContacts().add(contact);
		}

		conversationRepo.save(conversation);
		SellerConversation sellerConversation = sellerConversationRepo.findBySellerEmail(contact);
		if(sellerConversation == null){
			sellerConversation = new SellerConversation();
			sellerConversation.setSellerEmail(contact);
		}

		boolean isSellerRecipientThere = false;

		for(String r: sellerConversation.getRecipients()){
			if(r.equalsIgnoreCase(email)){
				isSellerRecipientThere = true;
			}
		}

		if(!isSellerRecipientThere){
			sellerConversation.getRecipients().add(email);
		}

		sellerConversationRepo.save(sellerConversation);

		return "Success";
	}

	@GetMapping("/profile/email")
	public Profile getProfile(@RequestParam String email){
		return profileRepo.findByEmail(email);
	}


	@GetMapping("/conversation/seller/list")
	public List<String> getSellerConversations(@RequestParam String email){
		return sellerConversationRepo.findBySellerEmail(email).getRecipients();
	}


	//Not implemented on client customer side, currently getting contact emails then using another http request for profiles. This aims to bring all t
	//logic together.
	@GetMapping("/conversation/profiles/email")
	public List<Profile> getAllConversationProfilesCustomer(@RequestParam String email){
		List<String> contacts = conversationRepo.findByEmail(email).getContacts();
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		for(String contact: contacts){
			try{
				profiles.add(profileRepo.findByEmail(contact));
			} catch (Exception e){

			}

		}

		return profiles;
	}
	@GetMapping("/conversation/profiles/seller/email")
	public List<Profile> getAllConversationProfilesSeller(@RequestParam String email){
		List<String> contacts = sellerConversationRepo.findBySellerEmail(email).getRecipients();
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		for(String contact: contacts){
			try{
				profiles.add(profileRepo.findByEmail(contact));
			} catch (Exception e){

			}

		}

		return profiles;
	}



}	
