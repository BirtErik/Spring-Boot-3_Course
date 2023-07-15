package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
