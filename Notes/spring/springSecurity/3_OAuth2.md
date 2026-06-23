`PREVIOUS TOPIC`: [Important Terms in Spring Security](2_Important-terms.md)
------
# Spring Framework - OAuth2 Authentication with Spring [^](../../../README.md#spring-framework)
- **OAuth2** is an industry-standard protocol for authorization.
- Instead of creating separate credentials for every app, users can log in with a trusted provider (like GitHub, Google, etc.) and allow the application to use a certain information.

#### Advantages of OAuth2
- Eliminates password storage in the app
- Provides secure authentication
- Enhances user experience with SSO

## Implementing OAuth2 Authentication

### 1. Create an OAuth App (GitHub)
- Go to GitHub → Settings → Developer Settings → OAuth Apps.
- Create a new OAuth App
- Register the app and copy the **Client ID** and **Client Secret**.

### 2. Add the maven dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
```

### 3. Configure the Application Properties
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            client-id: your-client-id
            client-secret: your-client-secret
            scope: read:user
            redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
            client-name: GitHub
        provider:
          github:
            authorization-uri: https://github.com/login/oauth/authorize
            token-uri: https://github.com/login/oauth/access_token
            user-info-uri: https://api.github.com/user
            user-name-attribute: login
```

### 4. Create the Controller

```java
package com.example.oauth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("name", principal.getAttribute("login"));
        model.addAttribute("avatar", principal.getAttribute("avatar_url"));
        return "welcome";
    }
}
```

-------
`NEXT TOPIC:` [Spring Security at Method Level](4_Method-Level.md)

