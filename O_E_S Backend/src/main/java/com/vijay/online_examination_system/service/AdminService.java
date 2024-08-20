package com.vijay.online_examination_system.service;

import com.vijay.online_examination_system.Repository.AdminRepository;
import com.vijay.online_examination_system.model.Admin;
//import com.vijay.online_examination_system.model.Teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin login(String name, String password) {
		return adminRepository.findByNameAndPassword(name, password);
	}

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}
}
