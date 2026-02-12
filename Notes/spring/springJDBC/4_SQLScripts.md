# SQL Scripts with Spring JDBC + JPA + HSQLDB [↑](../../../README.md#spring-framework)
This section covers the execution of SQL scripts at application startup using Spring JDBC, JPA, and HSQLDB.

- **JDBC:** API for connecting Java applications to databases.
- **JPA:** Provides Object-Relational Mapping (ORM) to manage relational data in Java.
- **HSQLDB (HyperSQL DB):** A lightweight, fast, and transactional SQL database written in Java, supporting in-memory and disk-based tables.

## Step-by-Step implementation

### 1. Configure the dependencies

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency> <!-- No version specified as Spring Boot manages it automatically -->

    <!-- HSQLDB (In-memory database) -->
    <dependency>
        <groupId>org.hsqldb</groupId>
        <artifactId>hsqldb</artifactId>
        <version>2.7.1</version> <!-- Latest version -->
        <scope>runtime</scope>
    </dependency>

    <!-- Flyway for database migrations (optional) -->
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
        <version>9.x.x</version> <!-- Latest Flyway version -->
    </dependency>
</dependencies>
```

### 2. Configure the application properties
```text
# HSQLDB in-memory database configuration
spring.datasource.url=jdbc:hsqldb:mem:geeksforgeeks
spring.datasource.driverClassName=org.hsqldb.jdbc.JDBCDriver
spring.datasource.username=root
spring.datasource.password=pass

# SQL scripts for schema and data initialization
spring.datasource.schema=classpath:schema.sql
spring.datasource.data=classpath:data.sql

# Hibernate configuration (prevent schema generation)
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

# Flyway migrations (optional)
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

### 3. Create the SQL Scripts
**schema.sql**
```sql
-- Creating car table
CREATE TABLE car (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price INT
);

-- Creating book table
CREATE TABLE book (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price INT
);
```

**data.sql**
```sql
-- Insert data into car table
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Audi', 3000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'BMW', 4000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Jaguar', 3500000);

-- Repeat data into car table
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Audi', 3000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'BMW', 4000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Jaguar', 3500000);

-- Insert data into book table
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-1', 600);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-2', 500);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-3', 800);

-- Repeat data into book table
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-1', 600);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-2', 500);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-3', 800);
```

### 4. Enable Database Migration (optional)
For better schema management and versioning, use Flyway. Place migration scripts under `src/main/resources/db/migration`.

**V1_create_schema.sql**
```sql
CREATE TABLE car (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price INT
);

CREATE TABLE book (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price INT
);
```

**V2_insert_data.sql**
```sql
-- Car data
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Audi', 3000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'BMW', 4000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Jaguar', 3500000);

-- Repeat car data
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Audi', 3000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'BMW', 4000000);
INSERT INTO car (id, name, price) VALUES (DEFAULT, 'Jaguar', 3500000);

-- Book data
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-1', 600);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-2', 500);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-3', 800);

-- Repeat book data
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-1', 600);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-2', 500);
INSERT INTO book (id, name, price) VALUES (DEFAULT, 'Book-3', 800);
```

### 5. Run the application
- On startup, Spring Boot executes the schema.sql and data.sql scripts automatically.
- If flyway is enabled, it will run the migration scripts in version order.
- The database tables car and book will be created and populated with initial data.
