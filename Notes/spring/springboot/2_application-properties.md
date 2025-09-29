# Spring Boot - Application Properties [↑](../../../README.md#iv-spring-boot)
- Configuration plays a very important role in customizing the behavior of the application.
- Instead of hardcoding values, Spring Boot provides a flexible way to configure application properties using **application.properties** or **application.yml** file.
- These files allow developers to manage environment-specific settings such as database config, server port, logging level and much more.
- This makes the application more maintainable and portable.

## Commonly Used Properties

### Server Configuration
```text
server.port=4200
```

### Application Name
```text
spring.application.name=InsertNameHere
```

### Database Configuration
To connect the Spring Boot application with a database, specify the required properties such as:
- spring.datasource.url
- spring.datasource.username
- spring.datasource.password

#### For MySQL Database:
```text
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

#### For PostgreSQL Database
```text
spring.datasource.url=jdbc:postgresql://localhost:5432/Postgres
atasource.username=postgres
spring.datasource.password=postgres
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
```

#### For MongoDB
```text
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=BookStore
```

#### Hibernate (JPA) Settings
```text
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Connecting with Eureka Server
Eureka Server acts as a service registry in microservices architecture. Each microservice registers itself to Eureka, which maintains service discovery details.

```text
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:9096/eureka/
eureka.instance.hostname=localhost
```

## Using application.yml
- YAML is a superset of JSON and provides a more structured and readable way to define hierarchical configuration data.

#### Sample MySQL Configuration
```yml
spring:
  datasource:
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
    username: springuser
    password: ThePassword
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
```

#### Connecting to Eureka
```yml
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:9096/eureka/
  instance:
    hostname: localhost
```
