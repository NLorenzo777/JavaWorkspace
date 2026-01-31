# Spring JDBC Introduction [↑](../../../README.md#spring-framework)
Java Database Connectivity (JDBC) is an API that defines how a client may access a database.
- It is a data access technology used for Java database connectivity. 
- It provides methods to query and update data in a database 
- is oriented toward relational databases.
- Provides a natural Java interface for working with SQL.

## JDBC Drivers
JDBC API uses JDBC drivers to connect with the database.

1. **JDBC-ODBC Bridge Driver:** Connects to databases via ODBC driver. It is a platform-dependent and not recommended for production use.
2. **Native API Driver:** Uses the database's native API for communication. It is partially written in Java and platform-dependent.
3. **Network Protocol Driver:** A fully Java-based driver that uses middleware to communicate with the database.
4. **Thin Driver:** A fully Java-based driver that communicates directly with the database using its network protocol. It is the most commonly used driver.

## Advantages/Disadvantages
| Advantages                                                             | Disadvantages                                                                                                                                               |
|------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Helps retrieve and manipulate data from the database efficiently       | Writing a lot of codes before and after executing the query such as creating connection, creating a statement, closing result-set, closing connection, etc. |
| Supports query and stored procedures                                   | Writing exception handling code on the database logic                                                                                                       |
| Almost any database for which ODBC driver is installed can be accessed | Repetition of these codes from one to another database logic is time-consuming                                                                              |

## The Spring JDBC-Template
The problems of JDBC API are eliminated by Spring JDBC-Template. It provides methods to write the queries directly that saves a lot of time and effort.

There are number of options for selecting an approach to form the basis for JDBC database access.
Spring framework provides the following approaches for JDBC database access.

1. `JdbcTemplate`
2. `NamedParameterJdbcTemplate`
3. `SimpleJdbcTemplate`
4. `SimpleJdbcInsert` and `SimpleJdbcCall`

### The JDBC Template
`JdbcTemplate` is a central class in the JDBC core package that simplifies the use of JDBC and helps to avoid common errors.

- It internally uses JDBC API and eliminates a lot of problems with JDBC API.
- It executes SQL queries or updates, initiating iteration over ResultSets and catching JDBC exceptions and translating them to the generic.
- It executes core JDBC workflow, leaving application code to provide SQL and extract results.
- It handles the exception and provides the informative exception messages with the help of exception classes defined in the **org.springframework.dao** package.

#### Common Methods of spring JdbcTemplate class
1. `public int update(String query)`: Used to insert, update and delete records.
2. `public int update(String query, Object... args)`: Used to insert, update and delete records using **PreparedStatement** using given arguments.
3. `public T execute(String sql, PreparedStatementCallback action)`: Executes the query by using `PreparedStatementCallback`.
4. `public void execute(String query)`: Used to execute **DDL** query. 
5. `public T query(String sql, ResultSetExtractor result)`: Used to fetch records using **ResultSetExtractor**.

### JDBC Template Queries

#### 1. Counting Records
Basic query to count students stored in the database using JdbcTemplate
```java
int count = jdbcTemplate.queryForObject(
        "SELECT COUNT(*) FROM STUDENT", Integer.class
);
```

#### 2. Inserting a Record
Basic query to insert elements into the database.
```java
public int addStudent(int id, String name, String country) {
    return jdbcTemplate.update(
            "INSERT INTO STUDENT(id, name, country) VALUES(?, ?, ?)", id, name, country
    );
}
```
The standard syntax of providing parameters is using the "?" character.

### 3. Fetching Records
Basic query to fetch records from the database.
```java
public List<Student> getAllStudents() {
    return jdbcTemplate(
            "SELECT * FROM STUDENT",
            new BeanPropertyRowMapper<>(Student.class)
    );
}

```

## Sample Implementation
Below is a sample implementation of a JDBC project with MySQL as a database.

#### 1. Update the pom.xml with the database dependency

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```

#### 2. Configure the Data Source
This is done by configuring the dataSource and JdbcTemplate in a Spring configuration class.

```java
@Configuration
@ComponentScan("com.exploit.jdbc")
public class SpringJdbcConfig {

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        // Correct MySQL driver class for MySQL 8.x
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        // Correct URL with default MySQL port and timezone configuration
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc?serverTimezone=UTC");
        
        // Use environment variables or externalized configuration for credentials
        // Replace with actual username
        dataSource.setUsername("user");
        // Replace with actual password
        dataSource.setPassword("password"); 

        return dataSource;
    }
}
```

#### 3. Create the Model Class

```java
// Java Program to Illustrate Student Class

package com.exploit.org;

import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations to generate getters, setters, toString, equals, and hashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    // Class data members
    private Integer id;
    private String name;
    private Integer age;
}
```

#### 4. Create the DAO Interface
```java
// Java Program to Illustrate StudentDAO Class

package com.exploit.org;

// Importing required classes
import java.util.List;
import org.springframework.dao.DataAccessException;

// Interface
public interface StudentDAO {

    // Create: Insert a new student record
    void createStudent(Student student) throws DataAccessException;

    // Read: Retrieve a student by ID
    Student getStudentById(Integer id) throws DataAccessException;

    // Read: List all students
    List<Student> listStudents() throws DataAccessException;

    // Update: Update an existing student record
    void updateStudent(Student student) throws DataAccessException;

    // Delete: Delete a student by ID
    void deleteStudent(Integer id) throws DataAccessException;
}
```

#### 5. Sample Main Implementation of Repository

```java
package com.exploit.org;

// Importing required classes
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper to map result set to Student object
    private final RowMapper<Student> rowMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    };

    @Override
    public void createStudent(Student student) throws DataAccessException {
        String sql = "INSERT INTO Student (id, name, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge());
    }

    @Override
    public Student getStudentById(Integer id) throws DataAccessException {
        String sql = "SELECT * FROM Student WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Student> listStudents() throws DataAccessException {
        String sql = "SELECT * FROM Student";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void updateStudent(Student student) throws DataAccessException {
        String sql = "UPDATE Student SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public void deleteStudent(Integer id) throws DataAccessException {
        String sql = "DELETE FROM Student WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
```