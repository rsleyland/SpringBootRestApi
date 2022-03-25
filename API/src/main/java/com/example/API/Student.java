package com.example.API;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Student {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String email;
	private Gender gender;
	private Address address;
	private List<String> favouriteSubjects;
	private BigDecimal totalSpentInBooks;
	private LocalDateTime createdAt;
	
	public Student(String firstName, String lastName, String email, Gender gender, Address address,
			List<String> favouriteSubjects, BigDecimal totalSpentInBooks, LocalDateTime createdAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.favouriteSubjects = favouriteSubjects;
		this.totalSpentInBooks = totalSpentInBooks;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", address=" + address + ", favouriteSubjects=" + favouriteSubjects
				+ ", totalSpentInBooks=" + totalSpentInBooks + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
}
