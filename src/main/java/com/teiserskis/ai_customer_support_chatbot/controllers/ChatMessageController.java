package com.teiserskis.ai_customer_support_chatbot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teiserskis.ai_customer_support_chatbot.dto.ChatRequest;
import com.teiserskis.ai_customer_support_chatbot.models.ChatMessage;
import com.teiserskis.ai_customer_support_chatbot.services.ChatMessageService;
import com.teiserskis.ai_customer_support_chatbot.services.DialogflowService;

@RestController
@RequestMapping("/chatbot")
public class ChatMessageController {
	
	private final ChatMessageService chatMessageService;
	private final DialogflowService dialogflowService;
	
	@Autowired
	public ChatMessageController(
			ChatMessageService chatMessageService,
			DialogflowService dialogflowService) {
		this.chatMessageService = chatMessageService;
		this.dialogflowService = dialogflowService;
	}
	
	@GetMapping("/messages")
	public List<ChatMessage> getMessages() {
		return chatMessageService.getMessages();
	} 
	
	@PostMapping()
	public ChatMessage postMessage(@RequestBody ChatRequest request) {
		String response;
		try {
			response = dialogflowService.detectIntentText(request.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response = "No response.";
		}
			
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setUsername(request.getUser().getUsername());
		chatMessage.setMessage(request.getMessage());
		chatMessage.setResponse(response);
		
		chatMessageService.saveMessage(chatMessage);
		
		return chatMessage;
	}

}
