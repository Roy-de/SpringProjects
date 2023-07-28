package com.example.security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
    @GetMapping("/user")
    public String user(){
        return "hello User";
    }
    @GetMapping("/admin")
    @Deprecated(since = "2.7",forRemoval = true)
    public String admin(){
        return "Hello Admin";
    }
}
