package com.example.API;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	};
	
	

};
