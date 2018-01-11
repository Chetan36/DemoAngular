package com.demoAngular.Controller;

import java.util.List;

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
	
	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	List<User> getAllUsers()	{
		List<User> users = this.userService.getAllUsers();
		return users;
	}
	
	@DeleteMapping("/all")
	void deleteAllUsers()	{
		this.userService.deleteAllUsers();
	}
	
	@GetMapping("/{id}")
	User getOneUser(@PathVariable("id") String userId)	{
		User user = this.userService.getOneUserWithId(userId);
		return user;
	}
	
	@PutMapping("/{id}")
	void updateOneUser(@PathVariable("id") String id, @RequestBody User user)	{
		this.userService.updateExistingUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	void deleteOneUser(@PathVariable("id") String userId)	{
		this.userService.deleteOneUserById(userId);
	}
	
	@PostMapping
	void addOneUser(@RequestBody User user)	{
		this.userService.addNewUser(user);
	}
	
}
