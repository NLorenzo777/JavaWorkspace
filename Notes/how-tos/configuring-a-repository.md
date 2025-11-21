# Configuring a Repository [↑](../../README.md#how-tos)

## Configuring using the `JpaRepository` class.
The **JpaRepository** class is an abstract class that is usually extended.

```java
public interface UserRepository extends JpaRepository<User, Integer> {}
```
- The `Integer` is for the id.
- The `User` is the retrieved object from the database. 
- The `User` is the entity that will serve as the model for the CRUD.

### Clear Steps:
1. Create the class annotated with `@Repository` and extend it to the `JpaRepository`.
2. Inject the repository to a service class.

### Methods
Below are the built-in methods under the JpaRepository.

#### findById(id)
**Note: The data type of `id` is the data type of the primary key in the related entity.**

**Returns:** `Optional<T>`


Below is an example of how this method is used:

```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }
}
```

#### .save(T)
- Saves the instantiated `T` object to the configured database. 
- `T` is a Generic type based on the repository class.
- **Returns:** `void`

#### .existsById(id)
- Checks if there is a record on the database containing the passed id.
- **Returns:** `boolean`

#### .deleteById(id)
- Delete a record based on the given id.