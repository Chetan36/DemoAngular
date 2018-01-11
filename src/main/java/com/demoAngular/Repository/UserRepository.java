package com.demoAngular.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demoAngular.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findById(String id);
	
	User findByUserName(String userName);
	
}
