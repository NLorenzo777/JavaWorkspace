# `@ComponentScan` Annotation [↑](../../../README.md#iii-spring-annotations)
- Used to specify that the framework should scan for Spring-managed components.
- These components are classes annotated by `@Component`, `@Service`, `@Repository`, or `@Controller`.
- When Spring finds such classes, it automatically registers them as beans in the Spring application context.
- Used along `@Configuration` annotation. It eliminates the need for manual bean registration in XML files.
- Without arguments, the annotation scans the package of the annotated class and its sub-packages by default.


## Component Class

```java
// Java Program to Illustrate Component Annotation
// Indulgence in College Class

package ComponentAnnotation;
import org.springframework.stereotype.Component;

// Registering the class as a Spring bean
@Component("collegeBean")  
public class College {
    public void test() {
        System.out.println("Test College Method");
    }
}
```

## Configuration Class

```java
// Java Program to Illustrate Configuration of
// College Class

package ComponentAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// Marks this class as a configuration class
@Configuration  
// Specifies the package to scan
@ComponentScan(basePackages = "ComponentAnnotation") 
public class CollegeConfig {
}
```

## Main Application

```java
//Creating a Main class
package ComponentAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring application context using the configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);

        // Retrieve the College bean
        College college = context.getBean(College.class);

        // Call the test method
        college.test();
    }
}
```