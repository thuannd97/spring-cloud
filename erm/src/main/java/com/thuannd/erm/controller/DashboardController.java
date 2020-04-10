package com.thuannd.erm.controller;

import com.thuannd.erm.model.ResponseDTO;
import com.thuannd.erm.model.UserRoleDTO;
import com.thuannd.erm.services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/erm")
public class DashboardController{

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/quan-tri")
    public String dashboard(){
        return "admin/dashboard/dashboard";
    }

    @GetMapping("/nguoi-dung")
    public ResponseEntity<ResponseDTO> findAllUser() {
        ResponseDTO responseDTO = new ResponseDTO<UserRoleDTO>(userRoleService.findAllRoleUser(), userRoleService.countRoleUser());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}