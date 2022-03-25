package com.example.API;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {
	
	private StudentService studentService;
	
	
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	};


	@GetMapping
	public List<Student> fetchAllStudents() {	
		return studentService.getAllStudents();
	};

};
