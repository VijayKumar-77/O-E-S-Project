package com.vijay.online_examination_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.online_examination_system.Repository.SubjectRepository;
import com.vijay.online_examination_system.model.Subject;

@RestController
@CrossOrigin("*")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;

	// to get all subject

	@GetMapping("/subject")
	public List<Subject> getAllSubjects() {
		return (List<Subject>) this.subjectRepository.findAll();
	}

	// to add a new subject

	@PostMapping("/add/subject")
	public ResponseEntity<String> addNewSubject(@RequestBody Subject subject) {
		try {
			Subject savedSubject = this.subjectRepository.save(subject);
			String message = "Subject Added Successfully With Name: " + savedSubject.getName();
			return ResponseEntity.status(HttpStatus.CREATED).body(message);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Subject Could Not Be Added: " + e.getMessage());
		}
	}

	// to delete a subject

	@DeleteMapping("/delete/subject/{name}")
	public String deleteSubject(@PathVariable("name") String name) {
		int row = this.subjectRepository.deleteByName(name);
		return row + " Row Got Deleted";
	}
}