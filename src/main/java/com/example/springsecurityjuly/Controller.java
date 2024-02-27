package com.example.springsecurityjuly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    PersonRespository personRespository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/public")
    public String welcome() {
        return "Welcome to PUBLIC area";
    }

    @PostMapping("/public-add")
    public String addStudent(@RequestBody Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRespository.save(person);
        return "Student added";
    }

    @GetMapping("/admin-welcome")
    public String welcomeA() {
        return "Welcome to ADMIN area";
    }

    @GetMapping("/student-welcome")
    public String welcomeS() {
        return "Welcome to STUDENT area";
    }
}