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

import com.vijay.online_examination_system.DTO.ExamDTO;
import com.vijay.online_examination_system.Repository.ExamRepository;
import com.vijay.online_examination_system.Repository.SubjectRepository;
import com.vijay.online_examination_system.model.Exam;
import com.vijay.online_examination_system.model.Subject;

@RestController
@RequestMapping("/api/exam")
public class ExamController {

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	// to get all exam

	@GetMapping("/all")
	public List<Exam> getAllExam() {
		return (List<Exam>) this.examRepository.findAll();
	}

	// to get details of a particular exam

	@GetMapping("/{id}")
	public Exam getParticularExam(@PathVariable("id") int id) {
		Optional<Exam> optional = this.examRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RuntimeException("Exam not found for id :: " + id);
		}
	}

	// to add a new exam

	@PostMapping("/save")
	public ResponseEntity<String> addNewExam(@RequestBody ExamDTO examDTO) {
		try {
			Exam exam = new Exam();
			exam.setDesc(examDTO.getDesc());
			exam.setDate(examDTO.getDate());
			exam.setMarks(examDTO.getMarks());
			exam.setTotalQuestion(examDTO.getTotalQuestion());
			exam.setPassMarks(examDTO.getPassMarks());
			exam.setLevel(examDTO.getLevel());

			Optional<Subject> subjectOpt = subjectRepository.findById(examDTO.getSubjectId());
			if (subjectOpt.isPresent()) {
				exam.setSubject(subjectOpt.get());
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Subject not found.");
			}

			Exam savedExam = this.examRepository.save(exam);

			if (savedExam != null) {
				return ResponseEntity.status(HttpStatus.CREATED)
						.body("Exam saved successfully with ID: " + savedExam.getId());
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the exam.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error parsing JSON request body: " + e.getMessage());
		}
	}

	// to delete a Exam

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteExam(@PathVariable("id") int id) {
		if (examRepository.existsById(id)) {
			examRepository.deleteById(id);
			return ResponseEntity.ok("Exam with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}