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

```