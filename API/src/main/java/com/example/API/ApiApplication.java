package com.example.API;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	};

//	@Bean
////	CommandLineRunner runner(BaseUserRepository repository, MongoTemplate template) {
////		return args -> {
////			String email = "ry@ley";
////			Address address = new Address("Canada", "Montreal", "H2L 3F3");
////			BaseUser student = new BaseUser
////					("ry", "Ley", email, Gender.MALE, address, List.of("Software Engineering", "Maths"), BigDecimal.TEN, LocalDateTime.now());
////
//////			usingMongoTemplateAndQueries(repository, template, email, student);
////
////			repository.findBaseUserByEmail(email).ifPresentOrElse(s -> {
////				System.out.println("Student already exists with email " + email);
////			}, () -> {
////				System.out.println("Inserting student " + student);
////				repository.insert(student);
////				}
////			);
////
////		};
////	};

	
		

//	private void usingMongoTemplateAndQueries(StudentRepository repository, MongoTemplate template, String email,
//			Student student) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("email").is(email));
//		List<Student> students = template.find(query, Student.class);
//		
//		if (students.size() > 1) {
//			throw new IllegalStateException("Found more than one student with email "+ email);
//		}
//		if (students.isEmpty()) {
//			System.out.println("Inserting student " + student);
//			repository.insert(student);
//		}
//		else System.out.println("Student already exists with email " + email);
//	};

};
