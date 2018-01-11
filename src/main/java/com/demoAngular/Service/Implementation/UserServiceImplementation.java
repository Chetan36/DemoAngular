package com.demoAngular.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoAngular.Model.User;
import com.demoAngular.Repository.UserRepository;
import com.demoAngular.Service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		return users;
	}

	@Override
	public User getOneUserWithId(String id) {
		User user = this.userRepository.findById(id);
		return user;
	}
	
	@Override
	public User getOneUserWithName(String name) {
		User user = this.userRepository.findByName(name);
		return user;
	}

	@Override
	public User addNewUser(User user) {
		this.userRepository.insert(user);
		User dbUser = this.userRepository.findById(user.getId());
		return dbUser;
	}

	@Override
	public User updateExistingUser(String id, User user) {
		User dbUser = this.userRepository.findById(id);
		
		if(!user.getName().equals(null))	{
			dbUser.setName(user.getName());
		}
		
		this.userRepository.save(dbUser);		
		return dbUser;
	}

	@Override
	public void deleteOneUserById(String id) {
		this.userRepository.delete(id);
	}

	@Override
	public void deleteAllUsers() {
		this.userRepository.deleteAll();
	}
	
}
