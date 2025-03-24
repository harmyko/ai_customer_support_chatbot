package com.teiserskis.ai_customer_support_chatbot.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ApiControllers {
	

	@GetMapping()
	public String getPage() {
		return "Hello everyone this is my awesome page with users and all that.";
	}
	
}
