package com.vijay.online_examination_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vijay.online_examination_system.Repository.QuestionRepository;
import com.vijay.online_examination_system.model.Question;



public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllSubjects() {
		return (List<Question>) questionRepository.findAll();
	}

	public Question addNewSubject(Question question) {
		return questionRepository.save(question);
	}

	public void deleteQuestion(Integer id) {
		questionRepository.deleteById(id);
	}

}
