package com.example.API.BaseUser;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.API.Address;
import com.example.API.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BaseUser {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String email;
	private String password;
	private Gender gender;
	private Address address;
	private LocalDateTime createdAt;
	
	public BaseUser(String firstName, String lastName, String email, String password, Gender gender, Address address,
					LocalDateTime createdAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", address=" + address + ", createdAt=" + createdAt + "]";
	}
	
}
