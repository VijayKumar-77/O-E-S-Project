package com.vijay.online_examination_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vijay.online_examination_system.Repository.ExamRepository;
import com.vijay.online_examination_system.model.Exam;

public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	public List<Exam> getAllSubjects() {
		return (List<Exam>) examRepository.findAll();
	}

	public Exam addNewSubject(Exam exam) {
		return examRepository.save(exam);
	}

	public void deleteQuestion(Integer id) {
		examRepository.deleteById(id);
	}
}
