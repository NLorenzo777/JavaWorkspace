# Spring Boot - Introduction to RESTful Web Services [↑](../../../README.md#vi-spring-with-rest-api)
- RESTful web services provide a standard approach to building scalable, stateless web APIs using HTTP.
- Unlike SOAP, REST does not rely on a strict messaging protocol, it can use multiple formats such as JSON or XML.

#### Table of contents
1. [Key Concepts](#key-concepts)
2. [HTTP Methods](#http-methods-)
3. [HTTP Status Codes](#http-status-codes-)
4. [REST API Response](#rest-api-response-)
5. [Security Best Practices](#security-best-practices-)
6. [Advantages](#advantages-)

## Key Concepts
- **Resource:** Any object, entity, or service that can be accessed via URI.
- **Stateless Communication:** Each HTTP request contain all the information needed to process it.
- **Representations:** Resources can be represented in different formats (JSON, XML, HTML, PDF, etc.)
- **HTTP Verbs:** REST leverages standard HTTP methods for CRUD operations.

## HTTP Methods [↑](#spring-boot---introduction-to-restful-web-services-)

### 1. GET - Read Resource
- Retrieves a data without a request body.
- Can fetch a specific resource using an ID or a collection without parameters.

```java
@GetMapping("/user/{userId}")
public ResponseEntity<UserEntity> getUser(@PathVariable int userId) {
    UserEntity user = userService.getUser(userId);
    return ResponseEntity.ok(user);
}
```

### 2. POST - Create/Add Resource
- Create a new resource using request body.

```java
@PostMapping("/user")
public ResponseEntity<String> addUser(@RequestBody UserEntity user) {
    userService.saveOrUpdate(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
}
```

### 3. PUT - Update Existing Resource
- Updates an existing resource identified by primary key or ID.

```java
@PutMapping("/user/{userId}")
public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody UserEntity user) {
    userService.saveOrUpdate(user);
    return ResponseEntity.ok("User updated successfully");
}
```

### 4. DELETE - Remove Resource
- Deletes a single or multiple resources based on parameters.

```java
@DeleteMapping("/user/{userId}")
public ResponseEntity<String> deleteUser(@PathVariable int userId) {
    userService.deleteUser(userId);
    return ResponseEntity.ok("User deleted successfully");
}
```

## HTTP Status Codes [↑](#spring-boot---introduction-to-restful-web-services-)

| Status Code | Definition    |
| ----------- | ------------- |
| 1XX         | Informational |
| 2XX         | Successful    |
| 3XX         | Redirection   |
| 4XX         | Client Error  |
| 5XX         | Server Error  |

- `200`: Success
- `201`: Created
- `401`: Unauthorized
- `404`: Resource Not Found
- `500`: Server Error

## REST API Response [↑](#spring-boot---introduction-to-restful-web-services-)
REST APIs can return data in multiple formats including:
- JSON
- XML
- HTML
- XLT
- Python
- PHP
- Plain text

**JSON** is the most commonly used format due to its lightweight nature and ease of parsing. However, **XML** has its own advantages, especially in enterprise applications.

## Security Best Practices [↑](#spring-boot---introduction-to-restful-web-services-)
- **Authentication and Authorization**: Use JWT or OAuth 2.0
- **Input Validation**: Sanitize requests to prevent SQL Injection and XSS Attacks
- **HTTPS Enforcement**: Ensure all communications are encrypted
- **Rate Limiting:** Protect against abuse by limiting request rates.

## Advantages [↑](#spring-boot---introduction-to-restful-web-services-)
- **Simple and Lightweight**: Easier to develop and consume compared to SOAP
- **Client-Server Decoupling**: Enables independent development of client and server
- **Scalable**: Stateless communication supports horizontal scaling
- **Layered System Architecture**: Application can be divided into layers, enhancing modularity and maintainability 
- **Cacheable**: Responses can be cached to improve performance and reduce bandwidth