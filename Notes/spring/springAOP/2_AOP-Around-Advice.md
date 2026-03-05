# Spring AOP Around Advice [↑](../../../README.md#spring-framework)
- Around advice is the strongest advice among all the advice since it runs around a matched method execution. For example,
before and after the advised method.
- It can choose whether to proceed to the join point or to bypass join point by returning its own return value or throwing exception.
- This type of advice is used where we need frequent access to a method or database like caching or to share state before and after a method execution
in a thread-safe manner (for example, starting and stopping a timer)
- Denoted by the `@Around` annotation. The advice method requires special parameters.
  1. Type `ProceedingJoinPoint` where the `.proceed()` method is called to execute the joint point method.
  2. Array of Object 