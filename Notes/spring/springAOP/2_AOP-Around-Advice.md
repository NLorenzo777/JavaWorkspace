# Spring AOP Around Advice [↑](../../../README.md#spring-framework)
- Around advice is the strongest advice among all the advice since it runs around a matched method execution. For example,
before and after the advised method.
- It can choose whether to proceed to the join point or to bypass join point by returning its own return value or throwing exception.
- This type of advice is used where we need frequent access to a method or database like caching or to share state before and after a method execution
in a thread-safe manner (for example, starting and stopping a timer)
- Denoted by the `@Around` annotation. The advice method requires special parameters.
  1. Type `ProceedingJoinPoint` where the `.proceed()` method is called to execute the joint point method.
  2. Array of Object 

## Sample Implementation

### 1. Setup dependencies

```xml
<dependencies>
  <!-- dependency for spring web -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <!-- added dependency for spring aop -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
  </dependency>
</dependencies>
```

### 2. Model Class

```java
@Entity
public class Student {
    private String firstName;
    private String secondName;
    
    //Getters, Setters, constructors
}
```

### 3. Service Class
```java
// Annotation
@Service
// Class
public class StudentService {

    // Method
    public Student addStudent(String fname, String sname)
    {
        // Printing name of corresponding student
        System.out.println(
            "Add student service method called, firstname: "
            + fname + " secondname: " + sname);

        Student stud = new Student();
        stud.setFirstName(fname);
        stud.setSecondName(sname);

        // If first name i lesser than 4 words
        //  display below command
        if (fname.length() <= 3)
            throw new RuntimeException(
                "Length of firstname must be 4 or more");

        return stud;
    }
}
```

### 4. Controller Class
```java
// Java Program to Illustrate StudentController Class

package com.around_advice.controller;

// Importing required classes
import com.around_advice.model.Student;
import com.around_advice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
// Class
public class StudentController {

    @Autowired private StudentService studentService;

    @PostMapping(value = "/add")
    public Student addStudent(
        @RequestParam("firstName") String firstName,
        @RequestParam("secondName") String secondName)
    {
        return studentService.addStudent(firstName,
                                         secondName);
    }
}
```

### 5. Aspect Class
```java
package com.around_advice.aspect;

// Importing required classes
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Annotation
@Aspect
@Component
// Class
public class StudentServiceAspect {

    // pointcut expression specifying execution
    // of any method in class of any return type
    // with 0 or more number of arguments

    @Pointcut(
        "execution(* com.around_advice.service.StudentService.*(..)) ")

    // pointcut signature
    private void
    anyStudentService()
    {
    }

    @Around("anyStudentService() && args(fname, sname)")

    // Method
    public Object
    beforeAdvice(ProceedingJoinPoint proceedingJoinPoint,
                 String fname, String sname)
        throws Throwable
    {
        // Print statements
        System.out.println(
            "Around method:"
            + proceedingJoinPoint.getSignature());
        System.out.println(
            "Before calling joint point service method");

        Object stud = proceedingJoinPoint.proceed();

        // Print statement
        System.out.println(
            "After calling joint point service method ");

        return stud;
    }
}
```