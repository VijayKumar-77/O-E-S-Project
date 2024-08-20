package com.vijay.online_examination_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.online_examination_system.Repository.SubjectRepository;
import com.vijay.online_examination_system.model.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> getAllSubjects() {
		return (List<Subject>) subjectRepository.findAll();
	}

	public Subject addNewSubject(Subject subject) {
		return subjectRepository.save(subject);
	}


    public String deleteSubjectByName(String name) {
        int rowsDeleted = subjectRepository.deleteByName(name);
        return rowsDeleted + " Row(s) Got Deleted";
    }
}