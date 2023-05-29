package com.example.demo;

public class Stat {
    //private static instance
    public static final Stat stat =  new Stat();
    //Private constructor
    private Stat(){}
    //method to return above instance
    public static Stat getStat(){
        return stat;
    }
    //check dependency injection
    public void Statmessage(){
        System.out.println("Dependency Injected");
    }
}
