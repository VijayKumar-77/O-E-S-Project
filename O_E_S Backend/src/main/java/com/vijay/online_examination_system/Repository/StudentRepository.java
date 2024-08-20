//package com.vijay.online_examination_system.Repository;
//
//import com.vijay.online_examination_system.model.Student;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface StudentRepository extends CrudRepository<Student, String> {
//
//	public Student findByEmail(String email);
//}

package com.vijay.online_examination_system.Repository;

import com.vijay.online_examination_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
