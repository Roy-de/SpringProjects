package com.example;

import com.example.inst.Sim;

public class Airtel implements Sim {

    @Override
    public String call() {
        return "Airtel calls";
    }

    @Override
    public String data() {
        return "Airtel data";
    }
    
}
