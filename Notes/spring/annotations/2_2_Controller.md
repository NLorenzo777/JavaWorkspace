# `@Controller` Annotation [↑](../../../README.md#iii-spring-annotations)
- Used to mark a class as a controller in a Spring MVC application.
- Controllers are responsible for handling incoming web requests, processing, and returning the appropriate response.

## Key Points about @Controller
- Typically used in combination with `@RequestMapping` annotation to map web requests to specific handler methods.
- It can only be applied to classes.
- It is part of the Spring MVC framework and is used to create web controllers.
- Allows the Spring framework to detect the class as a controller during component scanning.

## Implementation

#### Add the spring-web dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

#### Create a Controller class in a Controller package

```java
// Java Program to Illustrate DemoController File

// Importing package in this code module
package com.example.demo.controller;
// Importing required classes
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Annotation
@Controller
// Main class
public class DemoController {

    @RequestMapping("/hello")
    @ResponseBody

    // Method
    public String helloGFG()
    {
        return "Hello GeeksForGeeks";
    }
}
```
- `@ResponseBody` ensures the returned value is sent as an HTTP response instead of resolving a view name.

