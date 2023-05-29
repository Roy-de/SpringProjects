package com.example.demo1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Vehicle {

    //Constructor in dependency injection
    IEngine engine;
    Tyres tyres;

    public static Vehicle createVehicle(IEngine engine, Tyres tyres) {
        return new Vehicle(engine, tyres);
    }

    public void setEngine(IEngine engine) {
        System.out.println("Engine instantiated via setter");
        this.engine = engine;
    }

    public void setTyres(Tyres tyres) {
        System.out.println("tyre instantiated via setter");
        this.tyres = tyres;
    }

    public IEngine getEngine() {
        return engine;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Vehicle(IEngine engine, Tyres tyres){
        System.out.println("instantiated via constructor");
        this.engine = engine;
        this.tyres = tyres;
    }
    public Vehicle(){}

    @Override
    public String toString(){
        return engine + " " + tyres;
    }
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        //Instantiating object 1 via constructor DI
        Vehicle obj1 = (Vehicle) context.getBean("InjectwithConstructor");

        Vehicle obj2 = (Vehicle) context.getBean("InjectwithSetter");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1==obj2);
    }



}
