# Spring Bean Introduction
- The Spring framework defines a Spring bean as an object managed by the Spring [Inversion of Control (IoC) Container](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html)

```java
@Component
public class RaceTrack {
  private String location;
  private int miles;
  private String trackType;
}

@Component
public class Driver {
  private String name;
  private String team;
  private int yearsExperience;
}

public class RaceRound {
    private String startTime;
    @Autowired
    private RaceTrack currentRaceTrack;
    @Autowired
    private Driver currentDriver;
}
```
- Through the use of `@Component` and `@Autowired` annotation, there is no need to do a `new` keyword.
- The dependent classes `RaceTrack` and `Driver` are marked as Spring bean, which allow IoC container to manage them. I.e., instantiate them and inject them to the `RaceRound` class.

## Auto-beans Loading
The fully-automatic annotations approach is facilitated using three annotations:
- `@Configuration`: Notified the framework that beans may be created via the annotated class.
- `@ComponentScan`: Tells the framework to scan the code for components such as classes, controllers, services, etc.
- `@EnableAutoConfiguration`: Tells the container to auto-create beans from the found components.

Together, these three annotation tell the framework where to start looking, how to search code, and automatically instantiate beans from the found components.

### The `@SpringBootApplication`
- The `@SpringBootApplication` is a compilation of the `@Configuration`, `@ComponentScan`, and `@EnableConfiguration`.
- When this annotation is applied to the class containing the main method, the application runs with the built-in functionality of the 3 annotations.

```java
@SpringBootApplication
public class RecipeApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecipeApplication.class, args);
  }
}
```