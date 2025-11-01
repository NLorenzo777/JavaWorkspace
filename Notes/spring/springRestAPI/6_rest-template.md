# Spring - RestTemplate [↑](../../../README.md#vi-spring-with-rest-api)
- Due to high traffic and quick access to services, REST APIs are getting more popular and have become the backbone of modern web development.
- REST is not a protocol or a standard, rather, it is a set of architectural constraints. When a client request is made, it just transfers a representation of the state of the resource to the requester or at the endpoint via HTTP.

## Key Features of RestTemplate
- **Synchronous Operations**: Simplifies programming model for many use cases.
- **Method veriety**: Provides 41 methods covering all HTTP verbs.
- **Response conversion**: Provides automatic mapping to domain objects.
- **Exception handling**: PRovides built-in error handling capabilities
- **Integration**: Seamless with Spring ecosystem.


## Introduction
RestTemplate is a tool that makes it easier to talk to other web services from the Spring application.

RestTemplate is deprecated as of Spring 5. It is recommended to use WebClient from Spring WebFlux, it supports non-blockin and reactive communication.