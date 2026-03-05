# Hibernate - Pagination [↑](../../../README.md#spring-framework)

## Pagination
- The process of dividing a large set of data into a smaller, more manageable chunks or pages for easier navigation and 
faster loading times.
- It is a most common technique used in web applications to display a large amount of data to users, while providing them
with a way to navigate through the data in a controlled and efficient manner.
- Typically, involves dividing the data into a fixed-size **chunks** or **pages** and then displaying only one page at a time.
- Users then navigate through the pages using links, buttons, or other controls to view additional data.

## Benefits of Pagination
1. **Faster page loading times**
2. **Improved user experience**
3. **Reduced server load**

## Pagination in HQL
- The pagination process in HQL involves using the `setFirstResult()` and `setMaxResults()` methods of the Query interface.
  - `setFirstResult()` specifies the first result to retrieve.
  - `setMaxResults()` specifies the maximum number of results to retrieve.

### The `.setFirstResult(int firstResult)`
- Used in HQL to set the index of the first record to retrieve in a query result set.
- The method takes an integer value as a parameter representing the index of the first record to retrieve.
- The index is zero-based, meaning that the first record has an index of 0.

### The `.setMaxResults(int maxResults)`
- Set the maximum number of records to retrieve in a query result set.
- Takes an integer value as a parameter representing the maximum number of records to retrieve.
- Only the specified number of records will be retrieved from the result set, starting from the index set by the setFirstResult()
method or from the beginning of the result set if the setFirstResult() is not used. 


### HQL - Pagination Process

```java
// Calculate pagination parameters
int pageNumber = 1;
int pageSize = 10;
int firstResult = (pageNumber - 1) * pageSize;

// Create a HQL query to retrieve employees
String hql = "FROM Employee";
Query query = session.createQuery(hql);

// Set pagination parameters
query.setFirstResult(firstResult);
query.setMaxResults(pageSize);

// Retrieve employees from the database
List<Employee> employees = query.list();

// Display employees on the current page
for (Employee employee : employees) {
    System.out.println(employee.getName() + " - " + employee.getSalary());
}
```

## Pagination in JPA
Pagination is already supported in JPA via the `JpaRepository` interface.

The `PagingAndSortingRepository` can be used as well but `JpaRepository` is much recommended.

### Service Layer
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
```

### Controller Layer
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productService.getAllProducts(pageable);
    }
}
```

### Adding Sort mechanisms

#### Single Field Sort
```java
Pageable pageable = PageRequest.of(page, size, Sort.by("price").descending());
```

#### Multiple Fields
```java
Sort sort = Sort.by("price").descending()
                .and(Sort.by("name").ascending());

Pageable pageable = PageRequest.of(page, size, sort);
```