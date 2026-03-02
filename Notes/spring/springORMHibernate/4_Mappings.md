# Hibernate - Mappings [↑](../../../README.md#spring-framework)

- [1. One-to-One Mapping](#one-to-one-mapping-)
  - [Unidirectional](#sample-implementation---unidirectional)
  - [Bidirectional](#sample-implementation---bidirectional)
- [2. Many-to-One Mapping](#many-to-one-mapping-)
- [3. One-to-Many Mapping](#one-to-many-mapping-)
- [4. Many-to-Many Mapping](#many-to-many-mapping-)

## One-to-One Mapping [↑](#hibernate---mappings-)

In Hibernate, one-to-one mapping defines a relationship where one entity instance is associated with exactly one instance of another entity.
It represents a real-world relationship such as:
- A person has one passport.
- A student has one college ID.
- A vehicle has one engine.

### Types of One-To-One Mapping
1. **Unidirectional**: Only one entity maintains the reference of the other and not vice versa.
2. **Bidirectional**: Both entities hold references to each other, allowing navigation from either side.


### Sample Implementation - Unidirectional

#### 1. Create the Hibernate Configuration
Assuming that the database is already setup.

```xml
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    <session-factory>
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/hb_one_to_one_mapping?useSSL=false&amp;allowPublicKeyRetrieval=true</property>
        <property name="connection.username">your_username</property>
        <property name="connection.password">your_password</property>
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="show_sql">true</property>
        <property name="current_session_context_class">thread</property>
    </session-factory>
</hibernate-configuration>
```

#### 2. Configure the Maven Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.5.Final</version>
    </dependency>
    
    <!-- Database dependency  -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
    </dependency>
</dependencies>
```

#### 3. Configure the Entity Classes

#### Student.java class
```java
@Entity
@Table(name="student_table")
@Data
public class Student {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    private String name;
    @Column(name="last_name")
    private String lastname;
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_details_table_id")
    private StudentDetails studentDetail;
}
```

#### StudentDetails.java Class
```java
@Data
@Table(name="student_details_table")
@Data
public class StudentDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String college;
    
    @Column(name="no_of_problems_solved")
    private int numberOfProblemsSolved;
}

```

#### 4. Actual implementation

```java
public class AddingEntryDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentDetails.class)
                .buildSessionFactory();
        
        try (factoryl; Session session = factory.getCurrentSession()) {
            Student student = new Student("John", "Doe", "johnDoe@gmail.com");
            StudentDetails details = new StudentDetails("Computer University", 20);
            
            student.setStudentDetail(details);
            
            session.beginTransaction();
            session.save(student); //CascadeType.ALL saves both
            session.getTransaction().commit();
            
            System.out.println("Entry added successfully");
        }
    } 
}
```

#### Update Entry
```java
Student student = session.get(Student.class, 1); // Parameter: 1) Reference Type .class, 2) ID.

student.setEmail("newEmail@gmail.com");
student.getStudentDetail().setNumberOfProblemSolved(40);
session.getTransaction().commit();
```

#### Read Entry
```java
Student student = session.get(Student.class, 1);
System.out.println(student);
System.out.println(student.getStudentGfgDetail());
```

#### Delete Entry
```java
Student student = session.get(Student.class, 1);
session.delete(student); // CascadeType.ALL deletes both
session.getTransaction().commit();
```


### Sample Implementation - Bidirectional

#### 1. Modify the second entity

```java
@Data
@Table(name="student_details_table")
@Data
public class StudentDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String college;
    
    @Column(name="no_of_problems_solved")
    private int numberOfProblemsSolved;
    
    @OneToOne(mappedBy="StudentDetails", cascade=CascadeType.ALL)
    private Student student;
}

```

#### 2. Actual Implementation
```java
public class AddEntryBidirectionalDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentGfgDetail.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {

            Student student = new Student("John", "Doe", "JohnDoe@gmail.com");
            StudentGfgDetail detail = new StudentGfgDetail("University College", 0);

            student.setStudentGfgDetail(detail);
            detail.setStudent(student);

            session.beginTransaction();
            session.save(student); // CascadeType.ALL saves both
            session.getTransaction().commit();

            System.out.println("Bidirectional entry added successfully!");
        }
    }
}
```

## Many-to-One Mapping [↑](#hibernate---mappings-)
When multiple records in one table are associated with a single record in another table.

This type of relationship helps to avoid data redundancy and maintain consistency.

```java
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name ="Foreign_Key_Column")
private String someColumn;
```

## Sample Implementation

### Entities

#### Employee.java
```java
@Data
@Entity
public class Employee {
    @Id private Long id;
    private String name;
    
    //Many employees has one company address
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
```

#### Address.java
```java
@Entity
@Data
public class Address {
    @Id private Long addressId;
    private String location;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Employee> employee = new ArrayList<>();
}
```

## One-to-Many Mapping [↑](#hibernate---mappings-)
One of the common relationships in database where one record in a parent table can be associated 
with multiple records in a child table.

```java
@OneToMany(mappedBy="nameofmappedvariable")
private List<Model> models;
```

### Sample Implementation

#### Parent - Manufacturer.class
```java
@Entity
@Table(name = "manufacturers")
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy="manufacturer", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Model> models;
}
```
- **mappedBy**: Refers to the manufacturer column on the child class.
- **cascade**: Allows update/remove/save of child automatically
- **orphanRemoval**: If the parent is removed, the children are deleted as well.

#### Child - Model.java
```java
@Entity
@Data
@Table(name = "models") 
public class Model {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
```

## Many-to-Many Mapping [↑](#hibernate---mappings-)
A many-to-many relationship occurs when multiple records in one table are associated with multiple
records in another table. For example:

- An employee can have multiple skills.
- A skill can belong to multiple employees.
- An access can be assigned to multiple users. A user can have multiple access levels.