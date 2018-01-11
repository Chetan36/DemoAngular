package com.demoAngular.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoAngular.Model.User;
import com.demoAngular.Service.UserService;

@RestController
@RequestMapping("/app/user")
public class ApplicationController {
	
	Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	List<User> getAllUsers()	{
		logger.info("ApplicationController.getAllUsers()");
		List<User> users = this.userService.getAllUsers();
		return users;
	}
	
	@DeleteMapping("/all")
	void deleteAllUsers()	{
		logger.info("ApplicationController.deleteAllUsers()");
		this.userService.deleteAllUsers();
	}
	
	@GetMapping("/{id}")
	User getOneUser(@PathVariable("id") String userId)	{
		logger.info("ApplicationController.getOneUser()");
		User user = this.userService.getOneUserWithId(userId);
		return user;
	}
	
	@PutMapping("/{id}")
	void updateOneUser(@PathVariable("id") String id, @RequestBody User user)	{
		logger.info("ApplicationController.updateOneUser()");
		this.userService.updateExistingUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	void deleteOneUser(@PathVariable("id") String userId)	{
		logger.info("ApplicationController.deleteOneUser()");
		this.userService.deleteOneUserById(userId);
	}
	
	@PostMapping
	void addOneUser(@RequestBody User user)	{
		logger.info("ApplicationController.addOneUser()");
		this.userService.addNewUser(user);
	}
	
}
