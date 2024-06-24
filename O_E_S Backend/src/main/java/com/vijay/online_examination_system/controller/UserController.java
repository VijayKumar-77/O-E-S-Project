package com.vijay.online_examination_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.online_examination_system.DTO.UserLoginDTO;
import com.vijay.online_examination_system.Repository.UserRepository;
import com.vijay.online_examination_system.model.User;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// get all user

	@GetMapping("/user")
	public List<User> getAllUser() {
		return (List<User>) this.userRepository.findAll();
	}

	// get user detail by its email

	@GetMapping("/user/{email}")
	public User getUserDetails(@PathVariable("email") String email) {
		return this.userRepository.findByEmail(email);
	}

	// to add a new user

	@PostMapping("/user/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		if (this.userRepository.findByEmail(user.getEmail()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists.");
		}
		this.userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
	}

	// user login

	@PostMapping("/user/login")
	public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO loginDTO) {
		User user = this.userRepository.findByEmail(loginDTO.getEmail());
		if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
	}
}
