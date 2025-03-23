package com.teiserskis.ai_customer_support_chatbot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

	@GetMapping("/")
	public String getPage() {
		return "Awesome page";
	}
}
