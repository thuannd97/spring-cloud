package com.thuannd.erm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/erm")
public class DashboardController{

    @GetMapping("/quan-tri")
    public String dashboard(){
        return "admin/dashboard/dashboard.html";
    }

}