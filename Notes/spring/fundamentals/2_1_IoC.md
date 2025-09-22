# Inversion of Control (IoC) [↑](../../../README.md#spring-framework)

- [I. Introduction](#introduction)
- [II. Manual Dependency Injection](#step-3-calling-methods-without-spring-ioc-)
- [III. XML Based Dependency Injection](#step-4-using-spring-ioc-with-xml-configuration-)
- [IV. Java-Based Dependency Injection](#step-6-using-java-based-configuration-)
- [V. Annotation-Based Dependency Injection](#step-7-using-annotations-for-dependency-injection-)
  - [Fixing the `NoUniqueBeanDefinitionException`](#fixing-the-nouniquebeandefinitionexception-)
  - [Explicit Bean Names](#3-explicit-bean-names-)

## Introduction
- Spring IoC Container is the core of the Spring Framework.
- Creates and manages objects (beans), injects dependencies and manages their life cycles.
- Uses **Dependency Injection** based on configurations from **XML files**, **Java-based configuration**, **annotation** or POJOs.
- Since the container and not the developer controls the object creation and wiring, it is called Inversion of Control.

## Practical Example

### Step 1: Create the Sim Interface

```java
public interface Sim 
{
    void calling();
    void data();
}
```

### Step 2: Implement the Sim Interface

````java
public class Airtel implements Sim {
    @Override
    public void calling() {
        System.out.println("Airtel Calling");
    }

    @Override
    public void data() {
        System.out.println("Airtel Data");
    }
}

public class Jio implements Sim {
    @Override
    public void calling() {
        System.out.println("Jio Calling");
    }

    @Override
    public void data() {
        System.out.println("Jio Data");
    }
}
````

### Step 3: Calling Methods without Spring IoC [↑](#inversion-of-control-ioc-)
- Manual creation of instance in the main method.
- This approach tightly couples the Mobile class to the Jio

```java
public class Mobile {

    // Main driver method
    public static void main(String[] args)
    {
        // Manually creating an instance of Jio
        Sim sim = new Jio();

        // Calling methods
        sim.calling();
        sim.data();
    }
}
```

### Step 4: Using Spring IoC with XML Configuration [↑](#inversion-of-control-ioc-)
- To avoid tight coupling.

```xml beans.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans/"
       xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans/
       https://www.springframework.org/schema/beans/spring-beans.xsd">

  <!-- Define the Jio bean -->
    <bean id="sim" class="Jio"/>

</beans>
```
- The beans are defined by giving each a unique id and specifying the class name.
- This beans can then be used in the main method.
- **id:** is the name of the java field, **class** is the type.

### Step 5: Run the Code
The `ApplicationContext` class is used to retrieve the Bean.

```java
public class Mobile {
    
    
    public static void main(String[] args) {
        
        // Using ApplicationContext tom implement Spring IoC
        ApplicationContext applicationContext = 
                new ClassPathXmlApplicationContext("beans.xml");
        
        // Get the bean
        Sim sim = applicationContext.getBean("sim", Sim.class);
        
        // Calling the methods
        sim.calling();
        sim.data();
    }
}
```

### Step 6: Using Java-Based Configuration [↑](#inversion-of-control-ioc-)
Modern Spring application soften use Java-based configuration instead of XML.

#### 1. Create a Configuration Class.
- Define a configuration class using the `@Configuration` annotation.
- Use the `@Bean` annotation to define the beans.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Sim sim() {
        return new Jio(); // Change to new Airtel() to switch implementations
    }
}
```

#### 2. Use the Configuration in the main class
- Update the main class to use the Java-based configuration.

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        
        // Load the Spring IoC containerusing Java-based configuration
        ApplicationContext context 
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean
        Sim sim = context.getBean("sim", Sim.class);

        // Call methods
        sim.calling();
        sim.data();
    }
}
```


### Step 7: Using Annotations for Dependency Injection [↑](#inversion-of-control-ioc-)
Spring also supports annotation-based configuration which is widely used in modern applications.

#### 1. Enable Component Scanning
- Use the `@ComponentScan` annotation for the configuration class to enable component scanning.

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
}
```

#### 2. Annotate the Component Classes
- Use the `@Component` annotation

```java
import org.springframework.stereotype.Component;

@Component
public class Airtel implements Sim {
    @Override
    public void calling() {
        System.out.println("Airtel Calling");
    }

    @Override
    public void data() {
        System.out.println("Airtel Data");
    }
}

@Component
public class Jio implements Sim {
    @Override
    public void calling() {
        System.out.println("Jio Calling");
    }

    @Override
    public void data() {
        System.out.println("Jio Data");
    }
}
```

#### 3. Inject the Dependency
- Using the `@Autowired` annotation for dependency injection.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    @Autowired
    private Sim sim;

    public void useSim() {
        sim.calling();
        sim.data();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mobile mobile = context.getBean(Mobile.class);
        mobile.useSim();
    }
}
```
**Note:** this will throw a `NoUniqueBeanDefinitionException` because it will find two (2) beans. To solve this exception there is a need to specify the Bean to be injected.

### Fixing the `NoUniqueBeanDefinitionException` [↑](#inversion-of-control-ioc-)

#### 1. Use the `@Primary` annotation
Mark one of the beans as the primary using the `@Primary` annotation.

```java
@Component
@Primary
public class Airtel implements Sim {
    // Methods implementation
}
```

#### 2. Use the `@Qualifier` annotation
Use the `@Qualifier` annotation to specify which beans to inject.

```java
@Component
public class Mobile {

    @Autowired
    @Qualifier("jio") // Specify the bean name
    private Sim sim;

    public void useSim() {
        sim.calling();
        sim.data();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mobile mobile = context.getBean(Mobile.class);
        mobile.useSim();
    }
}
```

#### 3. Explicit Bean Names [↑](#inversion-of-control-ioc-)
- Explicitly name the beans and use the names in the `@Qualifier` annotation.

```java
@Component("airtelBean")
public class Airtel {
    //Methods implementation
}

@Component("jioBean")
public class Jio {
    //Methods implementation
}
```

Then in the Mobile class,

```java
@Component
public class Mobile {
    
    @Autowired
    @Qualifier("airtelBean")
    public Sim sim;
    
    public void useSim() {
        sim.calling();
        sim.data();
    }
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigurationApplicationContext(AppConfig.class);
        Mobile mobile = context.getBean(Mobile.class);
        mobile.useSim();
    }
}
```

---------
`NEXT TOPIC:` [Bean Factory](2_2_BeanFactory.md)