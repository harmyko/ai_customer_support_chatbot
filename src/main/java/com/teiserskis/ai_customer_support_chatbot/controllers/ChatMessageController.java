package com.teiserskis.ai_customer_support_chatbot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teiserskis.ai_customer_support_chatbot.dto.ChatRequest;
import com.teiserskis.ai_customer_support_chatbot.models.ChatMessage;
import com.teiserskis.ai_customer_support_chatbot.services.ChatMessageService;

@RestController
@RequestMapping("/chatbot")
public class ChatMessageController {
	
	private final ChatMessageService chatMessageService;
	
	@Autowired
	public ChatMessageController(ChatMessageService chatMessageService) {
		this.chatMessageService = chatMessageService;
	}
	
	@GetMapping("/messages")
	public List<ChatMessage> getMessages() {
		return chatMessageService.getMessages();
	}
	
	@PostMapping()
	public ChatMessage postMessage(@RequestBody ChatRequest request) {
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setUsername(request.getUser().getUsername());
		chatMessage.setMessage(request.getMessage());
		chatMessage.setResponse("Pretend that this response is AI generated.");
		
		chatMessageService.saveMessage(chatMessage);
		
		return chatMessage;
	}

}
