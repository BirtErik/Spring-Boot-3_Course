package com.demo.cruddemo.service;

import com.demo.cruddemo.dao.EmployeeRepository;
import com.demo.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //Java "Optional" check out
    @Override
    public Employee findById(int id) {
        Optional<Employee> resault = employeeRepository.findById(id);
        Employee theEmoployee = null;

        if(resault.isPresent()){
            theEmoployee = resault.get();
        }else {
            throw new RuntimeException("Did not find employe id - " + id);
        }
        return theEmoployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
