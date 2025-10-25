# Spring MVC - Java Based Configuration [↑](../../../README.md#v-spring-mvc)

### 1. Add the dependency

**pom.xml**
```xml
<project xmlns="https://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example.springmvc</groupId>
  <artifactId>SpringMVCApp</artifactId>
  <packaging>war</packaging>
  <version>0.0.1-SNAPSHOT</version>

  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.34</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
  </dependencies>

  <build>
    <finalName>SpringMVCApp</finalName>
  </build>
</project>
```

### 2. Create the Java Configuration File
This will replace the `web.xml`. 

- The **getServletMappings()** function receives requests corresponding to the URL mapping.
- The **getServletConfigClasses()** configures the dispatcher servlet and transfers the handler to MVCConfig.class

```java
package com.geeksforgeeks.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MVCconfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
```


### 3. Create the MVCConfig.class
This will replace the dispatcher servlet.

```java
package com.geeksforgeeks.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.geeksforgeeks.web")
public class MVCconfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
```

### 4. Create the Controller class

```java
package com.geeksforgeeks.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

    @RequestMapping("/greet")
    public ModelAndView showView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result"); // Logical view name
        mv.addObject("result", "GeeksForGeeks Welcomes you to Spring!");
        return mv;
    }
}
```

### 5. Create the JSP files

```html
<html>
<body>
    <h2>Hello World!</h2>
    <form action="greet">
        <input type="submit" value="Press to greet">
    </form>
</body>
</html>
```

```html
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
    <h1>${result}</h1>
</body>
</html>
```