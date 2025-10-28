# Spring - REST JSON Response
Implementing a JSON Response format in a REST Controller

```java
package gfg;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/JSON", produces="application/json")
@CrossOrigin(origins="*") 
public class RestJsonResponse {

    @GetMapping("/data")
    public ArrayList<DomainBean> get() {
        
        ArrayList<DomainBean> arr = new ArrayList<>();
        
        DomainBean userOne = new DomainBean();
        userOne.setId("1");
        userOne.setName("@geek");
        userOne.setData("GeeksforGeeks");
        
        DomainBean userTwo = new DomainBean();
        userTwo.setId("2");
        userTwo.setName("@drash");
        userTwo.setData("Darshan.G.Pawar");
        
        arr.add(userOne);
        arr.add(userTwo);
        
        return arr;
    }
    
    @GetMapping("/{id}/{name}/{data}")
    public ResponseEntity<DomainBean> getData(@PathVariable("id") String id, 
                             @PathVariable("name") String name, 
                                @PathVariable("data") String data) {
        
        DomainBean user = new DomainBean();
        user.setId(id);
        user.setName(name);
        user.setData(data);
        
        HttpHeaders headers = new HttpHeaders();
        
        ResponseEntity<DomainBean> entity = new ResponseEntity<>(user,headers,HttpStatus.CREATED);
        
        return entity;
    }
}
```

The REST API's JSON response can be consumed by:
- Spring application itself
- Front-end application/framework


## Spring Application
- Spring offers `RestTemplate` class to handle a REST response which has an HTTP method-specific handler methods.

```java
// Java Program to Illustrate Consume REST API response
package gfg;

// Importing required classes
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// Class
public class ConsumeResponse {

    // Creating an object of ResponseEntity class
    RestTemplate rest = new RestTemplate();

    public ResponseEntity<DomainBean> get()
    {

        return rest.getForEntity(
            "http://localhost:8080/JSON/{id}/{name}/{data}",
            Details.class, "007", "geek@drash",
            "Darshan.G.Pawar");
    }
}
```
A normal Spring controller is used to retrieve the responses from the RestTemplate method and returns a view.