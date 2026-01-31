# Spring JDBC Introduction [↑](../../../README.md#spring-framework)
Java Database Connectivity (JDBC) is an API that defines how a client may access a database.
- It is a data access technology used for Java database connectivity. 
- It provides methods to query and update data in a database 
- is oriented toward relational databases.
- Provides a natural Java interface for working with SQL.

## JDBC Drivers
JDBC API uses JDBC drivers to connect with the database.

1. **JDBC-ODBC Bridge Driver:** Connects to databases via ODBC driver. It is a platform-dependent and not recommended for production use.
2. **Native API Driver:** Uses the database's native API for communication. It is partially written in Java and platform-dependent.
3. **Network Protocol Driver:** A fully Java-based driver that uses middleware to communicate with the database.
4. **Thin Driver:** A fully Java-based driver that communicates directly with the database using its network protocol. It is the most commonly used driver.

## Advantages/Disadvantages
| Advantages                                                             | Disadvantages                                                                                                                                               |
|------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Helps retrieve and manipulate data from the database efficiently       | Writing a lot of codes before and after executing the query such as creating connection, creating a statement, closing result-set, closing connection, etc. |
| Supports query and stored procedures                                   | Writing exception handling code on the database logic                                                                                                       |
| Almost any database for which ODBC driver is installed can be accessed | Repetition of these codes from one to another database logic is time-consuming                                                                              |

## The Spring JDBC-Template
The problems of JDBC API are eliminated by Spring JDBC-Template. It provides methods to write the queries directly that saves a lot of time and effort.

There are number of options for selecting an approach to form the basis for JDBC database access.
Spring framework provides the following approaches for JDBC database access.

1. `JdbcTemplate`
2. `NamedParameterJdbcTemplate`
3. `SimpleJdbcTemplate`
4. `SimpleJdbcInsert` and `SimpleJdbcCall`

### The JDBC Template
`JdbcTemplate` is a central class in the JDBC core package that simplifies the use of JDBC and helps to avoid common errors.

- It internally uses JDBC API and eliminates a lot of problems with JDBC API.
- It executes SQL queries or updates, initiating iteration over ResultSets and catching JDBC exceptions and translating them to the generic.
- It executes core JDBC workflow, leaving application code to provide SQL and extract results.
- It handles the exception and provides the informative exception messages with the help of exception classes defined in the **org.springframework.dao** package.

#### Common Methods of spring JdbcTemplate class
1. `public int update(String query)`: Used to insert, update and delete records.
2. `public int update(String query, Object... args)`: Used to insert, update and delete records using **PreparedStatement** using given arguments.
3. `public T execute(String sql, PreparedStatementCallback action)`: Executes the query by using `PreparedStatementCallback`.
4. `public void execute(String query)`: Used to execute **DDL** query. 