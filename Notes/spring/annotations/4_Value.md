# `@Value` Annotation [↑](../../../README.md#iii-spring-annotations)
- One of the most important annotations in Spring framework.
- Used to assign default values to variables and method arguments.
- Allows developers to inject values from spring environments, system variables, and properties files.

## Key Points about @Value annotation
- It is used to inject values into fields, methods, or constructor parameters in Spring beans, typically from property files, environment variables, or expressions.
- It also supports SpEL, allowing dynamic values or expressions to be evaluated and injected.
- It also binds values from application.properties or application.yml to Spring beans.
- It also converts the injected value to the required data type.

## Implementations

### Using traditional XML Properties

#### 1. Simple POJO Class

```java
// Java Program to Illustrate Student Class
public class Student {

    // Class data members
    private int rollNo;
    private String name;
    private int age;

    // Setter for rollNo
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Method to display student details
    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

#### 2. Create properties file
Create the `student-info.properties` file in the classpath.
```text
// properties
student.rollNo=101
student.name=Noel
student.age=20
```

#### 3. Configure the Spring Bean in XML
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans/"
	xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context/"
	xsi:schemaLocation="http://www.springframework.org/schema/beans/
		https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context/
		https://www.springframework.org/schema/context/spring-context.xsd">

	<context:property-placeholder location="classpath:student-info.properties"/>
	
	<bean id="student" class="Student">
		<property name="rollNo" value="${student.rollNo}"/>
		<property name="name" value="${student.name}"/>
		<property name="age" value="${student.age}"/>
	</bean>

</beans>
```

#### 4. Run the application
```java
// Java Program to Illustrate Application Class
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the Student bean
        Student student = context.getBean("student", Student.class);

        // Display student details
        student.display();
    }
}
```

### Using the `@Value` Annotation

#### 1. Configure the Spring Bean in XML
Add the context below in the XML file.
```xml
<beans>
    <context:annotation-config/>
    <context:property-placeholder location="classpath:student-info.properties"/>
</beans>
```

#### 2. Modify the POJO Class to use the @Value annotation
```java
// Java Program to Illustrate Student Class
// Importing required classes
import org.springframework.beans.factory.annotation.Value;

// Class
public class Student {

    // Class data members
    @Value("${student.rollNo}") 
    private int rollNo;
    @Value("${student.name}")
    private String name;
    @Value("${student.age}") 
    private int age;

    // Method
    public void display()
    {
        // Printing attributes corresponding to student
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```