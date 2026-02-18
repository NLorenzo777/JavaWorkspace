# Spring Boot - Transaction Management [↑](../../../README.md#spring-framework)
In enterprise applications, transactions ensure data consistency and integrity.

A **transaction** is a sequence of operations performed as a single logical unit of work. 
Either all operations within a transaction succeed (commit) or none of them do (rollback)

Spring boot simplifies transaction management by using the `@Transaction` annotation, which is built
on top of Spring's declarative transaction management.

## Transaction Management
Transaction Management is the process of coordinating database operations to follow the **ACID** properties.

1. **Atomicity**: All or nothing. Ensure all operations in a transaction are treated as a single unit.
2. **Consistency**: Database remains valid before and after transaction.
3. **Isolation**: Concurrent transactions do not affect each other.
4. **Durability**: Changes persist even after system failures.

#### Example:
In a banking system, if a transfer money is initiated:
- Debit amount from one account.
- Credit amount to another account.

Bot operations should succeed or fail together.

## The `@Transactional` Annotation
- Automatically starts a transaction when a method is called.
- Commits the transaction if the method completes successfully.
- Rolls back the transaction if a runtime exception occurs.
- Reduces boilerplate transaction-handling code.

**Note:** If `spring-boot-starter-data-jpa` is used, Spring Boot auto-configures the transaction management.
Hence, there is no need for the `@EnableTransactionManagement` annotation.
Only use this annotation is not using JPA starter or need custom transaction management.