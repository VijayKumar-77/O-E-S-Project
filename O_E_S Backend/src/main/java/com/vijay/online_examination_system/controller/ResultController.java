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

import com.vijay.online_examination_system.DTO.ResultDTO;
import com.vijay.online_examination_system.Repository.ResultRepository;
import com.vijay.online_examination_system.model.Result;

@RestController
@CrossOrigin("*")
public class ResultController {

	@Autowired
	private ResultRepository resultRepository;

	// get all result present in database

	@GetMapping("/result")
	public ResponseEntity<Object> getAllResult() {
		List<Result> resultList = (List<Result>) this.resultRepository.findAll();
		if (resultList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No results found.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(resultList);
		}
	}

	// to save result

	@PostMapping("/save/result")
	public ResponseEntity<String> addNewResult(@RequestBody ResultDTO resultDTO) {
		try {
			// Convert the ResultDTO to a Result entity
			Result result = new Result();
			result.setStatus(resultDTO.getStatus());
			result.setScore(resultDTO.getScore());

			// Save the result using the resultRepository
			Result savedResult = this.resultRepository.save(result);

			if (savedResult != null) {
				return ResponseEntity.status(HttpStatus.CREATED)
						.body("Result saved successfully with ID: " + savedResult.getId());
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the result.");
			}
		} catch (Exception e) {
			// Handle the JSON parse error
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error parsing JSON request body: " + e.getMessage());
		}
	}

	// get all result of a particular student
	// Constructor injection
	public ResultController(ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}

	@GetMapping("/result/{id}")
	public ResponseEntity<Object> getResultById(@PathVariable("id") long id) {
		Result result = this.resultRepository.findById(id);
		if (result != null) {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result not found for the specified ID.");
		}

	}

}