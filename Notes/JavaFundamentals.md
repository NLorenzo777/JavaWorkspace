# Java Fundamentals and Best Practices
1. 


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

