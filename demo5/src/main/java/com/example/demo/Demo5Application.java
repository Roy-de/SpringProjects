package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo5Application {

    public static void main(String[] args) {

        ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
        Student student = (Student) context.getBean("student");
        String [] beannames =  context.getBeanDefinitionNames();

        for(String beanname: beannames){
            System.out.println(beanname);
        }
    }

}
