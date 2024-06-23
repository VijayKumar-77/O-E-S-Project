package com.vijay.online_examination_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.online_examination_system.DTO.AdminLoginDTO;
import com.vijay.online_examination_system.Repository.AdminRepository;
import com.vijay.online_examination_system.model.Admin;


@RestController
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository ;
	
	// get admin detail by admin_name
	
	@GetMapping("/admin/{name}")
    public ResponseEntity<Object> getAdminDetails(@PathVariable("name") String name) {
        Admin admin = adminRepository.findByName(name);
        if (admin != null) {
        	 return ResponseEntity.status(HttpStatus.CREATED).body("Admin Found successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Admin not found with name: " + name);
        }
	}
    //admin registration
	
	@PostMapping("/admin/register")
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
	    Admin existingAdmin = adminRepository.findByName(admin.getName());
	    if (existingAdmin != null) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin with this Username already exists.");
	    }
	    if (admin.getName() == null || admin.getName().isEmpty() ||
	        admin.getPassword() == null || admin.getPassword().isEmpty()) {
	        return ResponseEntity.badRequest().body("Admin name and password are required.");
	    }	    
	    adminRepository.save(admin);
	    return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully.");
	}

  // admin login
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> loginAdmin(@RequestBody AdminLoginDTO loginDTO) {
	    Admin admin = adminRepository.findByNameAndPassword(loginDTO.getName(), loginDTO.getPassword());
	    if (admin != null) {
	        return ResponseEntity.ok("Login successful");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin name or password");
	    }
	}
}