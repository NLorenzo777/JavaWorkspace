# Introduction to Spring Aspect Oriented Programming [↑](../../../README.md#spring-framework)
Spring AOP is a programming technique in the Spring Framework that helps separate cross-cutting concerns (logging, security, transactions)
from the main business logic.

Instead of adding logic inside every class, AOP allows to write it once and apply it wherever needed.

AOP can be defined as the breaking of code into different modules (modularization) where the aspect is the key unit of modularity.

In Spring, AOP works using proxies and developers can define behaviors using annotations like `@Aspect`, `@Before`, 
`@After`, and `@Around`. This keeps code clean, modular and easier to maintain by focusing only on the core business
functionality while AOP handles the repetitive system-level tasks behind the scenes.

## Concepts

### 1. Aspect
An Aspect is a modular unit of cross-cutting concerns. For example, a logging aspect can be applied across various
methods in different classes.

### 2. Advice
This is the action taken by an aspect at a particular join point.

#### 5 Types of Advice
1. **Before**: Executed before the method call.
2. **After**: Executed after the method call, regardless of its outcome.
3. **AfterReturning**: Executed after the method returns a result, but not if an exception occurs.
4. **Around**: Surrounds the method execution, allowing the developer to control the method execution and its result.
5. **AfterThrowing**: Executed if the method throws an exception.

### 3. Join Point
A specific point in the execution of the program, such as method execution or exception handling, where an aspect can be applied.

### 4. Pointcut
A Pointcut is a predicate that defines where advice should be applied. It matches join points using expressions.

### 5. Weaving
Process of linking aspects with the target object. Spring AOP only supports runtime weaving using proxy-based mechanisms.
It does not modify bytecode like AspectJ.

### Dominant AOP Frameworks
1. **AspectJ**: Powerful and mature AOP framework that supports compile-time and load-time weaving. It offers full AOP support
with its own syntax and tools.
2. **JBoss**: Part of the JBoss application server, offering integration with Java EE applications.
3. **Spring AOP**: A simpler, proxy-based framework that integrates with the Spring framework, using XML configurations and
annotations to define aspects and pointcuts.

## Sample Implementations
Implementing logging with AOP in Spring Aspect Class with different types of advice.
```java
package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public void com.example.service.*.*(..))")
    public void allServiceMethods() {}

    @Before("allServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @After("allServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "allServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "allServiceMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("Method threw exception: " + error);
    }

    @Around("allServiceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before and after method: " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
```

### Configurations
Enable AOP by configuring the Spring application context appropriately.

#### Java-Based Configuration
```java
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    
}
```

#### XML Configuration
```xml
<beans xmlns="http://www.springframework.org/schema/beans//"
       xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop//"
       xsi:schemaLocation="http://www.springframework.org/schema/beans//
           http://www.springframework.org/schema/beans///spring-beans.xsd
           http://www.springframework.org/schema/aop//
           http://www.springframework.org/schema/aop///spring-aop.xsd">

    <aop:aspectj-autoproxy/>
    
    <bean id="loggingAspect" class="com.example.aspect.LoggingAspect"/>

</beans>
```
