package com.thuannd.securityoauth2.controllers;

import java.util.List;

import com.thuannd.securityoauth2.entities.User;
import com.thuannd.securityoauth2.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/whoami")
    public String helloUser(@AuthenticationPrincipal(expression="username") String name){
        return "hello " + name;
    }

}