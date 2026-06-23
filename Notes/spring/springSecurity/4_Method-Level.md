`PREVIOUS TOPIC:` [Spring Framework - OAuth2 Authentication with Spring](3_OAuth2.md)
-----
# Spring Security at Method Level [^](../../../README.md#spring-framework)
Spring Security also supports method-level security to protect specific methods directly.
- Provides role-based access control on specific methods.
- Protects service-layer business logic from unauthorized access.
- Uses annotations for declarative and cleaner security configurations.

## Purpose of Method-Level Security
- **Granular Control:** Restrict access to specific methods instead of the entire application or URL.
- **Business Logic Protection:** Even if someone bypasses the web layer, the service methods remain protected.
- **Role-Based Access:** Easily define role-based restrictions at the method level.
- **Separation of Concerns:** Security logic is applied declaratively without polluting business logic.

## Enabling Method-Level Security
```java

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    // Other security configurations
}
```

## Common Annotations for Method Security
Spring Security provides annotations to restrict access to methods based on roles.

### `@Secured`
Restricts method access based on user roles.

```java
@Service
public class ReportService {
    
    @Secured("ROLE_MANAGER")
    public string generateReport() {
        return "Report generated!";
    }
}
```

### `@PreAuthorize`
Checks authorization before method execution

```java
@Service
public class AccountService {
    
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAccount(Long id) {
        return "Account " + id + " deleted!";
    }
}
```

### `@PostAuthorize`
Applies authorization after method execution

```java
@Service
public class AccountService {
    
    @PostAuthorize("returnObject.owner == authentication.name")
    public Account getAccountDetails(Long id) {
        return new Account(id, "john_doe");
    }
}
```

### `@RolesAllowed`
Part of JSR-250 standard security.

```java
@Service
public class UserService {
    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    public String viewProfile() {
        return "Profile details shown!";
    }
}
```