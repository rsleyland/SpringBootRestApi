package com.example.API;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Address {
	private String country;
	private String city;
	private String postCode;
	
	public Address(String country, String city, String postCode) {
		super();
		this.country = country;
		this.city = city;
		this.postCode = postCode;
	}
	
	
}
