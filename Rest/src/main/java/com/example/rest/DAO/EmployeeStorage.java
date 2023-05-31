package com.example.rest.DAO;

import com.example.rest.Entity.Employee;

import java.util.ArrayList;
import java.util.List;

//Class to store the list of all employees
public class EmployeeStorage {
    List<Employee> employeeList;

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    //Method to return the list
    public List<Employee> getEmployeeList(){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
}
