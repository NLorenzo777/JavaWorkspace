#### `PREVIOUS TOPIC:`[Bean Scopes](2_6_Bean-Scopes.md)
-----

# Expression Language (SpEL) [↑](../../../README.md#spring-framework)
- A feature of the Spring framework that enables querying and manipulating object graphs at runtime.
- Can be used in both XML and annotation-based configuration, offering flexibility for developers.

## SpEL API Components
- `Expression` (Interface)
- `ExpressionParser` (Interface)
- `SpelExpressionParser` (Class, implementation of ExpressionParser)
- `EvaluationContext` (Interface)
- `StandardEvaluationContext` (Class, implementation of EvaluationContext)

## Requirement
To use SpEL in the Spring project, the following dependencies should be added to the `pom.xml`.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
    </dependency>
</dependencies>
```

## Implementation


