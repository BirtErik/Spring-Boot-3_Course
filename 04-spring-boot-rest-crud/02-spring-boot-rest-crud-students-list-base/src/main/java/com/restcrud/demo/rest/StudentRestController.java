package com.restcrud.demo.rest;

import com.restcrud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();

        studentList.add(new Student("Erik", "Birt"));
        studentList.add(new Student("Ericius", "User2"));
        studentList.add(new Student("Blueee", "User3"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return studentList.get(studentId);
    }
}
