package com.teiserskis.ai_customer_support_chatbot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.teiserskis.ai_customer_support_chatbot.models.ChatMessage;
import com.teiserskis.ai_customer_support_chatbot.repositories.ChatMessageRepository;

@Service
public class ChatMessageService {
	
	private final ChatMessageRepository chatMessageRepository;
	
	@Autowired
	public ChatMessageService(ChatMessageRepository chatMessageRepository) {
		this.chatMessageRepository = chatMessageRepository;
	}
	
	public List<ChatMessage> getMessages() {
		return chatMessageRepository.findAll();
	}
	
	public ChatMessage saveMessage(ChatMessage chatMessage) {
		return chatMessageRepository.save(chatMessage);
	}
	
	
}
