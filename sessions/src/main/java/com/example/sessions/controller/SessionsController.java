package com.example.sessions.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SessionsController {
    @PostMapping("/login")
    public String login(HttpSession session, String username){
        session.setAttribute("username",username);
        return "Logged in successfully!";
    }
    @GetMapping("/home")
    public String home(HttpSession session) {
        // Retrieve the username from the session
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return "Welcome, " + username + "!";
        } else {
            return "You are not logged in!";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Remove the username from the session
        session.removeAttribute("username");
        return "Logged out successfully!";
    }
}
