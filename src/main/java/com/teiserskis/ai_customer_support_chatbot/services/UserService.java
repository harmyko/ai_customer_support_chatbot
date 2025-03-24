package com.teiserskis.ai_customer_support_chatbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teiserskis.ai_customer_support_chatbot.models.User;
import com.teiserskis.ai_customer_support_chatbot.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(int id, User updatedUser) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			return null;
		}
		
		User user = userOptional.get();
		
		user.setUsername(updatedUser.getUsername());
		user.setPassword(updatedUser.getPassword());
		user.setEmail(updatedUser.getEmail());
		
		userRepository.save(user);
		
		return user;
	}
}
