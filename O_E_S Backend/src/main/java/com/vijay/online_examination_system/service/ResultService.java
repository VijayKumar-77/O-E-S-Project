package com.vijay.online_examination_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vijay.online_examination_system.Repository.ResultRepository;
import com.vijay.online_examination_system.model.Result;



public class ResultService {

	@Autowired
	private ResultRepository resultRepository;

	public List<Result> getAllResults() {
		return (List<Result>) resultRepository.findAll();
	}

	public Result addNewSubject(Result result) {
		return resultRepository.save(result);
	}

	public void deleteResult(Long id) {
		resultRepository.deleteById(id);
	}
	
}
