package com.example.rest.DAO;

import com.example.rest.Entity.Employee;
import org.springframework.stereotype.Repository;

//This class is used access the employees
@Repository
public class EmployeeDAO {
    private static final EmployeeStorage list = new EmployeeStorage();
    //Static block is executed before the main block
    static {
        list.getEmployeeList().add(
                new Employee(
                        1,
                        "Roy Murithi",
                        "roymuri28@gmail.com"
                )
        );
        list.getEmployeeList().add(
          new Employee(
                  2,
                  "Ian Omengo",
                  "omengoian@gmail.com"
          )
        );
        list.getEmployeeList().add(
                new Employee(
                        3,
                        "Caleb Sawe",
                        "calebnureda@gmail.com"
                )
        );
    }
    public EmployeeStorage getAllEmplaoyees(){
        return list;
    }
    //Method to add an employee
    public void addEmployee(Employee employee){
        list.getEmployeeList().add(employee);
    }
}
