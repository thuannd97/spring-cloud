package com.thuannd.oauth2.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utilities {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("password: " + encoder.encode("123"));
    }

}