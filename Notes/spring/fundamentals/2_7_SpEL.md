#### `PREVIOUS TOPIC:`[Bean Scopes](2_6_Bean-Scopes.md)
-----

# Expression Language (SpEL) [↑](../../../README.md#spring-framework)
- A feature of the Spring framework that enables querying and manipulating object graphs at runtime.
- Can be used in both XML and annotation-based configuration, offering flexibility for developers.

## SpEL API Components
- `Expression` (Interface)
- `ExpressionParser` (Interface)
- `SpelExpressionParser` (Class, implementation of ExpressionParser)
- `EvaluationContext` (Interface)
- `StandardEvaluationContext` (Class, implementation of EvaluationContext)

## Requirement
To use SpEL in the Spring project, the following dependencies should be added to the `pom.xml`.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
    </dependency>
</dependencies>
```

## Implementation

### XML Based Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans/"
    xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context/"
    xsi:schemaLocation="http://www.springframework.org/schema/beans/ http://www.springframework.org/schema/beans//spring-beans.xsd
    http://www.springframework.org/schema/context/ http://www.springframework.org/schema/context//spring-context-2.5.xsd">

     <context:component-scan base-package="com.geeksforgeeks.spring" />

    <bean id="tutorial" class="com.geeksforgeeks.spring.Tutorial">
        <property name="topicsList">
           <ref local="javaCore" />
           <ref local="scalaBasics" />
        </property>
    </bean>
        
    <bean id="javaCore" class="com.geeksforgeeks.spring.Topic">
        <property name="name" value="JavaCore" />
    </bean>
    
    <bean id="scalaBasics" class="com.geeksforgeeks.spring.Topic">
        <property name="name" value="ScalaBasics" />
    </bean>    
    
    <bean id="training" class="com.geeksforgeeks.spring.Training">
        <property name="topic" value="#{tutorial.topicsList[1]}"/>
    </bean>
    
</beans>
```
The `#{tutorial.topicsList[1]}` is used to set the topic of the training bean.

### Annotation Based Configuration
```java
package com.geeksforgeeks.spring;
 
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
 
@Getter
@Setter
public class Training 
{
    //getters and setters
    private Topic topic;
     
    @Value("#{tutorial.topicsList[0]}")
    private Topic defaultTopic;

}
```

## Spring Expression Language Parser
Using the expression parser, the SpEL may also be utilized as a standalone component.

```text
org.springframework.expression.spel.standard.SpelExpressionParser.
```

```java
package com.geeksforgeeks.spring;

import java.util.Arrays;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
 
public class SpringExpressionParserExample {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Just a string value'");
        String message = (String) exp.getValue();
        System.out.println(message);
         
        System.out.println(parser.parseExpression("'Just a string value'.substring(5)").getValue());
         
        System.out.println(parser.parseExpression("'Just a string value'.length()").getValue());
         
        System.out.println(parser.parseExpression("'Just a string value'.substring('Just '.length())").getValue());        
    }
}
```

```text
Output:
Just a string value
a string value
19
a string value
```

## Access JavaBean Properties using Spring ExpressionParser

```java
// Java Program to Illustrate Spring Expression Parser

package com.geeksforgeeks.spring;

// Importing required classes
import java.util.Arrays;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

// Class
public class SpringExpressionParserExample {

    // Main driver method
    public static void main(String[] args)
    {

        SpelExpressionParser parser
            = new SpelExpressionParser();
        Expression exp = parser.parseExpression(
            "'Just a string value'");
        String message = (String)exp.getValue();

        // Print commands
        System.out.println(message);

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.substring(5)")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.length()")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.substring('Just '.length())")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.class")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.bytes")
                .getValue());
    }
}
```

```text
Output:
Just a string value
a string value
19
a string value
class java.lang.String
[B@543c6f6d
```

## Calling Constructor using Spring ExpressionParser
```java
// Java Program to Illustrate Spring Expression Parser

package com.geeksforgeeks.spring;

// Importing required classes
import java.util.Arrays;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

// Class
public class SpringExpressionParserExample {

    // Main driver method
    public static void main(String[] args)
    {

        SpelExpressionParser parser
            = new SpelExpressionParser();
        Expression exp = parser.parseExpression(
            "'Just a string value'");
        String message = (String)exp.getValue();
        System.out.println(message);

        // Print commands
        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.substring(5)")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.length()")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.substring('Just '.length())")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.class")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "'Just a string value'.bytes")
                .getValue());

        System.out.println(
            parser
                .parseExpression(
                    "new com.geeksforgeeks.spring.Topic('Java')")
                .getValue(Topic.class)
                .getClass());
    }
}
```

```text
Output:
Just a string value
a string value
19
a string value
class java.lang.String
[B@543c6f6d
class com.geeksforgeeks.spring.Topic
```