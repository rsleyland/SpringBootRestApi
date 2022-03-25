package com.example.API;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Address address = new Address("Canada", "Montreal", "H2L 3F3");
			Student student = new Student
					("ry", "Ley", "ry@ley", Gender.MALE, address, List.of("Software Engineering", "Maths"), BigDecimal.TEN, LocalDateTime.now());
			repository.insert(student);
		};
	};

}
