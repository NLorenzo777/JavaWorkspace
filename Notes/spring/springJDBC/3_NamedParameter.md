# Named Parameter JDBC Template [↑](../../../README.md#spring-framework)
The `NamedParameterJdbcTemplate` wraps the standard JdbcTemplate and enables the use of named parameters instead of traditional "?" placeholders,
making SQL queries more readable and maintainable.

### Syntax
```java
public <T> T execute(String sql, Map<String, ?> paramMap, PreparedStatementCallback<T> action)
```
- **sql:** The SQL string with named parameters (e.g., :name, :id)
- **paramMap:** Key-Value pairs mapping parameter names to values
- **action:** Callback to execute the prepared statement.

```java
@Repository
public class StudentDao {
    
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO STUDENT (id, name, department) VALUES (:id, :name, :dept)";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("id", student.getId())
            .addValue("name", student.getName())
            .addValue("dept", student.getDepartment());
        
        jdbcTemplate.update(sql, params);
    }

    public Optional<Student> findById(int id) {
        String sql = "SELECT id, name, department FROM STUDENT WHERE id = :id";
        try {
            Student student = jdbcTemplate.queryForObject(
                sql,
                Collections.singletonMap("id", id),
                (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name"), rs.getString("department"))
            );
            return Optional.of(student);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
```