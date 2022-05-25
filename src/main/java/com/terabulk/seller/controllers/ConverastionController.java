package com.terabulk.seller.controllers;

import com.terabulk.seller.models.Conversation;
import com.terabulk.seller.repository.ConversationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ConverastionController {
    @Autowired private ConversationRepo conversationRepo;

//    @PutMapping("/update/conversation")
//    public String updateConversation(@RequestParam String email, @RequestParam String contact){
//        Conversation conversation = conversationRepo.findByEmail(email);
//        if(conversation == null){
//            conversation = new Conversation();
//            conversation.setEmail(email);
//        }
//        conversation.getContacts().add(contact);
//        conversationRepo.save(conversation);
//        return "success";
//    }
//
//    @GetMapping("/conversation/contacts")
//    public List<String> getContactsFromConversation(@RequestParam String email){
//        return conversationRepo.findByEmail(email).getContacts();
//    }
}
