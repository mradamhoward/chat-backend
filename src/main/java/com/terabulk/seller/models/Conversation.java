package com.terabulk.seller.models;


import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    @Id private String id;
    private String email;
    private List<String> contacts = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }
}
