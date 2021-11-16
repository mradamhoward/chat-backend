package com.terabulk.seller.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class ChatDB {
	@Id
	private String id;
	
	private String chatId;
	
	private WebSocketChatMessage msg;
	
	@CreatedDate
	private Date createdDate; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public WebSocketChatMessage getMsg() {
		return msg;
	}

	public void setMsg(WebSocketChatMessage msg) {
		this.msg = msg;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
