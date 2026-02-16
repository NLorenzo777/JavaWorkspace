package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.model.Student;
import org.springframework.dao.DataAccessException;
import java.util.List;

public interface StudentDao {

    //Create
    void createStudent(Student student) throws DataAccessException;

    //Read
    Student getStudentById(Integer id) throws DataAccessException;
    List<Student> getAllStudent() throws DataAccessException;

    //Update
    void updateStudent(Student student) throws DataAccessException;

    //Delete
    void deleteStudentById(Integer id) throws DataAccessException;
}
