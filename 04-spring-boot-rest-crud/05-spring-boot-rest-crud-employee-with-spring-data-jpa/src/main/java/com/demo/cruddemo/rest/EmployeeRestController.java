package com.demo.cruddemo.rest;

import com.demo.cruddemo.entity.Employee;
import com.demo.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    private List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    private Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    private Employee addEmployee(@RequestBody Employee employee){
        //Just in case they pass an id in JSON ... set id to 0
        //This is to force a save of new item ... instead of update

        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    private Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    private String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.delete(employeeId);

        return "Deleted employee of - " + employeeId;
    }

}
