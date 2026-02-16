package com.example.jdbcdemo.controller;

import com.example.jdbcdemo.dao.StudentDaoImpl;
import com.example.jdbcdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class API {

    @Autowired
    StudentDaoImpl studentDao;

    @GetMapping("/")
    public String greetings() {
        return "Hello, Welcome to the sample Student Repository";
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentDao.getStudentById(id);
    }

    @PostMapping("/add/student")
    public void registerStudent(@RequestBody Student student) {
        studentDao.createStudent(student);
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return studentDao.getAllStudent();
    }
}
