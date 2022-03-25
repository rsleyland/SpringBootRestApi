package com.example.API;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseUserRepository extends MongoRepository<BaseUser, String>{

	Optional<BaseUser> findBaseUserByEmail(String email);
	Optional<BaseUser> findBaseUserById(String id);
}
