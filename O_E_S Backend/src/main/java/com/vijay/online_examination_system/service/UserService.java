//package com.vijay.online_examination_system.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.vijay.online_examination_system.Repository.UserRepository;
//import com.vijay.online_examination_system.model.User;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public User registerUser(User user) throws Exception {
//        if (userRepository.findById(user.getName()) != null) {
//            throw new Exception("Username already exists");
//        }
//        if (userRepository.findByEmail(user.getEmail()) != null) {
//            throw new Exception("Email already exists");
//        }
//        return userRepository.save(user);
//    }
//}
