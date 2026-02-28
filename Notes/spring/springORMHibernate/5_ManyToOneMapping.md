# Hibernate - Many to One Mapping [↑](../../../README.md#spring-framework)
When multiple records in one table are associated with a single record in another table.

This type of relationship helps to avoid data redundancy and maintain consistency.

```java
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name ="Foreign_Key_Column")
private String someColumn;
```

## Sample Implementation

### Entities
