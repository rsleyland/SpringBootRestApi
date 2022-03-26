package com.example.API.BaseUser;

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

	@GetMapping("/{slug}")
	public Optional<BaseUser> fetchUserByPathVar(@PathVariable("slug") String slug) {
		return slug.contains("@") ? baseUserService.getUserByEmail(slug) : baseUserService.getUserById(slug);
	};

};
