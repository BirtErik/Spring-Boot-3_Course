package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();

    Student findByLastName(String lastName);
}
