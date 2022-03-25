package com.example.API;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class BaseUserService {
	
	private BaseUserRepository baseUserRepository;


	public BaseUserService(BaseUserRepository baseUserRepository) {
		super();
		this.baseUserRepository = baseUserRepository;
	}

	public List<BaseUser> getAllUsers() { return baseUserRepository.findAll(); };

	public Optional<BaseUser> getUserByEmail(String email) { return baseUserRepository.findBaseUserByEmail(email); };

	public Optional<BaseUser> getUserById(String id) {
		return baseUserRepository.findBaseUserById(id);
	};

};
