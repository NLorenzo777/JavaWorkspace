`PREVIOUS TOPIC:` [I. Spring Security - Introduction](1_Introduction.md)
---------------
# Spring Security - Important Terms [^](../../../README.md#spring-framework)

## Authentication
- Authentication is the process of verifying the identity of a user attempting to access the application.
- Ensures only legitimate users are allowed to interact with secured resources.

#### Common Authentication Methods
- **Form-Based Authentication** - A login page where users provide a username and password to access secure endpoints.
- **HTTP Basic Authentication** - The client sends credentials through HTTP headers, commonly used for REST APIs.
- **Custom Authentication** - Implemented using `AuthenticationProvider` and `UserDetailsService` to define custom logic.
- **Passkeys (New in SS 6.4)** - Enables passwordless authentication using cryptographic credentials instead of passwords.
- **One-Time Token Authentication (New in SS 6.4)** - Provides temporary authentication tokens for sensitive or time-bound operations.

## Authorization
Determines the actions that an authenticated user is permitted to perform.

#### Key Authorization Mechanisms
- **URL-Based Access Control** - Configured using `requestMatchers()` in the security filter chain to restrict access based on user roles.
- **Method-Level Security** - Uses annotations such as `@PreAuthorize`, `@PostAuthorize`, and `@Secured` to enforce access control at the **service layer**.
- **Access Control Lists (ACLs)** - Provides fine-grained control by defining permissions for specific users or roles on individual domain objects.
- **Simplified OAuth2 Configuration** - Enhances integration with third-party identity providers such as Google, GitHub, and Microsoft.
- **New Method Security Annotations** - Introduces improved annotation-based configuration for role and policy enforcement.

## Filter
- Filters are the backbone of Spring Security's architecture.
- Each incoming request passes through a certain chain of filters that perform security checks before reaching the application's cotroller.

#### Common Spring Security Filters
- **Authentication Filter** - Validates user credentials and establishes an authenticated session.
- **Authorization Filter** - Checks user permissions before granting access to a protected resource.
- **CSRF Protection Filter** - Safeguards application against CSRF attacks by validating CSRF tokens.
- **Session Management Filter** - Manages and protects session data, preventing session fixation attacks.
- **Refreshable SAML 2.0 Asserting Parties** - Supports dynamic metadata updates for SAML 2.0 authentication.
- **Security Observation for Filter Chain** - Provides enhanced monitoring and diagnostics for security filter execution.

--------
`NEXT TOPIC`: [OAuth2 in Spring](3_OAuth2.md)