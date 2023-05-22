package com.example.login.controller;

import org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class authcontroller {

    //Handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
}
/*This above code defines a Spring MVC controller class
called AuthController that handles incoming requests to the
/index URL path. The @Controller annotation indicates that this class
is a Spring MVC controller and should be scanned by the Spring framework
for handling incoming requests.*/