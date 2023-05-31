package com.example.securitydemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/welcome")
    public String Welocme(){
        return "Welcome";
    }
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
}
