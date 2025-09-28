# `@Repository` Annotation [↑](../../../README.md#iii-spring-annotations)
- Specialization of the `@Component` annotation.
- Used to indicate that the class provides the mechanism for storage, retrieval, update, delete, and search operation on objects.
- Auto-detected by the spring framework through classpath scanning.
- General-purpose stereotype annotation that is very close to the [DAO Pattern](https://www.geeksforgeeks.org/system-design/data-access-object-pattern/) where DAO classes are responsible for providing CRUD operations on database tables.

## Key Points about @Repository Annotation
- It indicates that the class is a DAO or repository.
- The main purpose of this annotation is to interact with a database. It encapsulates the logic required to access and manipulate data.
- Provides exception translation.
  - Spring automatically translates data access exceptions (e.g. SQLException) into Spring's `DataAccessException` hierarchy.
- Can only be applied to classes, not methods or fields.

## Implementations

### Add the Spring-Context Dependency
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.13</version>
</dependency>
```

### Create the Entity Class
This is a POJO style class

```java
package com.example.demo.entity;

public class Student {

    private Long id;
    private String name;
    private int age;

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

#### Create a Repository Interface
before implementing the Repository class, a generic interface is required to define the contract for the repository class.

```java
// Java Program to illustrate DemoRepository File

package com.example.demo.repository;

public interface DemoRepository<T> {

    // Save method
    void save(T t);

    // Find a student by its id
    T findStudentById(Long id);

}
```

#### Create the implementing repository class

```java
// Java Program to illustrate StudentRepository File

package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository implements DemoRepository<Student> {

    // Using an in-memory Map
    // to store the object data
    private Map<Long, Student> repository;

    public StudentRepository() {
        this.repository = new HashMap<>();
    }

    // Implementation for save method
    @Override
    public void save(Student student) {
        repository.put(student.getId(), student);
    }

    // Implementation for findStudentById method
    @Override
    public Student findStudentById(Long id) {
        return repository.get(id);
    }
}
```

#### Test the Spring Repository
```java
package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo");
        context.refresh();

        StudentRepository repository = context.getBean(StudentRepository.class);

        // testing the store method
        repository.save(new Student(1L, "Anshul", 25));
        repository.save(new Student(2L, "Mayank", 23));

        // testing the retrieve method
        Student student = repository.findStudentById(1L);
        System.out.println(student);

        // close the spring context
        context.close();
    }

}
```