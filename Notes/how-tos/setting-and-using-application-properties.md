# Setting and Consuming Application Properties in a Spring Application
- This section shows how to define an application properties and use it for further application developments.
- Setting the application properties is useful in abstracting sensitive information such as keys, database credentials, end points, etc.

## Via XML [↑](../../README.md#how-tos)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans/"
    xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans/
    http://www.springframework.org/schema/beans//spring-beans.xsd">

    <!-- DataSource configuration -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://localhost:5432/your_database"/>
        <property name="username" value="your_username"/>
        <property name="password" value="your_password"/>
    </bean>

    <!-- JdbcTemplate configuration -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!-- DAO configuration -->
    <bean id="frameworkDao" class="com.geeks.beans.FrameworkDao">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>
</beans>
```

```java
package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.geeks.beans.Framework;
import com.geeks.beans.FrameworkDao;

public class FrameworkTest {
    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
        
        FrameworkDao frameworkDao = (FrameworkDao) context.getBean("frameworkDao");
        Framework framework = frameworkDao.getFrameworkByName("Spring");
        
        if (framework != null) {
            System.out.println("Framework Details:");
            System.out.println("ID: " + framework.getId());
            System.out.println("Name: " + framework.getName());
            System.out.println("Description: " + framework.getDescription());
        } else {
            System.out.println("Framework not found");
        }
    }
}
```

