# How to implement AOP in a Spring Application
Spring boot simplifies AOP integration using annotations and auto-configuration

## Types of AOP Advice in Spring

### 1. `@Around`
- Executes both before and after the target method.
- The first parameter must be of type `ProceedingJoinPoint` and it must invoke the `.proceed()` method to continue the target method's execution.

```java
@PointCut("execution(* com.example.service.ServiceExample.*(..))")
private void printLogs() {}

@Around("printLogs()")
public void logsAroundAdvice(ProceedingJoinPoint joinPoint) {
    System.out.println("Before invoking method: " + joinPoint.getSignature().getName());
    
    try {
        joinPoint.proceed();
    } finally {
        System.out.println("After invoking method: " + joinPoint.getSignature().getName());
    }
}
```

**Use Cases:**
- Track execution time of methods.
- Centralized logging before and after service calls
- Profiling or performance monitoring.

### 2. `@Before`
Executes before the target method is invoked. If @Around advice exists, its "before" portion executes first followed by @Before.

```java
@Before("execution(* com.gfg.examples.service.ServiceExample.*(..))")
public void logBeforeMethod() {
    System.out.println("Executing @Before advice before the target method.");
}
```
**Use Case:** Performing input validation or pre-condition checks before a method executes.

### 3. `@After`
- Executes after the method execution, regardless of its outcome.
- If @Around advice exists, its "after" part executes first.

```java
@After("execution(* com.example.service.ServiceExample.*(..))")
public void logAfterMethod() {
    
}
```
**Use Case:** Performing resource cleanup, sending notifications, or closing database connections.

### 4. `@AfterReturning`
- Executes only when the method successfully returns a result.
- It can capture the return value of the method.

```java
@AfterReturning(
        value = "execution(* com.examples.serice.ServiceExample.*(..))",
        returning = "result"
)
public void logAfterReturning(JoinPoint joinPoint, Object result) {
    System.out.println("Method " + joinPoint.getSignature().getName() + " returned: " + result);
}
```
**Use Case:** Logging successful operations or triggering dependent action after successful method call.

### 5. `@AfterThrowing`
Executes only when a method throws an exception. It helps log or handle exceptions globally.

```java
@AfterThrowing(
        value = "execution(* com.example.service.ServiceExample.*(..))",
        throwing = "ex"
)
public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
    System.out.println("Exception in method: " + joinPoint.getSignature().getName());
    System.out.println("Exception Message: " + ex.getMessage());
}
```