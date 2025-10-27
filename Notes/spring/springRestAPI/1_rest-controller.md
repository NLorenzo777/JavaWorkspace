# Spring - REST Controller [↑](../../../README.md#vi-spring-with-rest-api)

## The REST Controller
A REST Controller in Spring Boot is a special class used to defined RESTful web services. It is annotated with `@RestController` which makes it capable of:
- Handling HTTP requests (GET, POST, PUT, DELETE)
- Returning Java objects as JSON/XML without extra configuration.
- Acting as an endpoint for client-server communication.

## The @RestController annotation
Spring provides two main controller annotations:
1. `@Controller`: used for MVC-Based applications where responses are typically HTML pages.
2. `@RestController`: specialized version of @Controller that automatically serializes return objects into JSON/XML responses. Equivalent to `@Controller + @ResponseBody`.

This annotation is used at class level and allows the class to handle the request made by the client which allows the class to handle REST API request by automatically serializing responses to JSON.

## Sample Implementation

### 1. Create the Model Class

```java
public class Details {
    
    private int id;
    private String name;

    // Constructor
    public Details(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```


### 2. Create a REST Controller
This controller does not have a database to retrieve from.
It uses a List to contain data from CRUD operations.

```java
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class Controller {
        private List<Details> detailsList = new ArrayList<>();

    // GET API → Fetch all details
    @GetMapping("/details")
    public List<Details> getAllDetails() {
        return detailsList;
    }

    // POST API → Add new detail
    @PostMapping("/details")
    public String addDetails(@RequestBody Details details) {
        detailsList.add(details);
        return "Data Inserted Successfully";
    }

    // PUT API → Update detail by ID
    @PutMapping("/details/{id}")
    public String updateDetails(@PathVariable int id, @RequestBody Details updatedDetails) {
        for (Details details : detailsList) {
            if (details.getId() == id) {
                details.setName(updatedDetails.getName());
                return "Data Updated Successfully";
            }
        }
        return "Detail not found!";
    }

    // DELETE API → Remove detail by ID
    @DeleteMapping("/details/{id}")
    public String deleteDetails(@PathVariable int id) {
        detailsList.removeIf(details -> details.getId() == id);
        return "Data Deleted Successfully";
    }
}
```