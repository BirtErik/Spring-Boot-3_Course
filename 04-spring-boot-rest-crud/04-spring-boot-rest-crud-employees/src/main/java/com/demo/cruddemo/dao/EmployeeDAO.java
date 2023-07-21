package com.demo.cruddemo.dao;

import com.demo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    //Employee findOne(int id);

}
