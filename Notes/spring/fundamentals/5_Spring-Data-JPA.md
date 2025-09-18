# Spring Data JPA
This article will walk through the available options and how they relate including JPA, Spring Data JPA, JDBC, Hibernate, Apache, PostgreSQL, and H2.

## Spring Data JPA and JDBC
- In Spring, adding a database is easy to do with the help of a library called **Spring Data JPA**.
- JPA stands for _Java Persistence API_, which is the underlying standard used to translate objects from Java into queries that can be sent directly to the underlying database.
- JDBC is another layer that sends raw database queries to the underlying database.
- JPA is a standard that can be implemented by an ORM (Object-Relational Mapping). The purpose of ORM is to allow application developers to implement the required interactions with the database without having to actually write database queries.
  - Instead of defining a database table in SQL, a POJO can be used.
  - Instead of writing SQL queries, Java methods can be used.

## Hibernate
- The ORM most commonly used in Spring Data JPA.
- Comes packaged along with the Spring Data JPA as part of the `spring-boot-starter-data-java` dependency.
- Spring Data JPA allows developers to ignore all the complexity of the internals.

## Database Types
- Spring Data JPA supports many different kinds of database right out of the box. This means that even if the underlying database technology changes, the code may remain the same.
- If there is an instance where the database technology changes, the application developer only needs to update the configuration of the SpringBoot application to point to the new database.

## The H2 Database
- H2 is a relational database written entirely in Java.
- One convenient feature is that it can run on the same kind of infrastructure as the application and can run entirely "in-memory". This makes it easy to test the Spring Boot Application on local machine without having to obtain a database server from elsewhere.
- To connect to an embedded H2 database, the application's properties needs to be updated.
- Spring uses a properties file to store information that the application depends on: `src/main/resources/application.properties` which includes,
  - the database URL
  - the number of logs application produce
  - the port of the application runs on.

```text
spring.datasource.url=jdbc:h2:~/plants.db
spring.datasource.driverClassName=org.h2.Driver
```