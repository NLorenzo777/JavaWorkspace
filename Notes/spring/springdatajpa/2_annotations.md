# Spring Data JPA Annotations [↑](../../../README.md#vii-spring-data-jpa)

- [@Table Annotation](#the-table-annotation-)
- [@Column Annotation](#the-column-annotation-)
- [@Id Annotation](#the-id-and-generatedvalue-annotation-)

## The @Table Annotation [↑](#spring-data-jpa-annotations-)
- Used to customize how an entity class is mapped to a database table.
- By default, JPA uses the class name as the table name.
- This annotation allows the explicit defining of table  names, schemas, catalogs, and unique constraints.
- Part of the **Jakarta Persistence API (JPA)** specification.

```java
import jakarta.persistence.*;
@Entity
@Table(name = "student")  // Defines custom table name
public class Student {
  
}
```

### Attributes of the @Table Annotation 
1. **name:** specifies the name of the DB table.
2. **catalog:** defines the DB catalog name.
3. **schema:** defines the schema name of the table.
4. **uniqueConstraints:** Enforces unique constraints on one or more columns.

### Example
```java
import jakarta.persistence.*;

@Entity
@Table(
    name = "EMPLOYEE",
    uniqueConstraints = { @UniqueConstraint(columnNames = "email") }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;
}
```

## The @Column Annotation [↑](#spring-data-jpa-annotations-)
- Used within entity classes to specify details about the column that stores a particular field.
- Automatically maps the field name of the Entity class if not specified.

### Common Attributes of @Column Annotation
1. **name:** Specified the name of the column name in the database
2. **length:** Defines the maximum size of a string column (default: 255)
3. **nullable:** Indicates whether the column can contain NULL values (default: true)
4. **unique:** Ensures that all values in this column are unique.
5. **precision:** Defines the total number of digits for numeric columns.
6. **scale:** Defines the number of digits to the right of the decimal point.
7. **insertable:** Determines whether the column is included in SQL INSERT statements.
8. **updatable:** Determines whether the column is included in SQL UPDATE statements.
9. **columnDefinition:** Allows custom SQL column definition

## The @Id and @GeneratedValue Annotation [↑](#spring-data-jpa-annotations-)
- The `@Id` annotation marks a field in an entity class which tells that it is a primary key.
- When used with `@GeneratedValue` annotation, it enables automatic generation of unique IDs for new records.

```java
import jakarta.persistence.*;

@Entity
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```

### Common @GeneratedValue Strategies 
- `GenerationType.IDENTITY`: Uses the DB's identity column for auto-increment. Common in MySQL.
- `GenerationType.SEQUENCE`: Uses a database sequence to generate IDs. Common for PostgresSQL and Oracle.
- `GenerationType.TABLE`: Uses a separate table to maintain and generate unique identifiers.
- `GenerationType.AUTO`: Lets JPA automatically select the generation strategy based on the underlying database.