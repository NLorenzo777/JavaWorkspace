# Serialization in Java  [↑](../../README.md#intermediate-java-fundamentals)
- [Serializable Interface](#the-serializable-interface-)
- [Serializable Fields](#serializable-fields-)
- [Serializing Reference Types](#serializing-associated-reference-type-fields-)
- [Custom Serialization](#custom-serialization-)

One of the benefits of using objects is the ability to encapsulate state (or data) to use within
a program.

**Serializing** objects stores an object's state in a file which can be transferred in a network.

## Serialization
- Taking an object's state and transforming it into a _stream of bytes_.
    - `Stream:` an abstract definition of a sequence of data that is made available over time.
    - `Byte:` 8 bit group of data
    - `Stream of Byte:` a sequence of bytes that is made available over time.

- To serialize an object, its fields and their types are stored in the form of bytes. These
  bytes are then able to written to memory, a file, a database, or sent over a network with
  all the information necessary to recreate the object.

## Deserialization
- Converts a stream of bytes back into an object.
- Using both serialization and deserialization gives the flexibility to persist objects and get
  them back when needed.

---
`IMPORTANT!`
- The stream of bytes created from Serialization only includes the member variables of an object
  and not its methods.
- Deserialization creates a copy of the original object. This copy shares the same state but is
  an entirely new object in memory.

---

## The Serializable Interface [↑](#serialization-in-java-)
- An interface describes the behavior a class.
- By having a class implement `Serializable` it can be serialized by the Java Virtual Machine (JVM).
- `Serializable` is a **market interface**. A marker interface provides run time information to
  the JVM about the class and does not have any methods associated with it.
- It is important for the implementing class to provide a `serialVersionUID`.

```java
import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
  private String name;
  private int age;
  @Serial
  private static final long serialVersionUID = 1L;
}
```
The `serialVersionUID` acts as an identified for the JVM to choose the proper class to convert a
stream of bytes back into an object.

## Serializable Fields  [↑](#serialization-in-java-)
- JVM defines a default way of serializing objects. This default **includes ignoring static class
  fields** which belong to a class and not an object.
- JVM also serializes all fields in an object, even those marked `private` and `final`.
- A field marked as `transient` will have its value ignored during serialization and instead
  receive the default value for that type of field.
- A static field belongs to the class and not to the object.

## Serializing Associated (Reference Type) Fields  [↑](#serialization-in-java-)
- For reference types to be serializable, they must also implement the `Serializable` interface.
- If a reference type does not implement serializable, a `NotSerializableException` is thrown.
- When JVM encounters a reference type, it will serialize the reference type first before trying
  to serialize the encapsulating object.

## Custom Serialization  [↑](#serialization-in-java-)
```java
public class DateOfBirth {
  private int month;
  private int day;
  private int year;

  // constructors and getters
}

public class Person implements Serializable {
  private String name;
  private DateOfBirth dateOfBirth;

  private void writeObject(java.io.ObjectOutputStream stream) throws IOException{
    stream.writeObject(this.name);
    stream.writeInt(this.dateOfBirth.getMonth());
    stream.writeInt(this.dateOfBirth.getDay());
    stream.writeInt(this.dateOfBirth.getYear());
  }

  private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
    this.name = (String) stream.readObject();
    int month = stream.readInt();
    int day = stream.readInt();
    int year = stream.readInt();
    this.dateOfBirth = new DateOfBirth(month, day, year);
  } 
}
```




## Methods
Below are the following methods used in conducting serialization and deserialization.

### `FileOutputStream(String filePath)`
- Constructor method for `FileOutputStream` class.
- Helper method to write serialized object to a file.
- Establish a stream that points towards a certain file.
```java
FileOutputStream fileOutputStream = new FileOutputStream("fileName.txt");
```
----------
### `ObjectOutputStream(FileOutputStream stream)`
- Constructor method for `ObjectOutputStream` class.
- Helper method to write serializable object to an output stream.

```java
ObjectOutputStream objectOutputStream = new objectOutputStream(fileOutputStream);
```
- `writeObject(Obj obj)`: serializes a passed object to a specified output stream.

----------

### `FileInputStream(String filePath)`
- A constructor method for the `FileInputStream` class.
- Helper method used to read a file and loads it in a stream.

```java
FileInputStream fileInputStream = new FileInputStream("filename.txt");
```

----------
### `ObjectInputStream(fileInputStream stream)`
- Constructor method for the ObjectInputStream class.
- Helps read a stream containing the serialized object in bytes.

```java
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
```
----------
### `.readObject()`
- Translate an ObjectInputStream instance to an object.
- `returns:` An Object that needs to be cast.

```java
Person michaelCopy = (Person) objectInputStream.readObject();
```
