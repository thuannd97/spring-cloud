package com.thuannd.securityoauth2.utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class Utilities {

    public static void main(String[] args) {
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123"));
    }

}