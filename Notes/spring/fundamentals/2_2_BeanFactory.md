
`PREVIOUS TOPIC:` [Inversion of Control](2_1_IoC.md)
---------

# Spring - BeanFactory [↑](../../../README.md#spring-framework)
- Spring is a container and behaves like a factory of Beans.
- **Beans** are Java objects that are configured at runtime by Spring IoC Container.
- BeanFactory represents a basic IoC Container which is a parent interface of **ApplicationContext**.
- **BeanFactory** does not support Annotation-based configuration whereas **ApplicationContext** does.

## Methods of BeanFactory

| Method                                                                                                        | Description                                                                                                                                 |
|---------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| `containsBean(String name)`                                                                                   | Does this bean factory contain a bean definition or externally registered singleron instance with the given name?                           |
| `getAliases(String name)`                                                                                     | Return the alises for the given bean name, if any.                                                                                          |
| `getBean(Class<T> requiredType)`                                                                              | Return the bean instance that uniquely matches the given object type, if any.                                                               |
| `getBean(Class<T>, requiredType, Object args)` <br/> `getBean(String name)`                                   | Return an instance, which may be shared or independent, of the specified bean.                                                              |
| `getBeanProvider(ResolvableType requiredType)`                                                                | Return a provider for the specified bean, allowing for lazy on-demand retrieval of instances, including availability and uniqueness options |
| `getType(String  name)` <br/> `getType(String name, boolean allowFactoryBeanInit)`                            | Determine the type of  bean with the given name.                                                                                            |
| `isPrototype(String  name)`                                                                                   | Is this bean a prototype? That is, will getBean(java.lang.String) always return independent instances?                                      |
| `isSingleton(String name)`                                                                                    | Is this bean a shared singleton? That is, will getBean(java.lang.String) always return the same instance?                                   |
| `isTypeMatch(String  name, Class<?> typeToMatch)` <br/> `isTypeMatch(String name, ResolvableType typeToMatch) | Check whether the bean with the given name matches the specified type.                                                                      |


### Notes:
- The bean returned by the object factory is an  `Object` type so it has to be typecast.

------
`NEXT TOPIC:` [Application Context](2_3_ApplicationContext.md)