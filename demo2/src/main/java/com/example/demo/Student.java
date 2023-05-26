package com.example.demo;

public class Student {
    //Class data members
    private String id;

    public Student(String id, MathCheat mathcheat) {
        this.id = id;
        this.mathcheat = mathcheat;
    }

    private MathCheat mathcheat;
    //Method
    public void cheating(){
        System.out.println("My ID is:" + id);
        mathcheat.mathCheating();
    }
}