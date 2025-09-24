#### `PREVIOUS TOPIC:` [Dependency Injection](2_4_Dependency-Injection.md)

-----

# Bean Lifecycle [↑](../../../README.md#spring-framework)
- The bean lifecycle in Spring is the sequence of steps a bean goes through from creation to destruction, and it is managed by the Spring container.

## Bean Lifecycle Phases

1. **Container Started:** The Spring IoC container is initialized.
2. **Bean Instantiated:** The container creates an instance of the bean.
3. **Dependencies Injected:** The container injects the dependencies into the bean.
4. **Custom init() methods:** If the bean implements `InitializingBean` or has a custom initialization method specified via `@PostConstruct` or init-method.
5. **Bean is Ready:** The bean is now fully instantiated and ready to be used.
6. **Custom Utility Method:** Any custom method defined in the bean.
7. **Custom destroy() method:** IF the bean implements `DisposableBean` or has a custom destruction method specified via `@PreDestroy` or destroy-method. This is called when the container is shutting down.

## Implementations

### I. Using XML Configuration

#### 1. Create the bean Class

```java
package beans;

public class HelloWorld {

    // Custom init method
    public void init() {
        System.out.println("Bean HelloWorld has been instantiated, and I'm the init() method");
    }

    // Custom destroy method
    public void destroy() {
        System.out.println("Container has been closed, and I'm the destroy() method");
    }
}
```

#### 2. Configure the Spring XML File

```xml
<beans xmlns="http://www.springframework.org/schema/beans//////"
       xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans//////
           http://www.springframework.org/schema/beans///////spring-beans.xsd">

    <bean id="hw" class="beans.HelloWorld"
          init-method="init" destroy-method="destroy"/>
</beans>
```

#### 3. Create a Driver Class
```java
package test;
import beans.HelloWorld;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) throws Exception {
        // Loading the Spring XML configuration file into the spring container and it will create the instance of the bean as it loads into container
        ConfigurableApplicationContext cap = new ClassPathXmlApplicationContext("resources/spring.xml");

        cap.close();
    }
}
```

#### Output:
```text
Bean HelloWorld has been instantiated and I'm the init() method
Container has been closed and I'm the destroy() method
```

### II. Using Programmatic Approach
- Implementing bean with two interfaces to provide the facility to the created bean to invoke custom init() and destroy() method.
- Using the `InitializingBean` and `DisposableBean` interfaces.
- Once a bean class implemented the two interfaces, the methods `afterPropertiesSet()` and `destroy()` are overriden.

#### 1. Create the bean class

```java
package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean,DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("Bean HelloWorld has been "	+ "instantiated and I'm the " + "init() method");
	}

	@Override
	public void destroy() throws Exception
	{
		System.out.println("Container has been closed "+ "and I'm the destroy() method");
	}
}
```

#### 2. Configure the Spring XML File

```xml
<beans xmlns="http://www.springframework.org/schema/beans//////"
       xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans//////
           http://www.springframework.org/schema/beans///////spring-beans.xsd">

    <bean id="hw" class="beans.HelloWorld"/>
</beans>
```

#### 3. Create the Driver Class
```java
package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.HelloWorld;

public class Client {

	public static void main(String[] args) throws Exception
	{

		ConfigurableApplicationContext cap = new ClassPathXmlApplicationContext("resources/spring.xml");
		cap.close();
	}
}
```

### III. Using Annotations
- Using the `@PostConstruct` and `@PreDestroy` annotations to the `init()` and `destroy()` method respectively.

```java
package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {

	@PostConstruct
	public void init() throws Exception
	{
		System.out.println(
			"Bean HelloWorld has been "	+ "instantiated and I'm the " + "init() method");
	}

	@PreDestroy
	public void destroy() throws Exception
	{
		System.out.println("Container has been closed " + "and I'm the destroy() method");
	}
}
```

```xml
<beans xmlns="http://www.springframework.org/schema/beans//////"
       xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans//////
           http://www.springframework.org/schema/beans///////spring-beans.xsd">

    <!-- Activate the @PostConstruct and @PreDestroy annotations -->
    <bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>

    <!-- Configure the bean -->
    <bean id="hw" class="beans.HelloWorld"/>

</beans>
```

```java
package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.HelloWorld;

public class Client {
    
	public static void main(String[] args) throws Exception
	{
		ConfigurableApplicationContext cap
			= new ClassPathXmlApplicationContext(
				"resources/spring.xml");

		cap.close();
	}
}
```

-----
#### `Next TOPIC:` [Bean Scopes](2_6_Bean-Scopes)