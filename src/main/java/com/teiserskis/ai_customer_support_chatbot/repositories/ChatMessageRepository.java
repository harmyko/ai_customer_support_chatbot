package com.teiserskis.ai_customer_support_chatbot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teiserskis.ai_customer_support_chatbot.models.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {
	
	List<ChatMessage> findByUsername(String username);
}
