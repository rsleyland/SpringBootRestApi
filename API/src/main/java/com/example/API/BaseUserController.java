package com.example.API;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/users")
public class BaseUserController {
	
	private BaseUserService baseUserService;
	
	public BaseUserController(BaseUserService baseUserService) {
		super();
		this.baseUserService = baseUserService;
	};

	@GetMapping("")
	public List<BaseUser> fetchAllUsers() {
		return baseUserService.getAllUsers();
	};

	@GetMapping("/{email}")
	public Optional<BaseUser> fetchUserByEmail(@PathVariable("email") String email) {
		return baseUserService.getUserByEmail(email);
	};

	@GetMapping("/id/{id}")
	public Optional<BaseUser> fetchUserById(@PathVariable("id") String id) {
		return baseUserService.getUserById(id);
	};

};
