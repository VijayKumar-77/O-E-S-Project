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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.online_examination_system.Repository.QuestionRepository;
import com.vijay.online_examination_system.Repository.SubjectRepository;
import com.vijay.online_examination_system.model.Question;
import com.vijay.online_examination_system.model.Subject;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	// to show all question present in database
	@GetMapping("/all")
	public List<Question> getAllQuestion() {
		return (List<Question>) this.questionRepository.findAll();
	}

	// add a question in a particular exam
	  @PostMapping("/add")
	    public ResponseEntity<String> addNewQuestion(@RequestBody Question question) {
	        try {
	            // Ensure the subject exists before saving the question
	            Optional<Subject> optionalSubject = subjectRepository.findByName(question.getSname_subject_name().getName());
	            if (optionalSubject.isPresent()) {
	                question.setSname_subject_name(optionalSubject.get());
	                Question savedQuestion = questionRepository.save(question);
	                String message = "Question added successfully with ID: " + savedQuestion.getId();
	                return ResponseEntity.status(HttpStatus.CREATED).body(message);
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                        .body("Invalid subject name: " + question.getSname_subject_name().getName());
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Error adding question: " + e.getMessage());
	        }
	    }


	// edit a question in a particular exam
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable("id") int id, @RequestBody Question question) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if (optionalQuestion.isPresent()) {
			Question existingQuestion = optionalQuestion.get();

			existingQuestion.setQuestion_name(question.getQuestion_name());
			existingQuestion.setOption_one(question.getOption_one());
			existingQuestion.setOption_two(question.getOption_two());
			existingQuestion.setOption_three(question.getOption_three());
			existingQuestion.setOption_four(question.getOption_four());
			existingQuestion.setAnswer(question.getAnswer());
			existingQuestion.setSname_subject_name(question.getSname_subject_name());
			existingQuestion.setEname(question.getEname());

			Question updatedQuestion = questionRepository.save(existingQuestion);
			return ResponseEntity.ok("Question with ID " + updatedQuestion.getId() + " updated successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	 @GetMapping("/exam/question/{id}")
	    public ResponseEntity<Object> getQuestionById(@PathVariable("id") int id) {
	        Optional<Question> optionalQuestion = this.questionRepository.findById(id);
	        if (optionalQuestion.isPresent()) {
	            return ResponseEntity.ok(optionalQuestion.get());
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found for ID: " + id);
	        }
	}

	// delete a question in a particular exam
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("id") int id) {
		this.questionRepository.deleteById(id);
		String message = "Question with ID " + id + " deleted successfully";
		return ResponseEntity.ok(message);
	}

}
