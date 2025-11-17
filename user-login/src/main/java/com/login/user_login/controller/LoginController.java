package com.login.user_login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/")
    public String welcome(){
        return "Welcome To Spring Security , You have logged in using the user login credentials from the MySQL DB";
    }
}
