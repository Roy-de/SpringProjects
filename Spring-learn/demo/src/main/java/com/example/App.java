package com.example;

import com.example.inst.Sim;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Sim sim = applicationContext.getBean("Sim", Sim.class);

        System.out.println(sim.call());
    
    }
}