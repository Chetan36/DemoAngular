package com.demoAngular.Service.Implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoAngular.Model.User;
import com.demoAngular.Repository.UserRepository;
import com.demoAngular.Service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		logger.info("UserService.getAllUsers()");
		List<User> users = this.userRepository.findAll();
		return users;
	}

	@Override
	public User getOneUserWithId(String id) {
		logger.info("UserService.getOneUserWithId()");
		User user = this.userRepository.findById(id);
		return user;
	}
	
	@Override
	public User getOneUserWithName(String name) {
		logger.info("UserService.getOneUserWithName()");
		User user = this.userRepository.findByName(name);
		return user;
	}

	@Override
	public User addNewUser(User user) {
		logger.info("UserService.addNewUser()");
		this.userRepository.save(user);
		User dbUser = this.userRepository.findById(user.getId());
		return dbUser;
	}

	@Override
	public User updateExistingUser(String id, User user) {
		logger.info("UserService.updateExistingUser()");
		User dbUser = this.userRepository.findById(id);
		
		if(!user.getName().equals(null))	{
			dbUser.setName(user.getName());
		}
		
		this.userRepository.save(dbUser);		
		return dbUser;
	}

	@Override
	public void deleteOneUserById(String id) {
		logger.info("UserService.deleteOneUserById()");
		this.userRepository.delete(id);
	}

	@Override
	public void deleteAllUsers() {
		logger.info("UserService.deleteAllUsers()");
		this.userRepository.deleteAll();
	}
	
}
