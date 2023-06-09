package com.example.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(@org.jetbrains.annotations.NotNull ModelMap model){
        model.addAllAttributes("message","Hello World");
        return "hello";
    }
}
