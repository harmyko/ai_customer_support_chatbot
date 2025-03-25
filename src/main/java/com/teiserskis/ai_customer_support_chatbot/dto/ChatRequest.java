package com.teiserskis.ai_customer_support_chatbot.dto;

import com.teiserskis.ai_customer_support_chatbot.models.User;

public class ChatRequest {
    private User user;
    private String message;
    
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
