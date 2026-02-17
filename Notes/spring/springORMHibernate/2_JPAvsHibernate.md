# JPA vs. Hibernate [↑](../../../README.md#spring-framework)

## Java Persistence API (JPA)
- Java specification that provides functionality and standards for ORM tools.
- Used to examine, control, and persist data between java objects and relational databases.
- Regarded as standard technique for Object Relational Mapping.
- JPA is only a specification, not an implementation. It defines a set of rules and guidelines for ORM tools. Since it is just a specification, it does not perform any operation itself. It needs an implementation such as Hibernate, for actual data persistence.

### Key Features of JPA
- Lightweight persistence API.
- Supports ORM with simple annotations.
- Provides support for polymorphism and inheritance.
- Allows dynamic and named queries.
- Enables seamless switching between different ORM implementations.

## Hibernate
- Actual implementation of JPA that provides ORM capabilities
- a Java framework, open-source, lightweight, and ORM tool for the Java language which simplifies the buildout of Java applications to interact with the database.
- Saves the Java objects in the relational database system.

### Key Features of Hibernate
- Implements JPA specifications.
- Supports mapping Java classes to database tables.
- Provides caching mechanisms to optimize performance.
- Supports different databases without changing code.
- Offers Hibernate Query Language (HQL) for querying.

## Difference between JPA and Hibernate

| JPA                                                                                                                                                                           | Hibernate                                                                                                                                                                        |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| JPA is described in the `javax.persistence` package.                                                                                                                          | Hibernate is described in `org.hibernate` package                                                                                                                                |
| Describes the handling of relational data in Java applications                                                                                                                | An ORM tool that is used to save Java objects in the RDBS.                                                                                                                       |
| Not an implementation, it is only a Java specification                                                                                                                        | An implementation of JPA. Hence, the common standard which is given by JPA is followed by Hibernate.                                                                             |
| A standard API that permits to perform database operations                                                                                                                    | Used in mapping Java data types with SQL data types and database tables                                                                                                          |
| As an object-oriented query language, it uses Java Persistence Query Language (JPQL) to execute database operations                                                           | As an object-oriented query language, it uses Hibernate Query Language (HQL) to execute database operations                                                                      |
| To interconnect with the entity manage factory for the persistence unit, it uses the **EntityManagerFactory** interface. Thus, it gives an entity manager.                    | To create session instances, it uses **SessionFactory** interface.                                                                                                               |
| To make, read, and remove actions for instances of  mapped entity classes, it uses **Entity Manager** interface. This interface interconnects with the persistence condition. | To make, read, and remove actions for instances of mapped entity classes, it uses **Session** interface. It acts as a runtime interface betweena Java application and Hibernate. |
