# Spring Boot Introduction
- Underlying technology powering the Spring framework.
- Spring Boot is a collection of tools that extends the Spring framework and makes it easier to build applications quickly.

## Spring Boot Starters
- Dependencies to run the application.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

- The `spring-boot-starter-web` dependency instructs Spring Boot to configure Tomcat for running a server and Spring MVC (Model-View-Controller) for routing HTTP requests.
- The `spring-boot-starter-data-jpa` sets up JPA and Hibernate for database access.
- There are other starters like `spring-boot-starter-test` which includes common testing libraries such as JUnit Jupiter, Hamcrest, and Mockito.
- There is also `spring-boot-starter-parent` which provides the `spring-boot:run` command.

## Auto-Configuration
- The dependencies indicated in the pom.xml are hooked into the application using the `@SpringBootApplication` annotation from the `org.springframework.boot` package.

```java
package com.codecademy.springcap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCapstoneApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCapstoneApplication.class, args);
  }

}
```

### Spring Application
- The `SpringApplication` class is responsible for starting up the Spring IoC container to configure the beans.
- This can be seen at the line:

```text
........ Initializing Spring embedded WebApplicationContext
```

- In Java, the IoC container is represented by an _application context_.
- The **application context** is the thing that received beans and enables Spring to inject them into other components.
- In Java, application context appears as a `ApplicationContext` interface.


## The `@SpringBootApplication`
- This annotation enables Spring Boot to review dependencies (such as `spring-boot-starter-jpa` and `h2`) and assume the intended purpose of the application.


## Custom Configuration with application.properties

