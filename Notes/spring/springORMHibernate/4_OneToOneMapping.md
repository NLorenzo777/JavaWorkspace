# Hibernate - One-to-One Mapping [↑](../../../README.md#spring-framework)

In Hibernate, one-to-one mapping defines a relationship where one entity instance is associated with exactly one instance of another entity.
It represents a real-world relationship such as:
- A person has one passport.
- A student has one college ID.
- A vehicle has one engine.

## Types of One-To-One Mapping
1. **Unidirectional**: Only one entity maintains the reference of the other and not vice versa.
2. **Bidirectional**: Both entities hold references to each other, allowing navigation from either side.
