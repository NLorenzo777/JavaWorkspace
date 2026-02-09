# Prepared Statement JDBC Template [↑](../../../README.md#spring-framework)
When there is a need to deal with dynamic queries on user inputs, it is important to use **Prepared Statements**
to prevent **SQL injection attacks** and also improve performance.

## The `PreparedStatementSetter` Interface
- present in the `org.springframework.jdbc.core` package.
- Used to set values on a PreparedStatement provided by the JdbcTemplate.
- Allows developers to set parameters dynamically, especially for batch updates using the same SQL.
- Provides a single method, `setValues()` which takes a PreparedStatement object and sets the value dynamically.

```java
package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FrameworkDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Framework getFrameworkByName(final String name) {
        String sql = "SELECT * FROM frameworks WHERE name = ?";
        
        List<Framework> frameworks = jdbcTemplate.query(
            sql,
            new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, name);
                }
            },
            new FrameworkMapper()
        );
        
        return frameworks.isEmpty() ? null : frameworks.get(0);
    }
    
    // Additional CRUD methods can be added here
}
```