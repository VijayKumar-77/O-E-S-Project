package com.vijay.online_examination_system.controller;

import java.util.List;
import java.util.Optional;
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

import com.vijay.online_examination_system.Repository.ExamRepository;
import com.vijay.online_examination_system.model.Exam;


@RestController
@CrossOrigin("*")
public class ExamController {
	
	@Autowired
	private ExamRepository examRepository;
	
	
   // to get all exam
	
	@GetMapping("/exam")
	public List<Exam> getAllExam(){
		return (List<Exam>)this.examRepository.findAll();
	}
   
   //to get details of a particular exam
	
	@GetMapping("/exam/{id}")
	public Exam getParticularExam(@PathVariable("id") int id){
 		 Optional<Exam> optional =  this.examRepository.findById(id);
 		 if (optional.isPresent()) {
             return optional.get();
         } else {
             throw new RuntimeException("Exam not found for id :: " + id);
         }
     }

    //to add a new exam
	
	 @PostMapping("/add/exam")
	    public ResponseEntity<String> addNewExam(@RequestBody Exam exam) {
	        Exam savedExam = examRepository.save(exam);
	        String message = "Exam added successfully with ID: " + savedExam.getId();
	        return new ResponseEntity<>(message, HttpStatus.CREATED);
	    }
	

	
	// to delete a Exam
	 
	 @DeleteMapping("/delete/exam/{id}")
	 public ResponseEntity<String> deleteExam(@PathVariable("id") int id) {
	     if (examRepository.existsById(id)) {
	         examRepository.deleteById(id);
	         return ResponseEntity.ok("Exam with ID " + id + " deleted successfully.");
	     } else {
	         return ResponseEntity.notFound().build();
	     }
	 }	
	
}