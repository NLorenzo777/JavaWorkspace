# Java Workspace
Repository for learning Java continuously which contains some information on basic to advanced topics related to the language.

`Disclaimer:` This repository does not intend to replicate existing content. The sole
purpose of this repository is to easily access learning progress for review.

## Quick Links:
- [Spring JDBC Samples](Notes/spring/springJDBC/1_Introduction.md#jdbc-template-queries)
- [Some Important Annotations (@Data, @Entity, @Id, and Constructor Annotations)](Notes/spring/springboot/5_exception-handling.md#creating-a-jpa-entity-class)

## HOW TOs:
- [Configuring a Springboot Repository](Notes/how-tos/configuring-a-repository.md)
- [Creating a SQL Stored procedure](Notes/how-tos/sql-stored-procedure.md)
- [Creating a PostgreSQL Database Cluster for local setup](Notes/how-tos/)
- [Setting and Using of Application Properties](Notes/how-tos/setting-and-using-application-properties.md)

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
        <td><a href="Notes/spring/springboot/8_TransactionManagement.md">Transactions Management</a></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <th>Spring Data JPA</th>
        <th>Spring JDBC</th>
        <th>Spring ORM (Hibernate Integration)</th>
      </tr>
      <tr>
        <td><a href="Notes/spring/springdatajpa/1_introduction.md">Introduction</a></td>
        <td><a href="Notes/spring/springJDBC/1_Introduction.md">Introduction</a></td>
        <td><a href="Notes/spring/springORMHibernate/1_SpringHibernateConfiguration.md">Basic Configuration</a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springdatajpa/2_annotations.md">Annotations</a></td>
        <td><a href="Notes/spring/springJDBC/2_PreparedStatement.md">Prepared Statement JDBC Template</a></td>
        <td><a href="Notes/spring/springORMHibernate/2_JPAvsHibernate.md">JPA vs Hibernate</a></td>
      </tr>
      <tr>
        <td><a href=""></a></td>
        <td><a href="Notes/spring/springJDBC/3_NamedParameter.md">NamedParameter JDBC Template</a></td>
        <td><a href="Notes/spring/springORMHibernate/3_SpringORMExample.md">Spring ORM Hibernate Example</a></td>
      </tr>
      <tr>
        <td><a href=""></a></td>
        <td><a href="Notes/spring/springJDBC/4_SQLScripts.md">SQL Scripts</a></td>
        <td><a href="Notes/spring/springORMHibernate/4_Mappings.md">Mappings</a></td>
      </tr>
      <tr>
        <td><a href=""></a></td>
        <td><a href="Notes/spring/springJDBC/5_ResultSetExtractor.md">The ResultSetExtractor Interface</a></td>
        <td><a href="Notes/spring/springORMHibernate/5_Eager-and-Lazy-Loading.md">Eager/Lazy Loading</a></td>
      </tr>
      <tr>
        <td><a href=""></a></td>
        <td><a href=""></a></td>
        <td><a href="Notes/spring/springORMHibernate/6_Pagination.md">Pagination</a></td>
      </tr>
      <tr>
        <td><a href=""></a></td>
        <td><a href=""></a></td>
        <td><a href="Notes/spring/springORMHibernate/7_Batch-Processing.md">Batch Processing</a></td>
      </tr>
      <tr>
        <th>Spring AOP</th>
        <th>Spring Security</th>
        <th></th>
      </tr>
      <tr>
        <td><a href="Notes/spring/springAOP/1_Introduction.md">Introduction</a></td>
        <td><a href="Notes/spring/springSecurity/1_Introduction.md">Introduction</a></td>
        <td><a href=""></a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springAOP/2_AOP-Around-Advice.md">@Around Advice</a></td>
        <td><a href="Notes/spring/springSecurity/2_Important-terms.md">Important Terms</a></td>
        <td><a href=""></a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springAOP/3_AOP-Implementation.md">AOP Implementation</a></td>
        <td><a href="Notes/spring/springSecurity/3_OAuth2.md">OAuth2</a></td>
        <td><a href=""></a></td>
      </tr>
      <tr>
        <td><a href="Notes/spring/springAOP/3_AOP-Implementation.md">AOP Implementation</a></td>
        <td><a href="Notes/spring/springSecurity/4_Method-Level.md">Method Level Security</a></td>
        <td><a href=""></a></td>
      </tr>
    </table>
  </div>
</html>

## System Designs

### Apache Kafka
- [Kafka Basics](Notes/system-designs/kafka/kafka_summary.md)

## gRPC (Remote Procedure Calls)
- [Introduction](Notes/gRPC/grpc_introduction.md)
- [Client/Server Setup](Notes/gRPC/)

## Artificial Intelligence (AI) Learning

### Google Generative AI Leader
- [I. Foundational Concepts](Notes/AI/Google-Gen-AI-Leader/1_Foundational-Concepts.md)
- [II. Gen AI Landscape](Notes/AI/Google-Gen-AI-Leader/2_Gen-AI-Landscape.md)
- [III. Introduction to Gen AI Applications](Notes/AI/Google-Gen-AI-Leader/3_Introduction-to-Gen-AI-Apps.md)
- [IV. Generative AI Agents](Notes/AI/Google-Gen-AI-Leader/4_Gen-AI-Agents.md)

## Mainframe Learning

### IBM Apptio Sales Foundation
- [I. IBM Apptio Level 1 (ITFM)](Notes/mainframe/1_IBM-Apptio-Sales-Foundation/1_ITFM-Level-1.md)
- [II. IBM Apptio Level 2](Notes/mainframe/2_Apptio-Level-2/2_Apptio-Level-2.md)