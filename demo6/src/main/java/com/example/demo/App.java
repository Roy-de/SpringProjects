package com.example.demo;

import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    public static void main(String[] args){
        Runnable childThread = ()->{
            Volunteer v1 = context.getBean(Volunteer.class);
            Volunteer v2 = context.getBean(Volunteer.class);
            System.out.println("Hashcode of two object created by child thread");
            System.out.println(v1.hashCode() + " & " + v2.hashCode());
            System.out.println("Is both objects created by child thread same ? :" + (v1.hashCode() == v2.hashCode()));
        };
        new Thread(childThread).start();
        Volunteer v1 = context.getBean(Volunteer.class);
        Volunteer v2 = context.getBean(Volunteer.class);
        System.out.println("Hashcode of two object created by main thread");
        System.out.println(v1.hashCode() + " & " + v2.hashCode());
        System.out.println("Is both objects created by main thread same ? :" + (v1.hashCode() == v2.hashCode()));
    }
}
