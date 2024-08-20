package com.vijay.online_examination_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vijay.online_examination_system.DTO.StudentDTO;
//import com.vijay.online_examination_system.DTO.StudentQualificationDTO;
import com.vijay.online_examination_system.DTO.TeacherDTO;
//import com.vijay.online_examination_system.model.Student;
import com.vijay.online_examination_system.model.Teacher;
import com.vijay.online_examination_system.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

	private final TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	// Teacher Login
	@PostMapping("/login")
	public ResponseEntity<String> loginTeacher(@RequestBody TeacherDTO teacherDTO) {
		boolean result = teacherService.loginTeacher(teacherDTO);
		if (result) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		List<Teacher> teachers = teacherService.getAllTeachers();
		return ResponseEntity.ok(teachers);
	}

	// Teacher can Add Student
	@PostMapping("/add/student")
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
		teacherService.addStudent(studentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
	}

	// Teacher can update student details
	@PutMapping("/update/student/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
		boolean isUpdated = teacherService.updateStudent(id, studentDTO);
		if (isUpdated) {
			return ResponseEntity.ok("Student details updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		}
	}
}