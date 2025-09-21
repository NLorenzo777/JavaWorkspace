# Introduction to Spring Framework [↑](../../../README.md#spring-framework)

- [I. Key Features](#key-features-of-spring-framework-)
- [II. Concepts](#concepts-of-spring-framework-)
  - [Dependency Injection](#1-dependency-injection-)
  - [IoC Containers](#2-inversion-of-control-ioc-container-)
  - [Annotations](#3-spring-annotations-)
- [III. Modules](#spring-framework-modules-)
- [IV. Comparison](#spring---jee---hibernate-)
- [V. Miscellany](#how-spring-web-application-works-)

## Introduction [↑](#introduction-to-spring-framework-)
- Spring is an open-source Java framework that is useful for building RESTful web applications.
- Spring focuses on project "scaffolding" so that developers can concentrate on the core logic of applications.
- Contains templates for many different kinds of applications
  - **Spring Cloud**
  - **Spring Web Services**
  - **Spring Security**
  - **Spring Boot**
  - etc.

## Benefits of using Spring [↑](#introduction-to-spring-framework-)
- **Simplified Development:** Reduces boilerplate code with features like Dependency Injection and AOP.
- **Loose Coupling**: Dependency injections ensures components are loosely coupled.
- **Modular:** Spring's modular architecture allows the use of only the required components, improving flexibility and testability.
- **Integration Support:** Spring provides built-in support for various technologies like JDBC, JMS, and JPA.
- **Scalability**

## Key Features of Spring Framework [↑](#introduction-to-spring-framework-)

1. **Dependency Injection**
   - A design pattern where the Spring container automatically provides the required dependencies to a class instead of the class creating them itself.
   - Promotes loose coupling, easier testing and better maintainability by decoupling the object creation and usage.
2. **Aspect-Oriented Programming (AOP)**
   - Separate cross-cutting concerns (such as logging, security, and transaction management) from the business logic.
3. **Transaction Management**
   - Consistent abstraction for managing transactions across various databases and message services.
4. **Spring MVC**
   - Powerful framework for building web applications that follow the Model-View-Controller pattern.
5. **Spring Security**
   - Provides comprehensive security features including authentication, authorization and protection against common vulnerabilities. 
6. **Spring Data**
   - Simplifies database access by providing easy-to-use abstractions for working with RDB and non-RDB.
7. **Spring Batch**
   - Framework in Spring for handling large-scale batch processing, such as reading, processing and writing data in bulk.
8. **Integration with Other Frameworks**
   - Spring integrates seamlessly with other technologies like Hibernate, JPA, JMS and more.

## Concepts of Spring Framework [↑](#introduction-to-spring-framework-)

### 1. Dependency Injection [↑](#introduction-to-spring-framework-)
- Design pattern used in software development to implement Inversion of Control.
- Allows class to receive its dependencies from an external source rather than creating them within the class.

#### Types of Dependency Injection

- **Constructor Injection:** The dependent object is provided to the class via its constructor. The dependencies are passed when an instance of the class is created.
- **Setter Injection:** The dependent object is provided to the class via a setter method after the class is instantiated.
- **Field Injection:** The dependent object is directly injected into the class through its fields without explicit constructor or setter methods. One example is via `@Autowired` annotations.

### 2. Inversion of Control (IoC) Container [↑](#introduction-to-spring-framework-)
- A design principle in Object-Oriented Programming (OOP).
- The control of object creation and dependency management is transferred from the application code to an external framework or container.
- Reduces complexity of managing dependencies manually and allows more modular and flexible code.

#### The BeanFactory IOC Container
- Simplest container and is used to create and manage beans.
- Initializes beans lazily (only when needed).
- Typically used for lightweight applications where the overhead of `ApplicationContext` is not required.

```java
Resource resouce = new ClassPathResource("beans.xml");
BeanFactory factory = new XmlBeanFactory(resource);
MyBean obj = (MyBean) factory.getBean("myBean");
```
- `ClassPathResource()` loads the beans.xml file from the classpath.
- `XmlBeanFactory` creates a basic IoC container using that XML.
- `getBean("myBean")` retrieves and creates the bean with ID _myBean_.

#### The ApplicationContext IOC Container
- An advanced container that extends BeanFactory and provides additional features like internationalization support, event propagation, and AOP support.
- Preferred mostly because of its enhanced features.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
MyBean obj = (MyBean) context.getBean("myBean");
```

### 3. Spring Annotations [↑](#introduction-to-spring-framework-)
- Are metadata used by the Spring Framework to define configuration, dependencies, and behavior directly in Java code.
- Allow Spring to automatically detect, create and manage beans at runtime using component scanning and reflection.
- Below are some common annotations that are key for managing Spring IoC container and defining dependencies:
  - `@Component:` Marks a class as a Spring bean allowing Spring to automatically detect and mange it during classpath scanning.
  - `@Autowired:` Automatically injects dependencies into a class. Can be used on fields, constructors, or methods allowing Spring to resolve and inject the required beans.
  - `@Bean:` Defines a Spring bean explicitly within a configuration class. This is used to create and configure beans that are not automatically detected by classpath scanning.
  - `@Configuration:` Indicates that a class contains bean definitions and acts as a source of bean configuration. It is used to mark a class as a configuration class that contains methods annotated by `@Bean` to define beans.

## Spring Framework Modules [↑](#introduction-to-spring-framework-)
The Spring framework consists of seven modules. These modules provide different platforms to develop different enterprise applications.

### 1. Spring Core Module:
- Core component providing the IoC container for managing beans and their dependencies.
- Includes the `BeanFactory` and `ApplicationContext` for object creation and dependency injection.

### 2. Spring AOP Module:
- Implements the AOP to handle cross-cutting concerns like transaction management, logging and monitoring, using aspects defined with the `@Aspect` annotation.

### 3. Spring ORM Module:
- Provides APIs for database interactions using ORM frameworks like JDO, Hibernate and iBatis.
- Simplifies transaction management and exception handling with DAO support.
- ORM stands for _Object Relational Mapping_

### 4. Spring Web MVC Module:
- Implements the MVC architecture to create web applications.
- Separates model and view components, routing requests through the `DispatcherServlet` to controller and views.

### 5. Spring DAO Module:
- Provides data access support through JDBC, Hibernate or JDO, offering an abstraction layer to simplify database interaction and transaction management.

### 6. Spring Application Context Module:
- Builds on the Core module.
- Offering enhanced features like internationalization, validation, event propagation and resource loading via the `ApplicationContext` interface,


## Spring - JEE - Hibernate [↑](#introduction-to-spring-framework-)

<img alt="img.png" align="center" src="Spring-JEE-Hibernate.png"/>


## How Spring Web Application works [↑](#introduction-to-spring-framework-)
1. Client sends a GET request to the Spring Web Server (the Spring application).
2. The server sends data request to the data store to retrieve the information requested by the client.
3. The data store sends the requested data back to the server, if available.
4. The server sends the data (HTTP Response) back to the client and displays it on the browser.

## Making GET requests with a web browser
- Done using the `@GetMapping` annotation.

## Making GET requests with Curl
- Curl is short for _Client for URLs_.
- A command line tool that allows to transfer data to and from a server. It supports multiple protocol including HTTP.


```shell
curl http://www.mypetclinic.com/dogs/
```

## Making POST requests with a web browser
- Done using the `@PostMapping` annotation.

## Making a POST requests with curl

```shell
curl -X POST -d "{\"name\":\"Charlie\", \"breed\":\"German Shepherd\"}" -H "Content-Type: application/json" http://www.mypetclinic.com/dogs/ 
```

- The `-X POST` tells the server that the client is making a POST request. Where `-x` is the curl parameter specifying the type of request method to use.
- The `-d` (short for `--data`) indicates to the server that the client is sending a new data to an existing application.
- The `-H "Content-Type: application/json` specifies that the data is sent in JSON format.
- Finally, the URL `http://www.mypetclinic.com/dogs/` tells the server where to send the new data.

-------------
