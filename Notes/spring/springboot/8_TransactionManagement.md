# Spring Boot - Transaction Management [↑](../../../README.md#spring-framework)
In enterprise applications, transactions ensure data consistency and integrity.

A **transaction** is a sequence of operations performed as a single logical unit of work. 
Either all operations within a transaction succeed (commit) or none of them do (rollback)

Spring boot simplifies transaction management by using the `@Transaction` annotation, which is built
on top of Spring's declarative transaction management.

## Transaction Management
Transaction Management is the process of coordinating database operations to follow the **ACID** properties.

1. **Atomicity**: All or nothing. Ensure all operations in a transaction are treated as a single unit.
2. **Consistency**: Database remains valid before and after transaction.
3. **Isolation**: Concurrent transactions do not affect each other.
4. **Durability**: Changes persist even after system failures.

#### Example:
In a banking system, if a transfer money is initiated:
- Debit amount from one account.
- Credit amount to another account.

Bot operations should succeed or fail together.

## The `@Transactional` Annotation
- Automatically starts a transaction when a method is called.
- Commits the transaction if the method completes successfully.
- Rolls back the transaction if a runtime exception occurs.
- Reduces boilerplate transaction-handling code.

**Note:** If `spring-boot-starter-data-jpa` is used, Spring Boot auto-configures the transaction management.
Hence, there is no need for the `@EnableTransactionManagement` annotation.
Only use this annotation is not using JPA starter or need custom transaction management.

## Configuring Transaction in Spring boot
Create an application to store user information along with address information and will use spring transaction management
to resolve the transaction break problem.

### Set the Transactional Annotation in the Service class
After configuring the project. Use the `@Transactional` annotation in service layer which will interact with the database.

```java
package com.example.transactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactionmanagement.model.Address;
import com.example.transactionmanagement.model.Employee;
import com.example.transactionmanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private AddressService addressService;
    
    @Transactional(rollbackFor = Exception.class)
    public Employee addEmployee(Employee employee) throws Exception {
        Employee employeeSavedToDB = this.employeeRepository.save(employee);
        
        // Create address for employee
        Address address = new Address();
        address.setAddress("Varanasi");
        address.setEmployee(employee);
        
        // This may throw an exception intentionally for testing rollback
        if (employee.getName().equalsIgnoreCase("error")) {
            throw new RuntimeException("Simulated Exception: Forcing rollback!");
        }
        
        this.addressService.addAddress(address);
        return employeeSavedToDB;
    }
}
```

```java
package com.example.transactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transactionmanagement.model.Address;
import com.example.transactionmanagement.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    public Address addAddress(Address address) {
        return this.addressRepository.save(address);
    }
}
```

### Enable Transaction Management in Main Class
```java
package com.example.transactionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionManagementApplication{

    public static void main(String[] args) {
        SpringApplication.run(TransactionManagementApplication.class, args);
    }
}
```
