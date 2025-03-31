# Java Fundamentals and Best Practices
- [I. Java I/O](#input-and-output-in-java)
  - [Scanner Class](#the-scanner-class)
  - [FileReader and FileWriter Class](#filereader-and-filewriter-class)
- [II. Serialization](#serialization-in-java)

## Input and Output in Java

### The System class
- From the `java.lang` package.
- Static and cannot be instantiated.
- Has the following fields:
  - ``static PrintStream err``
  - ``static InputStream in``
  - ``static PrintStream out``

---
**NOTE:** 
- Everything that is  contained in the `java.lang` package is automatically imported into every 
  Java program.
- Every Java SDK comes with everything in the `java.base` module. This module is a collection of 
  resources that make Java what it is.
- The other packages contained in `java.base` are `java.util` and `java.io` provide helper 
  functionality that is not necessary to every program therefore has to be imported.
---

### The Scanner Class
- Predefined and built in Java.
- When a Scanner is declared, it needs to be told what type of input it is going to be scanning 
  which is passed through the constructor.

```java
import java.util.Scanner;

// Create a Scanner instance named "input".
// the input scanner takes System.in as type to be scanned.
Scanner input = new Scanner(System.in);
```

- The Scanner breaks up its input using a delimiter (whitespace by default).
- The Scanner acts as a **blocker**. It will block the continued execution of a program until it 
  gets its input.

#### Methods
##### `.next()`
| Variable | Code                                     |
|----------|------------------------------------------|
| String   | `String myString = input.next();`        |
| Int      | `int num = input.nextInt();`             |
| Double   | `Double numDouble = input.nextDouble();` |
| Byte     | `Byte numByte = input.nextByte();`       |
| Boolean  | `Boolean isTrue = input.nextBoolean();`  |
| Long     | `Long numLong = input.nextLong();`       |
| Short    | `Byte numShort = input.nextShort();`     |

#### `.hasNext()`
- Returns a `boolean` that indicates if there is another token left to process.

#### `.hasNextLine()`
- Returns a `boolean` that indicates if there is another line in the input of the defined scanner.

#### `.hasNextInt()`
- Returns a `boolean` that validates if there is another int in the input of the defined scanner.

#### `.useDelimeter(",")`
- Specify the delimiter for the scanner which is used to separate data units.
- Can be specially useful when a program is required to read CSV files.

### FileReader and FileWriter Class
- `FileReader` and `FileWriter` are two built-in input stream classes.
- Useful when working with external files containing text information.
- Throws `IOException` if something goes wrong during the Read/Write process.

```java
import java.io.FileReader;
import java.io.FileWriter;

String filePath = "C:/SampleFolder/input.txt";

// for FileReader
FileReader reader = new FileReader(filePath);

// for FileWriter
FileWriter writer = new FileWriter(filePath);

```

#### Reading a file
- FileReader has a method to validate content and read contents.

`.ready()`
- Make sures that there is a content to read in the buffer stream.

`.read()`
- Read the file one **character** at a time.

```java
import java.io.FileReader;

FileReader reader = new FileReader("C:/sampleFolder/input.txt");

public static void main(String[] args) {
  while (reader.ready()) {
    System.out.println((char) reader.read());
  }
  reader.close();
}
```

#### Writing to a File

```java
import java.io.FileWriter;

// Option 1
FileWriter output = new FileWriter("C:/SampleFolder/Output.txt");

// Option 2
String fileName = args[0];
File outputFile = new File(fileName);
FileWriter output2 = new FileWriter(outputFile);

```
- Will create a new file if it is not existing. Otherwise, will overwrite the file.
- This will not create a folder, and will throw a `FileNotFoundException` if the folder 
  structure is not existing.

`.write(String content, int startingIndex [optional], int numberOfChars [optional])`
- Writes the content to the writer object pointing to the file.

```regexp
output.write(statement);
output.write(statement, 0, 5);
```

#### Wrapping up Loose Ends
- It is critically important to close resources such as files and input streams.
- These can tie up memory in the processor and in some file systems only one asset can access a 
  file at a time, which blocks all access to the file from other sources.
- This can be done manually by adding `reader.close()` in the end or automatically using 
  `try-with-resources`.

## Serialization in Java
One of the benefits of using objects is the ability to encapsulate state (or data) to use within 
a program.

**Serializing** objects stores an object's state in a file which can be transferred in a network.

### Serialization
- Taking an object's state and transforming it into a _stream of bytes_.
  - `Stream:` an abstract definition of a sequence of data that is made available over time.
  - `Byte:` 8 bit group of data
  - `Stream of Byte:` a sequence of bytes that is made available over time.
  
- To serialize an object, its fields and their types are stored in the form of bytes. These 
  bytes are then able to written to memory, a file, a database, or sent over a network with 
  all the information necessary to recreate the object.

### Deserialization
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

### The Serializable Interface
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

### Methods
Below are the following methods used in conducting serialization and deserialization.

#### `FileOutputStream(String filePath)`
- Constructor method for `FileOutputStream` class.
- Helper method to write serialized object to a file.
- Establish a stream that points towards a certain file.
```java
FileOutputStream fileOutputStream = new FileOutputStream("fileName.txt");
```
----------
#### `ObjectOutputStream(FileOutputStream stream)`
- Constructor method for `ObjectOutputStream` class.
- Helper method to write serializable object to an output stream.

```java
ObjectOutputStream objectOutputStream = new objectOutputStream(fileOutputStream);
```
- `writeObject(Obj obj)`: serializes a passed object to a specified output stream.

----------

#### `FileInputStream(String filePath)`
- A constructor method for the `FileInputStream` class.
- Helper method used to read a file and loads it in a stream.

```java
FileInputStream fileInputStream = new FileInputStream("filename.txt");
```

----------
#### `ObjectInputStream(fileInputStream stream)`
- Constructor method for the ObjectInputStream class.
- Helps read a stream containing the serialized object in bytes.

```java
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
```
----------
#### `.readObject()`
- Translate an ObjectInputStream instance to an object.
- `returns:` An Object that needs to be cast.

```java
Person michaelCopy = (Person) objectInputStream.readObject();
```

| Method                                        | Description                                                                                                                                                                                                     | Example                                                                                             |
|-----------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `FileOutputStream(String filePath)`           | - Constructor method for `FileOutputStream` class.<br>- Helper method to write serialized object to a file.<br>- Establish a stream that points towards a certain file.                                         | ```java<br>FileOutputStream fileOutputStream = new FileOutputStream("fileName.txt");<br>```         |
| `ObjectOutputStream(FileOutputStream stream)` | - Constructor method for `ObjectOutputStream` class.<br>- Helper method to write serializable object to an output stream.<br>- `writeObject(Obj obj)`: serializes a passed object to a specified output stream. | ```java<br>ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);<br>``` |
| `FileInputStream(String filePath)`            | - A constructor method for the `FileInputStream` class.<br>- Helper method used to read a file and loads it in a stream.                                                                                        | ```java<br>FileInputStream fileInputStream = new FileInputStream("filename.txt");<br>```            |
| `ObjectInputStream(fileInputStream stream)`   | - Constructor method for the ObjectInputStream class.<br>- Helps read a stream containing the serialized object in bytes.                                                                                       | ```java<br>ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);<br>```     |
| `.readObject()`                               | - Translate an ObjectInputStream instance to an object.<br>- `returns:` An Object that needs to be cast.                                                                                                        | ```java<br>Person michaelCopy = (Person) objectInputStream.readObject();<br>```                     |

