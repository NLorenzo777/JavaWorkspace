# Introduction to Spring
- Spring is an open-source Java framework that is useful for building RESTful web applications.
- Spring focuses on project "scaffolding" so that developers can concentrate on the core logic of applications.
- Contains templates for many different kinds of applications
  - **Spring Cloud**
  - **Spring Web Services**
  - **Spring Security**
  - **Spring Boot**
  - etc.

## How Spring Web Application works
1. Client sends a GET request to the Spring Web Server (the Spring application).
2. The server sends data request to the data store to retrieve the information requested by the client.
3. The data store sends the requested data back to the server, if available.
4. The server sends the data (HTTP Response) back to the client and displays it on the browser.

## Making GET requests with a web browser
- Done using the `@GetMapping` annotation.

## Making GET requests with Curl
- Curl is short for _Client for URLs_.
- A command line tool that allows to transfer data to and from a server. It supports multiple protocol including HTTP.


```shell
curl http://www.mypetclinic.com/dogs/
```

## Making POST requests with a web browser
- Done using the `@PostMapping` annotation.

## Making a POST requests with curl

```shell
curl -X POST -d "{\"name\":\"Charlie\", \"breed\":\"German Shepherd\"}" -H "Content-Type: application/json" http://www.mypetclinic.com/dogs/ 
```

- The `-X POST` tells the server that the client is making a POST request. Where `-x` is the curl parameter specifying the type of request method to use.
- The `-d` (short for `--data`) indicates to the server that the client is sending a new data to an existing application.
- The `-H "Content-Type: application/json` specifies that the data is sent in JSON format.
- Finally, the URL `http://www.mypetclinic.com/dogs/` tells the server where to send the new data.