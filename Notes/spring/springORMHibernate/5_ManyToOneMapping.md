# Hibernate - Many-to-One Mapping [↑](../../../README.md#spring-framework)
When multiple records in one table are associated with a single record in another table.

This type of relationship helps to avoid data redundancy and maintain consistency.

```java
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name ="Foreign_Key_Column")
private String someColumn;
```

## Sample Implementation

### Entities

#### Employee.java
```java
@Data
@Entity
public class Employee {
    @Id private Long id;
    private String name;
    
    //Many employees has one company address
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
```

#### Address.java
```java
@Entity
@Data
public class Address {
    @Id private Long addressId;
    private String location;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Employee> employee = new ArrayList<>();
}
```