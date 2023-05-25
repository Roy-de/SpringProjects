package com.example.demo.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.studentservice;

@Service
public class studentserviceImpl implements studentservice{

    private final StudentRepository studentRepository;

    public studentserviceImpl(StudentRepository studentRepository){
        //super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<student> getAllStudents() {
        //this returns a list of all students 
        return studentRepository.findAll();
    }
    
}
