package com.teiserskis.ai_customer_support_chatbot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teiserskis.ai_customer_support_chatbot.models.User;
import com.teiserskis.ai_customer_support_chatbot.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
	@GetMapping("/list")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
    
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
    	User newUser = userService.addUser(user);
    	return newUser.getUsername() + " has been added to the database.";
    }
    
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
    	if (userService.updateUser(id, user) == null) {
    		return "User not found with ID: " + id;
    	}
    	
    	return "User [ID=" + id + "] has successfully been updated.";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
    	if (!userService.deleteUser(id)) {
    		return "User not found with ID: " + id;
    	}
    	
    	return "User [ID=" + id + "] has successfully been deleted.";
    }

}
