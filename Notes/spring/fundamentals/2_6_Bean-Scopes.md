#### `PREVIOUS TOPIC:`[Bean Lifecycle](2_5_Bean-Lifecycle.md)
-----

# Bean Scopes [↑](../../../README.md#spring-framework)
The Spring framework provides five (5) scopes for a bean.

1. **Singleton:**
    - Only one instance will be created for a single bean definition per Spring IoC container.
    - The same object will be shared for each request made for that bean.
2. **Prototype:**
    - A new instance will be created for a single bean definition everytime a request is made for that bean.
3. **Request:**
    - A new instance will be created for a single bean definition everytime an HTTP request is made for that bean.
    - Only valid in the context of a web-aware Spring ApplicationContext.
4. **Session:**
    - Scopes a single bean definition to the lifecycle of an HTTP Session.
    - Only valid in the context of a web-aware Spring ApplicationContext.
5. **Global-Session:**
    - Scopes a single bean definition to the lifecycle of a global HTTP Session.
    - Only valid in the context of a web-aware Spring ApplicationContext.

- The first two (2) are available for both an IoC container and a Spring-MVC container.
- The last three (3) scopes are available only in the context of a web-aware Spring ApplicationContext.
- By default, the scope of a bean is singleton.

```java
@Component  
@Scope("prototype")  // or @Scope("singleton")
public class HelloWorld {
    
}  
```

## Custom Bean Scopes
Spring scopes are powerful, but may not always fit application needs.
- In a **multi-tenant system**, a separate instance of a bean for each tenant might be needed.
- In a **thread-based application**, a unique bean to each thread might be needed.

Custom beans allows the definition of bean lifecycles that align with application requirements.

## The Scope Interface
To create a custom scope, the `org.springframework.beans.factory.config.Scope` interface needs to be implemented.

This interface defines the following methods:

- **Object get(String name, ObjectFactory<?> objectFactory):** Retrieves an object from the scope. If the object does not exist, it created one using the ObjectFactory.
- **Object remove(String name):** Removes an object from the scope.
- **void registerDestructionCallback(String name, Runnable destructionCallback):** Registers a callback to be executed when the object is destroyed or the scope ends.
- **String getConversationId():** Returns a unique identifier of the current scope (e.g. thread ID, session ID).

### Implementation of Scope

#### 1. Create Custom Bean Scope Class

```java
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class CustomThreadScope implements Scope {
    private final ThreadLocal<Map<String, Object>> threadScope = ThreadLocal.withInitial(HashMap::new);

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = threadScope.get();
        return scope.computeIfAbsent(name, k -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> scope = threadScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Implement destruction callback logic if needed
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
```

#### 2. Register the Custom Scope

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.CustomScopeConfigurer;

@Configuration
public class AppConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("thread", new CustomThreadScope());
        return configurer;
    }
}
```
The `CustomScopeConfigurer` is used to register the CustomThreadScope with the name "thread".


#### 3. Use the custom scope in Bean Definition

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("thread")
public class MyBean {
    private final String threadId = String.valueOf(Thread.currentThread().getId());

    public void printThreadId() {
        System.out.println("Bean instance created by thread: " + threadId);
    }
}
```

#### 4. Testing the Custom Scope

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Runnable task = () -> {
            MyBean bean = context.getBean(MyBean.class);
            bean.printThreadId();
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
```
Each thread creates its own instance of MyBean, demonstrating the custom thread scope in action.

-----
#### `NEXT TOPIC:` [Expression Language (SpEL)](2_7_SpEL.md)