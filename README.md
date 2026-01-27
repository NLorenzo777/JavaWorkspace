# Java Workspace
Repository for learning Java continuously which contains some information on basic to advanced topics related to the language.

`Disclaimer:` This repository does not intend to replicate existing content. The sole
purpose of this repository is to easily access learning progress for review.

## Quick Links:

## HOW TOs:
- [Configuring a Springboot Repository](Notes/how-tos/configuring-a-repository.md)

## Java Fundamentals

<html lang="eng">
  <div align="center">
    <table>
      <tr>
        <th>Intermediate Java</th>
        <th>Advanced Java</th>
        <th>Data Structures</th>
      </tr>
      <tr>
        <td><a href="Notes/intermediate/1_InputAndOutput.md">Input and Output (I/O)</a></td>
        <td><a href="Notes/advance/1_Parallel-and-Concurrent-Programming.md">Parallel and Concurrent Programming</a></td>
        <td><a href="src/main/java/org/datastructures/nodes">Nodes</a></td>
      </tr>
      <tr>
        <td><a href="Notes/intermediate/2_Serialization.md">Serialization</a></td>
        <td><a href="Notes/advance/2_Servlets.md">Servlets</a></td>
        <td><a href="src/main/java/org/datastructures/linkedlist">LinkedList</a></td>
      </tr>
      <tr>
        <td><a href="Notes/intermediate/3_Generics.md">Generics</a></td>
        <td><a href="Notes/advance/3_Sockets.md">Sockets</a></td>
        <td><a href="src/main/java/org/datastructures/queue">Queue</a></td>
      </tr>
      <tr>
        <td><a href="Notes/intermediate/4_Collections.md">Collections</a></td>
        <td></td>
        <td><a href="src/main/java/org/datastructures/stack">Stacks</a></td>
      </tr>
      <tr>
        <td><a href="Notes/intermediate/5_Nested-Classes.md">Nested Classes</a></td>
        <td></td>
        <td><a href="src/main/java/org/datastructures/hashmap">Hashmaps</a></td>
      </tr>
      <tr>
        <td><a href="Notes/intermediate/6_Threading.md">Threading</a></td>
        <td></td>
        <td><a href="src/main/java/org/datastructures/trees">Trees</a></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td><a href="src/main/java/org/datastructures/graph">Graphs</a></td>
      </tr>
    </table>
  </div>
</html>

## Spring Framework
<html lang="eng">
  <div align="center">
    <table>
      <tr>
        <th colspan="3">Spring Basics</th>
      </tr>
      <tr>
        <td colspan="3"><a href="Notes/spring/fundamentals/2_spring-controllers.md">Spring Framework Introduction</a></td>
      </tr>
      <tr>
        <td colspan="3"><a href="Notes/spring/fundamentals/1_2_spring-architecture.md">Spring Architecture</a></td>
      </tr>
      <tr>
        <th colspan="2">Core Spring</th>
        <th>Spring Annotations</th>
      </tr>
      <tr>
        <td colspan="2"><a href="Notes/spring/fundamentals/2_1_IoC.md">Inversion of Control</a></td>
        <td><a href="Notes/spring/annotations/1_ComponentScan.md">@ComponentScan</a></td>
      </tr>
      <tr>
        <td colspan="2"><a href="Notes/spring/fundamentals/2_2_BeanFactory.md">BeanFactory</a></td>
        <td>
          <div><a href="Notes/spring/annotations/2_Component.md">@Component</a></div>
          <div>
            <ul>
              <li><a href="Notes/spring/annotations/2_1_Service.md">@Service</a></li>
              <li><a href="Notes/spring/annotations/2_2_Controller.md">@Controller</a></li>
              <li><a href="Notes/spring/annotations/2_3_Repository.md">@Repository</a></li>
            </ul>
          </div>
        </td>
      </tr>
      <tr>
        <td colspan="2"><a href="Notes/spring/fundamentals/2_4_Dependency-Injection.md">Dependency Injection</a></td>
        <td><a href="Notes/spring/annotations/3_Configuration.md">@Configuration</a></td>
      </tr>
      <tr>
        <td colspan="2"><a href="Notes/spring/fundamentals/2_5_Bean-Lifecycle.md">Bean Lifecycle</a></td>
        <td><a href="Notes/spring/annotations/4_Value.md">@Value</a></td>
      </tr>
      <tr>
        <td colspan="2"><a href="Notes/spring/fundamentals/2_6_Bean-Scopes.md">Bean Scopes</a></td>
        <td><a href="Notes/spring/annotations/5_Autowired.md">@Autowired</a></td>
      </tr>
      <tr>
        <td colspan="2"><a href="Notes/spring/fundamentals/2_7_SpEL.md">Expression Language (SpEL)</a></td>
        <td><a href="Notes/spring/annotations/6_Qualifier.md">@Qualifier</a></td>
      </tr>
      <tr>
        <td class="wip" colspan="2"><a href="Notes/spring/fundamentals/">RowMapper and ResultSetExtractor</a></td>
        <td></td>
      </tr>
      <tr>
        <th>Spring Boot</th>
        <th>Spring MVC</th>
        <th>Spring with REST API</th>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/1_springboot.md">Spring Boot Introduction</a></td>
        <td><a href="Notes/spring/springmvc/1_Introduction.md">Spring MVC Introduction</a></td>
        <td><a href="Notes/spring/springRestAPI/1_rest-controller.md">REST Controller</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/2_application-properties.md">Application Properties</a></td>
        <td><a href="Notes/spring/springmvc/2_java-based-configuration.md">Java Based Configurations</a></td>
        <td><a href="Notes/spring/springRestAPI/2_restful-web-services.md">RESTful Web Services</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/3_dependency-management.md">Dependency Management</a></td>
        <td></td>
        <td><a href="Notes/spring/springRestAPI/3_rest-json-response.md">JSON REST Response</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/4_starters.md">Starter Dependencies</a></td>
        <td></td>
        <td><a href="Notes/spring/springRestAPI/4_rest-xml-response.md">XML REST Response</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/5_exception-handling.md">Exception Handling</a></td>
        <td></td>
        <td><a href="Notes/spring/springRestAPI/5_jackson-integration.md">Jackson Integration</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/6_actuator.md">Actuators</a></td>
        <td></td>
        <td><a href="Notes/spring/springRestAPI/6_rest-template.md">RestTemplate</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springboot/7_JDBC-vs-DataJDBC.md">Spring JDBC and Spring Data JDBC</a></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <th>Spring Data JPA</th>
        <th>Spring JDBC</th>
        <th></th>
      </tr>
      <tr>
        <td><a href="Notes/spring/springdatajpa/1_introduction.md">Introduction</a></td>
        <td><a href=""></a></td>
        <td><a href=""></a></td>
      </tr>
      <tr>
        <td>
          <div><a href="Notes/spring/springdatajpa/2_annotations.md">Annotations</a></div>
          <div>
            <ul>
              <li><a href="Notes/spring/springdatajpa/2_annotations.md#the-table-annotation-">@Table</a></li>
              <li><a href="Notes/spring/springdatajpa/2_annotations.md#the-column-annotation-">@Column</a></li>
              <li><a href="Notes/spring/springdatajpa/2_annotations.md#the-id-and-generatedvalue-annotation-">@Id</a></li>
            </ul>
          </div>
        </td>
        <td><a href=""></a></td>
        <td><a href=""></a></td>
      </tr>
    </table>
  </div>
</html>

### IX. Spring JDBC
Spring JDBC provides a simple template-based API for database interaction

## gRPC (Remote Procedure Calls)
- [Introduction](Notes/gRPC/grpc_introduction.md)
- [Client/Server Setup](Notes/gRPC/)


[//]: # (- [2. Spring Controllers]&#40;&#41;)

[//]: # (- [3. Spring Beans]&#40;Notes/spring/fundamentals/3_Spring-Bean.md&#41;)

[//]: # (- [4. Spring Boot]&#40;Notes/spring/fundamentals/4_Spring-Boot.md&#41;)

[//]: # ()
[//]: # (### I. Spring Basics)

[//]: # (- [1.1. Spring Framework Introduction]&#40;Notes/spring/fundamentals/1_1_spring-introduction.md&#41;)

[//]: # (- [1.2. Spring Architecture]&#40;Notes/spring/fundamentals/1_2_spring-architecture.md&#41;)

[//]: # ()
[//]: # (### II. Core Spring)

[//]: # (- [2.1. Inversion of Control]&#40;Notes/spring/fundamentals/2_1_IoC.md&#41;)

[//]: # (- [2.2. BeanFactory]&#40;Notes/spring/fundamentals/2_2_BeanFactory.md&#41;)

[//]: # (- [2.3. ApplicationContext]&#40;Notes/spring/fundamentals/2_3_ApplicationContext.md&#41;)

[//]: # (- [2.4. DependencyInjection]&#40;Notes/spring/fundamentals/2_4_Dependency-Injection.md&#41; `WORK IN PROGRESS`)

[//]: # (- [2.5. Bean Lifecycle]&#40;Notes/spring/fundamentals/2_5_Bean-Lifecycle.md&#41;)

[//]: # (- [2.6. Bean Scopes]&#40;Notes/spring/fundamentals/2_6_Bean-Scopes.md&#41;)

[//]: # (- [2.7. Expression Language &#40;SpEL&#41;]&#40;Notes/spring/fundamentals/2_7_SpEL.md&#41;)

[//]: # (- [2.8 RowMapper and ResultSetExtractor]&#40;&#41; `WORK IN PROGRESS`)

[//]: # (### III. Spring Annotations)

[//]: # (Spring Annotations are a form of metadata that provides data about a program. )

[//]: # (Annotations are used to provide supplemental information about a program.)

[//]: # (It does not have a direct effect on the operation of the code they annotate.)

[//]: # ()
[//]: # (- [@ComponentScan]&#40;Notes/spring/annotations/1_ComponentScan.md&#41;)

[//]: # (- [@Component]&#40;Notes/spring/annotations/2_Component.md&#41;)

[//]: # (  - [@Service]&#40;Notes/spring/annotations/2_1_Service.md&#41;)

[//]: # (  - [@Controller]&#40;Notes/spring/annotations/2_2_Controller.md&#41;)

[//]: # (  - [@Repository]&#40;Notes/spring/annotations/2_3_Repository.md&#41;)

[//]: # (- [@Configuration]&#40;Notes/spring/annotations/3_Configuration.md&#41;)

[//]: # (- [@Value]&#40;Notes/spring/annotations/4_Value.md&#41;)

[//]: # (- [@Autowired]&#40;Notes/spring/annotations/5_Autowired.md&#41;)

[//]: # (- [@Qualifier]&#40;Notes/spring/annotations/6_Qualifier.md&#41;)

[//]: # (### IV. Spring Boot)

[//]: # (Simplified application setup with autoconfiguration, embedded servers and production-ready tools)

[//]: # (- [4.1. Introduction]&#40;Notes/spring/springboot/1_springboot.md&#41;)

[//]: # (- [4.2. Application Properties]&#40;Notes/spring/springboot/2_application-properties.md&#41;)

[//]: # (- [4.3. Dependency Management]&#40;Notes/spring/springboot/3_dependency-management.md&#41;)

[//]: # (- [4.4. Starters]&#40;Notes/spring/springboot/4_starters.md&#41;)

[//]: # (- [4.5. Exception Handling]&#40;Notes/spring/springboot/5_exception-handling.md&#41;)

[//]: # (- [4.6. Actuators]&#40;Notes/spring/springboot/6_actuator.md&#41;)

[//]: # (- [4.7. Spring JDBC and Spring Data JDBC]&#40;Notes/spring/springboot/7_JDBC-vs-DataJDBC.md&#41;)

[//]: # ()
[//]: # (### V. Spring MVC)

[//]: # (Spring MVC helps build web applications using the Model-View-Controller design pattern.)

[//]: # (- [5.1. Introduction]&#40;Notes/spring/springmvc/1_Introduction.md&#41;)

[//]: # (- [5.2. Java-based Configuration]&#40;Notes/spring/springmvc/2_java-based-configuration.md&#41;)

[//]: # (- `[WORK IN PROGRESS]`)

[//]: # ()
[//]: # (### VI. Spring with REST API)

[//]: # (Spring's support for RESTful web services allows developers to create robust APIs that can be consumed by various clients.)

[//]: # (- [6.1. REST Controller]&#40;Notes/spring/springRestAPI/1_rest-controller.md&#41;)

[//]: # (- [6.2. RESTFul Web Services]&#40;Notes/spring/springRestAPI/2_restful-web-services.md&#41;)

[//]: # (- [6.3. REST JSON Response]&#40;Notes/spring/springRestAPI/3_rest-json-response.md&#41;)

[//]: # (- [6.4. REST XML Response]&#40;Notes/spring/springRestAPI/4_rest-xml-response.md&#41;)

[//]: # (- [6.5. Jackson Integration]&#40;Notes/spring/springRestAPI/5_jackson-integration.md&#41;)

[//]: # (- [6.6. RestTemplate]&#40;Notes/spring/springrestAPI/6_rest-template.md&#41;)

### VII. Spring Data JPA
Spring Data JPA makes it easy to implement JPA-based repositories with minimal boilerplate code
- [7.1. Introduction](Notes/spring/springdatajpa/1_introduction.md)
- [7.2. Annotations](Notes/spring/springdatajpa/2_annotations.md)
  - [`@Table` Annotation](Notes/spring/springdatajpa/2_annotations.md#the-table-annotation-)
  - [`@Column` Annotation](Notes/spring/springdatajpa/2_annotations.md#the-column-annotation-)
  - [`@Id` Annotation](Notes/spring/springdatajpa/2_annotations.md#the-id-and-generatedvalue-annotation-)

### IX. Spring JDBC
Spring JDBC provides a simple template-based API for database interaction
