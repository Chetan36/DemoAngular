package com.demoAngular.Service;

import java.util.List;

import com.demoAngular.Model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getOneUserWithId(String id);
	
	User getOneUserWithName(String name);
	
	User addNewUser(User user);
	
	User updateExistingUser(String id, User user);
	
	void deleteOneUserById(String user);
	
	void deleteAllUsers();
	
}
