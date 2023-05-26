package com.example.demo1;

public class ToyotaEngine implements IEngine{
    String company;
    double cost;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCompany() {
        return company;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String ImportOrigin() {
        return "This is Engine object from:" + company;
    }

    @Override
    public double cost() {
        return cost;
    }
}
