package com.vijay.online_examination_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.online_examination_system.DTO.ResultDTO;
import com.vijay.online_examination_system.Repository.ResultRepository;
import com.vijay.online_examination_system.model.Result;

@RestController
@RequestMapping("/api/result")
public class ResultController {

	@Autowired
	private ResultRepository resultRepository;

	// get all result present in database

	@GetMapping("/all")
	public ResponseEntity<Object> getAllResult() {
		List<Result> resultList = (List<Result>) this.resultRepository.findAll();
		if (resultList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No results found.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(resultList);
		}
	}

	// to save result

	@PostMapping("/save/{email}")
	public ResponseEntity<String> addResultForStudent(@PathVariable("email") String email,
			@RequestBody ResultDTO resultDTO) {
		try {
			// Convert the ResultDTO to a Result entity
			Result result = new Result();
			result.setStatus(resultDTO.getStatus());
			result.setScore(resultDTO.getScore());
			result.setEmail(email);
			result.setExamDate(resultDTO.getExamDate());
			result.setTotalMarks(resultDTO.getTotalMarks());
			result.setTotalQuestion(resultDTO.getTotalQuestion());
			result.setSubjectName(resultDTO.getSubjectName());

			// Save the result using the resultRepository
			Result savedResult = this.resultRepository.save(result);

			if (savedResult != null) {
				return ResponseEntity.status(HttpStatus.CREATED)
						.body("Result saved successfully with ID: " + savedResult.getId());
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the result.");
			}
		} catch (Exception e) {
			// Handle the JSON parse error or other exceptions
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving result: " + e.getMessage());
		}
	}

	// get result of a particular student
	// Constructor injection
	public ResultController(ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getResultById(@PathVariable("id") long id) {
		Result result = this.resultRepository.findById(id);
		if (result != null) {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result not found for the specified ID.");
		}

	}

}