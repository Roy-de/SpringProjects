package com.example.demo1;

public class Tyres {
    String name;
    String place;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    @Override
    public String toString(){
        return "this is tyre object:" + name +" "+ place + " "+ message;
    }
}
