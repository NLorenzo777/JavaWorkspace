# Creating a Stored Procedure in SQL [↑](../../README.md#how-tos)

A **stored procedure** is a precompiled set of one or more SQL statements stored in a database management system (RDBMS)
that can be reused by multiple programs.

```sql
CREATE PROCEDURE GetEmployee @EmpID INT
AS
BEGIN
    SELECT * FROM Employees WHERE EmployeeID = @EmpID;
END;
```

### Execution
```text
-- To execute:
EXEC GetEmployee @EmpID = 5;
``` [4, 6]
```