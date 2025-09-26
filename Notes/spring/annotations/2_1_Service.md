# `@Service` Annotation [↑](../../../README.md#iii-spring-annotations)
- Used to indicate that a class belongs to the service layer in the application.
  - The **Service Layer** usually contains the business logic of the application.
- A specialization of the `@Component` annotation. Meaning, they are already detected during classpath scanning.

## Key Points
- It is used to mark a class as a service provider.
- It is applied only to classes.
- It is part of the stereotype annotations in Spring (along with Controller, Repository, and Component)

## Sample Implementation

#### Add Spring Context Dependency
Add the spring-context dependency in the `pom.xml` file.
```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <!-- Use the latest version compatible with your Spring Boot version -->
  <version>5.3.13</version>
</dependency>
```

#### Create a Service Package and store the Service classes

```java
// Java Program to Illustrate MyServiceClass

// Importing package module to code module
package com.example.demo.service;
// Importing required classes
import org.springframework.stereotype.Service;

// Annotation
@Service

// Class - Service that will contain the business logic
public class MyServiceClass {

	// Method
	// To compute factorial
	public int factorial(int n)
	{
		// Base case
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}
}
```

#### Main application

```java
// Java Program to Illustrate DemoApplication

// Importing package module to code fragment
package com.example.demo;
// Importing required classes
import com.example.demo.service.MyServiceClass;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Annotation
@SpringBootApplication

// Main class
public class DemoApplication {

	// MAin driver method
	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext();
		context.scan("com.example.demo");

		context.refresh();

		MyServiceClass myServiceClass
			= context.getBean(MyServiceClass.class);

		// Testing the factorial method
		int factorialOf5 = myServiceClass.factorial(5);
		System.out.println("Factorial of 5 is: "
						+ factorialOf5);

		// Closing the spring context
		// using close() method
		context.close();
	}
}
```

#### Note:
If the `@Service` annotation is not used, the following exception will be encountered

```text
Exception in thread “main” org.springframework.beans.factory.NoSuchBeanDefinitionException: 
No qualifying bean of type ‘com.example.demo.service.MyServiceClass’ available
at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:351)
at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:342)
at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1172)
at com.example.demo.DemoApplication.main(DemoApplication.java:17)

```
