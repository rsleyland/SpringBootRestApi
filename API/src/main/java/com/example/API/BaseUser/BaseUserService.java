package com.example.API.BaseUser;

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

	public List<BaseUser> getAllUsers() {
		List<BaseUser> users = baseUserRepository.findAll();
		users.forEach((u)->{
			u.setPassword("HIDDEN");
		});
		return users;
	};

	public Optional<BaseUser> getUserByEmail(String email) {
		Optional<BaseUser> user = baseUserRepository.findBaseUserByEmail(email);
		user.get().setPassword("HIDDEN");
		return user;
	};

	public Optional<BaseUser> getUserById(String id) {
		Optional<BaseUser> user = baseUserRepository.findBaseUserById(id);
		user.get().setPassword("HIDDEN");
		return user;
	};

};
