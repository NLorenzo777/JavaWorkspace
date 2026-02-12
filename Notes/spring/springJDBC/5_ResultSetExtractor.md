# The ResultSetExtractor Interface [↑](../../../README.md#spring-framework)
`ResultSetExtractor` is an interface used to extract data from a ResultSet object returned by executing an SQL query.
it is especially useful when mapping an entire ResultSet (multiple rows or nested data) into a single object or collection.

```java
public T extractData(ResultSet resultSet) throws SQLException, DataAccessException;
```

```java
public <T> T query(String sql, ResultSetExtractor<T> resultSetExtractor);
```
The `JdbcTemplate.query()` method accepts a ResultSetExtractor instance.


## Sample Implementation
```java
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT id, name, department FROM Student";
        return jdbcTemplate.query(sql, new StudentResultSetExtractor());
    }

    private static class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {
        @Override
        public List<Student> extractData(ResultSet rs) throws SQLException {
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                students.add(new Student(id, name, department));
            }
            return students;
        }
    }
}
```