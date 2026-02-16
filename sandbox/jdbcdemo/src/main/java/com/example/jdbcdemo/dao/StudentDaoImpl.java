package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final RowMapper<Student> rowMapper = (rs, rowNum) -> new Student(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("age")
    );

    @Override
    public void createStudent(Student student) throws DataAccessException {
        String statement = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(statement, student.getId(), student.getName(), student.getAge());
    }

    @Override
    public Student getStudentById(Integer id) throws DataAccessException {
        String statement = "SELECT FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(statement, rowMapper, id);
    }

    @Override
    public List<Student> getAllStudent() throws DataAccessException {
        String statement = "SELECT * FROM students";
        return jdbcTemplate.query(statement, rowMapper);
    }

    @Override
    public void updateStudent(Student student) throws DataAccessException {
        String statement = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(statement, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public void deleteStudentById(Integer id) throws DataAccessException {
        String statement = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(statement, id);
    }
}
