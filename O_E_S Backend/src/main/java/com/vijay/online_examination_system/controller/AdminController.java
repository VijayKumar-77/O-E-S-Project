package com.vijay.online_examination_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vijay.online_examination_system.DTO.AdminLoginDTO;
import com.vijay.online_examination_system.Repository.AdminRepository;
import com.vijay.online_examination_system.Repository.TeacherRepository;
import com.vijay.online_examination_system.model.Admin;

import com.vijay.online_examination_system.model.Teacher;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	
	// get details by admin name
	@GetMapping("/{name}")
	public ResponseEntity<Object> getAdminDetails(@PathVariable("name") String name) {
		Admin admin = adminRepository.findByName(name);
		if (admin != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Admin Found successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found with name: " + name);
		}
	}

	// Admin registration
	@PostMapping("/register")
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
		Admin existingAdmin = adminRepository.findByName(admin.getName());
		if (existingAdmin != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin with this Username already exists.");
		}
		if (admin.getName() == null || admin.getName().isEmpty() || admin.getPassword() == null
				|| admin.getPassword().isEmpty()) {
			return ResponseEntity.badRequest().body("Admin name and password are required.");
		}
		adminRepository.save(admin);
		return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully.");
	}

	// Admin login
	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestBody AdminLoginDTO loginDTO) {
		Admin admin = adminRepository.findByNameAndPassword(loginDTO.getName(), loginDTO.getPassword());
		if (admin != null) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin name or password");
		}
	}

	// Admin can Add teacher
	@PostMapping("/add/teachers")
	public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
		if (teacher.getUsername() == null || teacher.getUsername().isEmpty() || teacher.getPassword() == null
				|| teacher.getPassword().isEmpty()) {
			return ResponseEntity.badRequest().body("Username and password are required.");
		}

		Teacher existingTeacher = teacherRepository.findByUsername(teacher.getUsername());
		if (existingTeacher != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Teacher with this username already exists.");
		}

		teacherRepository.save(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body("Teacher added successfully.");
	}

	// Admin can Get all teachers
	@GetMapping("/all/teachers")
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		List<Teacher> teachers = teacherRepository.findAll();
		return ResponseEntity.ok(teachers);
	}

	// Admin can Get teacher by ID
	@GetMapping("/all/teachers/{teacherId}")
	public ResponseEntity<Object> getTeacherById(@PathVariable Long teacherId) {
		Optional<Teacher> teacher = teacherRepository.findById(teacherId);
		if (teacher.isPresent()) {
			return ResponseEntity.ok(teacher.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found with id: " + teacherId);
		}
	}

	// Admin can Delete teacher
	@DeleteMapping("/delete/{teacherId}")
	public ResponseEntity<String> deleteTeacher(@PathVariable Long teacherId) {
		if (!teacherRepository.existsById(teacherId)) {
			return ResponseEntity.badRequest().body("Teacher not found with id: " + teacherId);
		}

		teacherRepository.deleteById(teacherId);
		return ResponseEntity.ok("Teacher deleted successfully.");
	}
}