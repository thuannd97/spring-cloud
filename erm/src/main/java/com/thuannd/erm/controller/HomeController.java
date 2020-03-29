package com.thuannd.erm.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/erm")
public class HomeController{

    @GetMapping("/trang-chu")
    public String home(){
        return "client/user/login";
    }

    @GetMapping("/dang-nhap")
    public String login(@RequestParam(name = "e", required = false) String err, Model model){
        if(isLogin()){
            return "redirect:/erm/quan-tri";
        }
        if (err != null) {
			model.addAttribute("msg", "login failed");
			System.out.println("login failed!");
		}
        return "client/user/login";
    }

    public boolean isLogin() {
		return SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
	}

}