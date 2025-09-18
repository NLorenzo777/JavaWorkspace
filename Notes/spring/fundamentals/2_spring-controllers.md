# Spring Controllers

## Mapping Requests in Spring
- In order to provide a response to a request in a REST architecture, the server maps the request to an endpoint.
- In Spring, a class is marked as a controller and each of its methods is associated with an endpoint. This method is called to formulate a response to each request.

### The `@RestController` Annotation
- annotation used to declare a class as a controller that provide application-specific types of data as part of an HTTP.
- this annotation should be added to each class that will handle responses to HTTP requests.
- This annotation combines two (2) separate annotations:
  1. `@Controller`: used to make a class identifiable to Spring as a component of the web application.
  2. `@ResponseBody`: tells Spring to convert the return values of a controller's methods to JSON and bind that JSON to the HTTP response body.

### The `@RequestMapping` Annotation
- annotation used to wire request types and endpoints to specific class methods
- Accepts several arguments:
    1. `path` argument
        - The most important.
        - Used to determine where requests are mapped.
    2. `method` argument: Allows developer to specify which HTTP method should be used when accessing the controller method.
    3. `params` argument: filters requests based on given parameters. e.g. (`RequestMethod.GET`, `.POST`, `.PUT`, .`DELETE`)
    4. `consumes` argument: used to specify which media type can be consumed - some common media types are `"text/plain"`, `"application/JSON"`.

## Defining Base Paths
- Using `@RequestMapping` annotation at the class level.
- When this annotation is used at the class level, the specified path argument will become the base path.

```java
@RestController
@RequestMapping("/books")
public class VirtualLibrary
{
  @RequestMapping(path = "/thumbnails", method = RequestMethod.GET)
  public String[] getBookThumbnails() {
    //returns thumbnails for all available titles
  }
}
```
In this example, a class with the data annotation `@RequestMapping("/books")` will map all appropriate requests to this class, and in this case, 
`“/books”` becomes the base path. Methods in this class can be further mapped, as shown in the previous exercise. 
In the example shown below, `“/books”` is now the base path and the getBookThumbnails method is associated with the endpoint `“/books/thumbnails”`

## Using HTTP Method Annotations
- The `method` argument for `@RequestMapping` is optional. If this was not indicated, the default method is a `GET` method.
- Below are the HTTP Method Annotations:
  - `@GetMapping`
  - `@PostMapping`
  - `@PutMapping`
  - `@DeleteMapping`

```
@RequestMapping("/about", method = RequestMethod.GET)
```

is equal to

```
@GetMapping("/about")
```

## Using Query Parameters
- The `@RequestParam` annotation is used for Query Parameters.

```text
libraryapp.com/book?author_count=2&published_year=1995
```

The `author_count` and `published_year` values would map to the method parameters as follows:

```java
@GetMapping("/book")
public Book isBookAvailable(@RequestParam int author_count, @RequestParam int published_year) {
  return books.find(author_count, published_year);
}

```

## Template Path Variables
- For a more specific entities (such as IDs), the `@PathVariable` can be used.

```text
/books/{id}
```

```text
localhost:4001/books/28937
```

```java
@GetMapping("/{id}")
public Book isBookAvailable(@PathVariable int id)  {
  return book.findByID(id);
}

```

## Deserializing Objects
- There are time when the requests received are more complex in a way that an entire form object is used as a parameter.
- For object as a parameter, the `@RequestBody` annotation is used.

```java
@GetMapping("/book")
public Book isBookAvailable(@RequestBody Book book) {
  return book.find(book.authorCount, book.publishedYear);
}

```

This can be triggered by doing a curl with data containing the members (correct type) of the expected object.

```bash
curl -X POST --data '{\"authorCount\": \"2\", \"publishedYear\": \"1995\"}' "https://localhost:8080/.../book"
```
