package com.terabulk.seller.controllers;

import com.terabulk.seller.models.Profile;
import com.terabulk.seller.models.WebSocketChatMessage;
import com.terabulk.seller.repository.ProfileRepo;
import com.terabulk.seller.repository.WebSocketChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ChatRestController {
	@Autowired
	private WebSocketChatMessageRepository chatMsgRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	private ProfileRepo proRepo;
	
	@GetMapping("/api/msgs/all")
	public List<WebSocketChatMessage> getAllMessages(@RequestParam String sender, @RequestParam String recipient){
		Query q = new Query();
		q.fields().include("sender");
		System.out.println(mongoTemplate.findDistinct(q, "recipient", WebSocketChatMessage.class, String.class));
		return chatMsgRepo.findBySenderAndRecipient(sender, recipient, Sort.by(Sort.Direction.DESC, "_id"));
	}
	
	@GetMapping("/api/recipients/specific")
	public List<Profile> getRecipients(@RequestParam String sender){
		Query q = new Query();
		q.fields().include("sender");
		List<String> recipientEmails = mongoTemplate.findDistinct(q, "recipient", WebSocketChatMessage.class, String.class);
		Query all = new Query();
		all.addCriteria(Criteria.where("email").in(recipientEmails));
		List<Profile> profiles = mongoTemplate.find(all, Profile.class);
		Query msgs = new Query();
		msgs.addCriteria(Criteria.where("recipient").in(recipientEmails));
		List<WebSocketChatMessage> msgResults = mongoTemplate.find(msgs, WebSocketChatMessage.class);
		Set<String> set = new HashSet<String>();
		Set<String> recipients = new HashSet<String>();
		ArrayList<String> lastMsgs = new ArrayList<String>();
		ArrayList<String> foundRecipients = new ArrayList<String>();
		System.out.println(msgResults.size());

		for(int x = msgResults.size() - 1; x > 0; x--) {
//			System.out.println( "dsad" + foundRecipients.contains(msgResults.get(x).getRecipient()));
			if(!foundRecipients.contains(msgResults.get(x).getRecipient())) {
				foundRecipients.add(msgResults.get(x).getRecipient());
				lastMsgs.add(msgResults.get(x).getContent());
			}
		}
			for(int i = 0; i < profiles.size(); i++) {
				for(int j = 0; j < lastMsgs.size(); j++) {
					if(profiles.get(i).getEmail().equalsIgnoreCase(foundRecipients.get(j))) {
						System.out.println("if" + profiles.get(i).getEmail().equalsIgnoreCase(foundRecipients.get(j)));
						System.out.println("found recipients " + foundRecipients.get(j));
						profiles.get(i).setMostRecentMsg(lastMsgs.get(j));
					}
				}
			}
		System.out.println("prifles" + profiles.size());
		System.out.println("msgs " + lastMsgs.size());
		return profiles;
	}

	@GetMapping("/api/sender/emails")
	List<Profile> getProfilesFromRecipient(@RequestParam String recipient){
		System.out.println("HIT");
		Query q = new Query();
		q.fields().include("recipient");
		List<String> senderEmails = mongoTemplate.findDistinct(q, "sender", WebSocketChatMessage.class, String.class);
		System.out.println("Sender emails: " + senderEmails);

		ArrayList<Profile> profiles = new ArrayList<>();
		for(String senders: senderEmails){
			if(proRepo.findByEmail(senders) != null)
				profiles.add(proRepo.findByEmail(senders));
		}


		return profiles;
	}

		@GetMapping("/api/profile/specific")
	Profile getSpecificProfile(@RequestParam String email){
		return proRepo.findByEmail(email);
	}


}
