# Generics [↑](../../README.md#intermediate-java-fundamentals)

- [Generic Interfaces](#generic-interfaces-)
- [Generic Methods](#generic-methods-)
- [Raw Types](#raw-types-)
- [Multiple Type Parameters](#multiple-type-parameters-)
- [Upper Bounds](#upper-bounds-)
- [Wildcards](#wildcards-)
- [Lower Bounds for Wildcards](#wildcard-lower-bounds)

------

- Generics allows the creation of generic classes and methods by specifying a _type parameter_.

```java
public class Box<T> {
    private T data;
    
    //Constructor
    public Box(T data) {
        this.data = data;
    }
    
    //Getter
    public T getData() {
        return this.data;
    }
    
}
```
A simple generic `Box` class with a type parameter `T`. All class methods perform under this
class performs around the `T`-type parameter.

```java
Box<String> myStringBox = new Box<>("Apple");
Box<Integer> myIntBox = new Box<>(3);
```

### Good to know and Best practices
- Type parameter must be specified within the diamond operator `<>` after the `class` name.
- The type parameter `T`, is similar to a method parameter but instead receives a class or
  interface type as an argument as opposed to a reference or primitive type.
- When defining a type parameter, it is best practice to make them single, uppercase letters to
  be easily distinguished. By convention,
    - `E` : Elements
    - `K`: Key
    - `N`: Number
    - `T`: Type
    - `V`: Value
    - `S, U, V`: For multiple types
- Before Java7, the constructor for generic references are like `Box<String> myStringBox = new Box<String>("Apple");`
- Generic does not accept primitive types (int, short, long, byte, float, double, boolean, etc.).
  Therefore, a _Wrapper Class_ should be used instead.
- Avoid raw types implementation to avoid "incompatible type" errors.

### Autoboxing
- Allows wrapper classes to take primitive values and convert them to their corresponding
  wrapper object by automatically calling the `valueOf()` method.
- The value can also be converted back to its primitive type using `integerWrapper.intValue()`;

## Generic Interfaces [↑](#generics-)

```java
public interface Replacer<T>{
    void replace(T data);
}
```

- A generic interface is created like a generic class where the type parameter must be appended
  to the interface name.
- Interface methods declaration are similar to non-generic interfaces and can include
  non-generic methods as well.

### Generic Classes implementing an Interface
```java
public class Box <T> implements Replacer<T> {
    private T data;
    
    @Override
    void replace(T data) {
        this.data = data;
    }
}
```

The code below shows the generic class that implements a generic interface is constructed.

```java
Replacer<Integer> boxReplacer = new Box<>();
```

### Non-Generic Classes implementing an Interface
```java
public class StringBag implements Replacer<T> {
    private String data;
    
    @Override
    void replace(String data) {
        this.data = data;
    }
}
```

The code below shows how the non-generic class that implements a generic interface is constructed.
```java
Replacer<String> bagReplacer = new StringBag();
```

## Generic Methods [↑](#generics-)
- It is also possible to make a generic method instead of the whole class being generic.
- In creating a generic method, it is important to note that the generic type should be
  indicated before the return type.

```java
public class StringBox {
  private String data;

  public /*static*/ <T> boolean isString(T item) {
    return item instanceof String; 
  }
  
  public static void main(String[] args) {
      StringBox box = new StringBox("test");
      box.isString(5); //returns false
  }
}
```
- The `isString()` method accepts a parameter of any type (T-type).
- The same format can also be done for static methods.

## Raw Types [↑](#generics-)
- Below is an example of a class being instantiated as a raw type.

```java
public class Box <T> {
  private T data;

  public Box(T data) {
    this.data = data; 
  }

  public T getData() {
    return this.data;
  }  
}

public static void main(String[] args) {
  Box box = new Box<>("My String");  // Raw type box
  String s2 = (String) box.getData();  // No incompatible type error
  String s1 = box.getData();  // Incompatible type error
}
```

- This implementation should be avoided due to the following reasons:
    - Avoid incompatible type errors.
    - Avoid potential runtime `ClassCastException` error when type-casting explicitly.
    - Generics give compile-time type checking, which helps detect bugs before code runs.
    - Generics helps when the JVM applies type erasures.


## Multiple Type Parameters [↑](#generics-)
```java
public class Box <T, S> {
  private T item1;
  private S item2;
  // Constructors, getters, and setters
}
Box<String, Integer> wordAndIntegerBox = new Box<>("Hello", 5);
```

### Interfaces and Methods
Multiple type parameters can also be done on interfaces and methods.
```java
public class Util {
    public static <T, S> boolean areNumbers(T item1, S item2) {
        return item1 instanceof Number && item2 instanceof Number;
    }
}
```

## Upper Bounds [↑](#generics-)
- When there is a need to restrict what class or interface could be used as a type argument.
- Restricts a generic type to be a specific type or any type that `extends` it.

```java
public class Box <T extends Number> {
    private T data;
}
```
A type parameter `T` was defined and added an upper bound type `Number` for `T`.

This means that `T` can be a `Number` or any of its subclasses (or interfaces).


### Upper Bounds on Generic Methods
```java
public static <T extends Number> boolean isZero(T data) {
    return data.equals(0);
}
```

### Multiple Bounded Parameter
It is also allowed to have multiple bounds implemented.

```java
public class Box <T extends Number & Comparable<T>> {
    private T data;
}
```
- A multiple bounds was imposed on `T` type parameter using the `&` operator.
- It is important to note that when defining multiple bounds, any upper bound that is a `class`
  must come first followed by any interfaces.


## Wildcards [↑](#generics-)
- denoted by `?` symbol represents an unknown type.
- Makes the structure even more general and used when there is no need for a strict type checking.

```java
public class Util {
    
    public static void printBag(Bag<?> bag) {
        System.out.println(bag.toString());
    }
    
    public static void main(String[] args) {
        Bag<String> myBag1 = new Bag("Hello");
        Bag<Integer> myBag1 =  new Bag(23);
        Util.printBag(myBag1); // Hello
        Util.printBag(myBag2); // 23
    }
}
```

Wildcards can also have own upper and lower bounds.

```java
public static void printBag(Bag<? extends Number> bag) {
    System.out.println(bag.toString());
}
```

## Wildcard Lower Bounds
- Lower bound can also be had when working with wildcards.
- Restricts a wildcard to a class or interface **and any of its parent types**.

```java
public class util {
    public static getBag(Bag<? super Integer> bag) {
        return bag;
    }
} 
```
The type parameters allowed for this case is `Integer`, `Number`, or `Object`.

When a `Boolean` type is used, this will result in an error.

### Important Notes:
- Lower bounds can only be used for wildcards.
- A wildcard cannot have both upper and lower bounds.


### Summary
- An upper bound wildcard should be used when the variable is being used to serve some type of
  data to the code.
- A lower bound wildcard should be used when the variable is receiving data and holdting it for
  later use.
- When a variable that serves data is used and only uses `Object` methods, an unbounded wildcard
  is preferred.
- When a variable needs to serve data and store data for later use, use a type parameter instead
  of a wildcard.

