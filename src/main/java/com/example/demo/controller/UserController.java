package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initAdmin(){userService.createAdmin();}

    @PostMapping("/register")
    public void create(@RequestBody Map<String, String> body) {
        userService.createUser(body);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody Map<String, String> body) {
        userService.loginUser(body);
    }
}
