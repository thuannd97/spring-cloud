package com.thuannd.oauth2.controller;

import java.security.Principal;
import java.util.List;

import com.thuannd.oauth2.dao.UserDAO;
import com.thuannd.oauth2.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userDAO.findAll();
    }

}