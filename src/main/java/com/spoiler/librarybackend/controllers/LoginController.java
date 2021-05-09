package com.spoiler.librarybackend.controllers;


import com.spoiler.librarybackend.model.Login;
import com.spoiler.librarybackend.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    private static final String DUPLICATE_USER = "Duplicate username found";
    private static final String USER_ADDED = "User added successfully";
    @Autowired
    LoginRepository loginRepository;

    @PostMapping("/")
    public Boolean checkLogin(@RequestBody Login login){
        return loginRepository.findByUsernameAndPassword(login.getUsername(),login.getPassword()).isPresent();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addLogin(@RequestBody Login login){
        if(loginRepository.findByUsername(login.getUsername()).isPresent()){
            return ResponseEntity.of(Optional.of(DUPLICATE_USER));
        }
        else {
            loginRepository.save(login);
            return ResponseEntity.of(Optional.of(USER_ADDED));
        }
    }
}
