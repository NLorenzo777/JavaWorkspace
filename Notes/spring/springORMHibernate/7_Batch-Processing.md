# Hibernate - Batch Processing [↑](../../../README.md#spring-framework)
- Hibernate is storing the freshly inserted objects in the second-level cache.
Because of this, there is always possibility of `OutOfMemoryException` when inserting more than
one million objects.
- Batching in hibernate handles situations where huge data is being inserted into the database.
- `hibernate.jdbc.batch_size` is used to enable batching. It is an integer value between 10-50.
If this is set to zero or negative, batching is disabled.

## Temporary
Sample Project: [Batch Processing](https://www.geeksforgeeks.org/java/hibernate-batch-processing/)