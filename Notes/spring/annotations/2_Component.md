# `@Component` Annotation [↑](../../../README.md#iii-spring-annotations)
- Class-level annotation used to mark a class as a Spring-managed bean.
- When Spring scans the application, it detects classes annotated and registers them as beans in the Spring IoC container.

## Specializations of `@Component`
The following annotations are specialization of the `@Component` annotation, meaning they inherit its functionality but provide additional semantics for specific roles.

- `@Service` - for service-layer classes that contains the business logic.
- `@Repository` - for data access objects (DAOs) or classes that interacts with databases
- `@Controller` - for web controllers that handle user requests and return responses.

## Implementation

```java
// Java Program to Illustrate Component class
package com.example.demo;

import org.springframework.stereotype.Component;

// Annotation
@Component

// Class
public class ComponentDemo {

    // Method
    public void demoFunction()
    {

        // Print statement when method is called
        System.out.println("Hello World");
    }
}
```

```java
// Java Program to Illustrate Application class

// Importing package here
package com.example.demo;
// Importing required classes
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Annotation
@SpringBootApplication

// Class
public class DemoApplication {

    // Main driver method
    public static void main(String[] args)
    {

        // Annotation based spring context
        AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo");
        context.refresh();

        // Getting the Bean from the component class
        ComponentDemo componentDemo
            = context.getBean(ComponentDemo.class);
        componentDemo.demoFunction();

        // Closing the context
        // using close() method
        context.close();
    }
}
```
