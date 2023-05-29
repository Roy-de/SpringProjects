package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("Bean.xml");
        Student student =  context.getBean("studentbean",Student.class);
//        MathCheat mathCheat = context.getBean("mathcheat",MathCheat.class);
//        mathCheat.mathCheating();
        student.cheating();
    }

}
