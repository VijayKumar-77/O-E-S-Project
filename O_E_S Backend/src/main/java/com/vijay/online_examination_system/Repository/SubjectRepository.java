package com.vijay.online_examination_system.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vijay.online_examination_system.model.Subject;
import jakarta.transaction.Transactional;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, String> {
	
	@Transactional
	public int deleteByName(String name);

}
