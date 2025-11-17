package com.login.user_login.controller;

import com.login.user_login.entity.Users;
import com.login.user_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome To Spring Security , You have logged in using the user login credentials from the MySQL DB";
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }
}
