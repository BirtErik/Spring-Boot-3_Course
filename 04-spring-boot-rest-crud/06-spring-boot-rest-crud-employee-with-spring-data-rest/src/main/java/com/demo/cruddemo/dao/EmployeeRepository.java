package com.demo.cruddemo.dao;

import com.demo.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Employee is a class and Integer is a primary key type
    //No need to write any code
    //Gives basic methods
}
