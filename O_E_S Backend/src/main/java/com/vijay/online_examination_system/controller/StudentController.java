package com.vijay.online_examination_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.online_examination_system.DTO.StudentLoginDTO;
import com.vijay.online_examination_system.Repository.StudentRepository;
import com.vijay.online_examination_system.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentRepository userRepository;

	// get all Students
	@GetMapping("/all")
	public List<Student> getAllUser() {
		return (List<Student>) this.userRepository.findAll();
	}

	// Student login
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody StudentLoginDTO loginDTO) {
		Student user = this.userRepository.findByEmail(loginDTO.getEmail());
		if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
	}
}

//// get Students details by his email
//
//@GetMapping("/{email}")
//public Student getUserDetails(@PathVariable("email") String email) {
//	return this.userRepository.findByEmail(email);
//}