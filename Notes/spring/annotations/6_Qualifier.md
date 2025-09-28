# `@Qualifier` Annotation [↑](../../../README.md#iii-spring-annotations)
- Used to resolve ambiguity when multiple beans of the same type are available for dependency injection.
- Specify which exact bean should be injected into a class when Spring cannot automatically determine the correct one.
- Used with `@Autowired` to resolve ambiguity when there are multiple beans of the same type.
- Can be used on setter methods, fields, and constructors.
- `NoUniqueBeanDefinitionException` will be thrown if not used.

```text
@Qualifier("beanName")
```


