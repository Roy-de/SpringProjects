package com.example.rest.Controller;

import com.example.rest.DAO.EmployeeDAO;
import com.example.rest.DAO.EmployeeStorage;
import com.example.rest.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Entity/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "/Entity/Employee",produces = "/application/json")
    public EmployeeStorage getEmployees(){
        return employeeDAO.getAllEmplaoyees();
    }
    /*
    @PostMapping(path = "/Entity/Employee",consumes = "/application/json",produces = "/application/json")
    public ResponseEntity<Object> addEmployee(
            @RequestBody Employee employee
            ){
        //Creating an ID of an employee from the number of employees
        int id = employeeDAO.getAllEmplaoyees()
                .getEmployeeList().size() + 1;
        employee.setId(id);
        employeeDAO.addEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }*/
}
