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