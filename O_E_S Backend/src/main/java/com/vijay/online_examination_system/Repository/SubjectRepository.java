//package com.vijay.online_examination_system.Repository;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import com.vijay.online_examination_system.model.Subject;
//import jakarta.transaction.Transactional;
//
//@Repository
//public interface SubjectRepository extends CrudRepository<Subject, String> {
//
//	@Transactional
//	public int deleteByName(String name);
//
//}

//package com.vijay.online_examination_system.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import com.vijay.online_examination_system.model.Subject;
//
//@Repository
//public interface SubjectRepository extends JpaRepository<Subject, Long> {
//
//	int deleteByName(String name);
//}

package com.vijay.online_examination_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vijay.online_examination_system.model.Subject;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);
    int deleteByName(String name);  // Ensure this method is present
}