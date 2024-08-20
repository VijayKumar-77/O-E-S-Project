package com.vijay.online_examination_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vijay.online_examination_system.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	Teacher findByUsername(String username);
}
