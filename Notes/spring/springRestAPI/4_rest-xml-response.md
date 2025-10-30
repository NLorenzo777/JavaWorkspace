# Spring - REST XML Response [↑](../../../README.md#vi-spring-with-rest-api)

While JSON is the standard for data transfer, XML offers several advantages.

1. **Extensibility**: XML uses tags for data definition, making it highlt extensible.
2. **Namespaces**: XML supports namespaces, which helps avoid naming conflicts.
3. **Comments**: Useful for documentations
4. **Encoding**: Supports various coding schemes.
5. **Security**: More secure than JSON because it has built-in support for validation and schema definition. JSON on the other hand can be vulnerable to injection attacks if not properly validated.

#### Note:
- JSON is less secure because of the absence of JSON parser in the browser.
- JSONP is dangerous because it allows cross-origin exchanges of data

## Returning XML Responses in Spring Boot
- When a Spring Boot project is created with Starter Web dependency, JSON is the only data format supported through the **Jackson Library**.
- To enable support for XML format a third-party dependency is needed:
    1. Jackson XML Extension
    2. JAXB

### 1. Add the Dependency
```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

### 2. Create the Entity Model

```java
// Java Program Illustrating Object to be return as XML
// response
// Importing required classes
import lombok.Data;

@Data
public class EntityModel {
    // Class data members
    String ID;
    String NAME;
    String DOB;
    String PINCODE;
}
```

### 3. Create the REST Controller for XML Response

```java
// Java Program Illustrating REST API returning XML response

package gfg;

// Importing required classes
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/xml-output", produces = "application/xml")
public class RestXMLResponseController {

    @GetMapping("/get")
    public ResponseEntity<EntityModel> get()
    {

        EntityModel model = new EntityModel();
        model.setID("1");
        model.setNAME("Darshan.G.Pawar");
        model.setDOB("05-09-2001");
        model.setPINCODE("422 009");

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<EntityModel> entityModel
            = new ResponseEntity<>(model, headers,
                                   HttpStatus.CREATED);

        return entityModel;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EntityModel>
    getById(@PathVariable("id") String id)
    {

        EntityModel model = new EntityModel();
        model.setID(id);
        model.setNAME("Darshan.G.Pawar");
        model.setDOB("05-09-2001");
        model.setPINCODE("422 009");

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<EntityModel> entityModel
            = new ResponseEntity<>(model, headers,
                                   HttpStatus.CREATED);

        return entityModel;
    }
}
```