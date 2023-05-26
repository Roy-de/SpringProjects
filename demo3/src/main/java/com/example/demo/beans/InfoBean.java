package com.example.demo.beans;
import java.util.Map;
public class InfoBean {
    private String name;
    private String message;
    private Map<String,String> frameworks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(Map<String, String> frameworks) {
        this.frameworks = frameworks;
    }

    public void display(){
        System.out.println("Hi" + name + ", " + message);
        System.out.println("Framework Names: Description");
        for(Map.Entry<String, String>entry: frameworks.entrySet())
            System.out.println(entry.getKey()+": " + entry.getValue());
    }
}
