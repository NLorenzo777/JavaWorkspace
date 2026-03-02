# Hibernate - Eager/Lazy Loading [↑](../../../README.md#spring-framework)

## FetchType
- FetchType is an enum in the Java Persistence API (JPA) that specifies whether the field or property should be lazily
loaded or eagerly loaded.
- In Hibernate, the FetchType is used to specify the fetching strategy to be used for an association.
- Can be specified for associations at the time of mapping the association.

### FetchType.LAZY
- Means the associated entity is fetched only when it is accessed for the first time, not when the parent entity is loaded.
- The default fetch type only for collection-based association such as `@OneToMany` and `@ManyToMany`.
- Can improve performance when the associated entity is not needed in most use cases, especially if the entity contains
a large amount of data.
- Accessing a lazily loaded association may trigger additional database queries, which can lead to performance issues
such as the **N+1 query** problem if not managed properly.
- It is recommended to analyze and profile the application to choose the most suitable fetch strategy for a given use case.

```java
@Entity
public class Employee {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
```
In this example, the Address entity associated with an Employee will be fetched lazily when it is accessed for the first time.

### FetchType.EAGER
- Means that the associated entity will be fetched together with the main entity when the main entity is fetched from
the database.
- Useful in cases where the associated entity is always required, but can also result in a performance decrease if the
associated entity is large and/or has many associations itself.
- Means that the associated entity should be fetched eagerly, which means that it will be fetched at the same time as the
parent entity.
- EAGER can be more efficient than LAZY if the associated entity is needed for most uses of the parent entity when it is accessed.
However, it can also be less efficient if the associated entity has a lot of data and is not needed for every use of the parent entity,
as it will always be fetched along with the parent entity.

```java
public class Employee {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
}
```
The address entity associated with an Employee will be fetched eagerly when the Employee is loaded from the database.