#### `PREVIOUS TOPIC` [Actuators](6_actuator.md)
-----

# Spring JDBC and Spring Data JDBC [↑](../../../README.md#iv-spring-boot)
Understanding the difference between **Spring JDBC** and **Spring Data JDBC** is important for choosing the right approach to interact with relational databases in Spring Boot applications.

- **Spring JDBC** requires manual SQL management and boilerplate code.
- **Spring Data JDBC** provides a high-level abstraction with automatic query generation and reduced boilerplate.

## Spring JDBC
Perform JDBC operations by having connectivity with any one of jars of RDBMS.

### Connection Configuration
For example, in order to connect with mySQL the `mysql-connector-java` is needed.
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.33</version> <!-- Use the latest stable version -->
</dependency>
```

### Model Class
```java
public class ModelClass {
  int column1;
  String column2;
  int column3;
} 
```

### DAO Pattern

```java
import javax.sql.DataSource;

public interface SampleDAO {

  void insert(ModelClass object);

  ModelClass findByXXX(int xxx);
}

public class JdbcSampleDAO implements SampleDAO {

  private DataSource dataSource;
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public void insert(ModelClass object) {
    // Logic here
  }
  
  public ModelClass findByXXX(int xxx) {
    //Logic here
  }
}
```

## Spring Data JDBC
- Belongs to the Spring Data family.
- Provides abstractions for JDBC-based Data Access layer.
- A lot of complexities are reduced as it provides easy to use ORM framework to work with databases and support entity objects.

### Dependencies
```xml
<dependency>
  <groupId>org.springframework.data</groupId>
  <artifactId>spring-data-jdbc</artifactId>
  <!-- Specify the required version here -->
  <version>{version}</version>
</dependency>
```

### POJO Classes
- Created POJO needs to match with the database table. if not, the `@Table` annotation is used.
- The `@Id` annotation is needed in identifying which is the primary key.
- It is a good practice that all the persistence fields in the POJO and DB table columns match. Otherwise, the `@Column` annotation is used.

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //a POJO requires access methods
@AllArgsConstructor //a POJO required a parameterized constructor
@NoArgsConstructor
@Table("table_name")
public class POJOClass {
  @Id
  private Long id;
  private String columnName1;
  private String columnName2;
  private int columnName3;
}
```

### Repository Interface
Repository interface along with query methods and `@Query` annotations are supported. The created repositories can be a sub-interface of CrudRepository.

```java
@Repository
public interface SampleRepository extends CrudRepository<POJOClass, Long> {
  List<POJOClass> findByColumnName1(String columnName1);
}
```

Spring Data JDBC only supports native SQL queries, not JPQL.

```java
@Query("SELECT * FROM table_name WHERE column_name = :param")
List<POJOClass> findByColumn(@Param("param") String param);
```



