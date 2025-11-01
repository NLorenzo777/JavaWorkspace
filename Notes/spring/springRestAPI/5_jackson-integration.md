# JSON using Jackson in REST API Implementation with Spring Boot [↑](../../../README.md#vi-spring-with-rest-api)
By default, Spring Boot uses **Jackson** (a popular JSON library for Java) to convert Java objects to JSON and vice-versa through the process of Serialization and Deserialization.

## The Jackson Library
- Automatically convert data between Java objects and JSON.
- Spring Boot automatically configures Jackson as the default JSON processor via `spring-boot-starter-web`.

### Common Jackson Annotations
Jackson provides seveeral annotations for customizing JSON output:
- `@JsonProperty`: Rename a field in JSON
- `@JsonIgnore`: Ignore a field during serialization and deserialization
- `@JsonInclude`: Include/exclude fields based on conditions
- `@JsonFormat`: Define format for date/time fields
- `@JsonIgnoreProperties`: Ignore multiple fields


```java
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Integer id;

    @JsonProperty("full_name")
    private String name;

    @JsonIgnore
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String email;

    public User() {}

    public User(Integer id, String name, String password, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.email = email;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```