package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo4Application {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Stat stat = (Stat)context.getBean("StatId");
        stat.Statmessage();

    }

}
