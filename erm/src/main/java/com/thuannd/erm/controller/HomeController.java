package com.thuannd.erm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{

    @GetMapping("/trang-chu")
    public String home(){
        return "client/home";
    }

}