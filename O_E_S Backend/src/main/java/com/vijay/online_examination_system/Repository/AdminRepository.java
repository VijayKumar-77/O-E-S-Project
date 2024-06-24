package com.vijay.online_examination_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vijay.online_examination_system.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByName(String name);

	Admin findByNameAndPassword(String name, String password);
}