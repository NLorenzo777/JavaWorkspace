
`PREVIOUS TOPIC:` [BeanFactory](2_2_BeanFactory.md)
---------

# ApplicationContext [↑](../../../README.md#spring-framework)
- `ApplicationContext` is the sub-interface of BeanFactory. It is used when creating an enterprise-level application or web applicaiton.
- whatever features provided by the `BeanFactory` are also provided.

## ApplicationContext Features
- Publishing events to registered listeners by resolving property files.
- Methods for accessing application components.
- Supports internationalization.
- Loading file resources in a generic fashion.

## ApplicationContext Implementation Classes
There are different types of Application containers provided by Spring for different requirements.

### Container 1: AnnotationConfigApplicationContext
- Introduced in Spring 3.0.
- Accepts classes annotated with `@Configuration`, `@Component`,  and JSR-330 compliant classes.

```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig1.class);
```

**Note:** Add the following to the properties file in the IDE to allow the Spring to override beans.

```text
spring.main.allow-bean-definition-overriding=true
```

### Container 2: AnnotationConfigWebApplicationContext
- Introduced in Spring 3.0.
- Similar with `AnnotationConfigApplicationContext` for a web environment.
- Accepts classes annotated with `@Configuration`, `@Component`,  and JSR-330 compliant classes. These classes can be registered via `register()` method or passing base packaged to `scan()` method.
- This class may be used when configuring the `ContextLoaderListener` servlet listener or a `DispatcherServlet` in a web.xml.

```java
// Class
// Implementing WebApplicationInitializer
public class MyWebApplicationInitializer implements WebApplicationInitializer {

  // Servlet container

  public void onStartup(ServletContext container) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class);
    context.setServletContext(container);

    // Servlet configuration
  }
}
```

### Container 3: XmlWebApplicationContext
- Spring MVC Web-based application can be configured completely using XML or Java code.
- Configuring this container is similar to `AnnotationConfigWebApplicationContext`.

```java
// Class
// Implementing WebApplicationInitializer
public class MyXmlWebApplicationInitializer implements WebApplicationInitializer {

  // Servlet container
  public void onStartup(ServletContext container) throws ServletException {
    XmlWebApplicationContext context = new XmlWebApplicationContext();
    context.setConfigLocation("/WEB-INF/spring/applicationContext.xml");
    context.setServletContext(container);

    // Servlet configuration
  }
}
```

### Container 4: FileSystemXmlApplicationContext
- Used to load XML-based Spring Configuration files from the file system or from URL.
- The application context can be get using Java code.
- Useful for standalone environments and test harnesses.

```java
String path = "Documents/demoProject/src/main/resources/applicationcontext/student-bean-config.xml";

ApplicationContext context = new FileSystemXmlApplicationContext(path);
AccountService accountService = context.getBean("studentService", StudentService.class);
```
This example shows how to create a container and use the XML as metadata information to load the beans.

### Container 5: ClassPathXmlApplicationContext
- Application context can be retrieved using Java code.
- Useful for standalone environments and test harnesses.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/student-bean-config.xml");
StudentService studentService = context.getBean("studentService", StudentService.class);
```

-----
`NEXT TOPIC:` [Dependency Injection](2_4_Dependency-Injection.md)