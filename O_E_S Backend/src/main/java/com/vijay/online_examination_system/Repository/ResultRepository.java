package com.vijay.online_examination_system.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vijay.online_examination_system.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByEmail(String email); 

    Result findById(long id); 
}