package com.vijay.online_examination_system.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vijay.online_examination_system.model.Exam;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Integer> {

}