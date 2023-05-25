package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.studentservice;

@Controller
public class studentcontroller {
    
    private studentservice studentservice;

    public studentcontroller(studentservice studentservice){
        //super();
        this.studentservice = studentservice;
    }
    //handler method to handle list student request and return model and view
    
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("student", studentservice.getAllStudents());
        //The view that is to be returned is under templates 
        //it is student.html
        return "students";
    }
}
