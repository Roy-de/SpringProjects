package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "Student")
public class student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    //Map column name
    @Column(name = "FirstName", nullable = false)
    private String FirstName;
    @Column(name = "FLastName", nullable = false)
    private String LastName;
    @Column(name = "email", nullable = true)
    private String email;

    public student(){

    }

    public student(String FirstName, String LastName , String email){
        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
    }

    //Getters and setters
    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public String getEmail(){
        return email;
    }

    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

}