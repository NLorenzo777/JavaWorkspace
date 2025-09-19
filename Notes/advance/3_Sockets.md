# Sockets [↑](../../README.md#advanced-java-fundamentals)

## Transmission Control Protocol (TCP)
- Transport protocols for HTTP response/requests used by sockets.
- TCP is a communication protocol that enables applications to exchange messages over a network and ensure the successful delivery of exchanged data packets.

## Introduction to Sockets
- A socket is an endpoint that essentially allows to connect the client and server using TCP.
- The TCP layer can identify where the data should be sent to since a **socket is tied to a specific port number**.
- The endpoint is the combination of the IP address and the port number.
- Sockets essentially allow one computer to communicate with many different clients at once.

## Socket Programming in Java

### Server Side Program

#### 1. Setting up the Socket
```java
import java.net.ServerSocket;

// A server socket with port number of 6868
ServerSocket firstServerSocket = new ServerSocket(6868);
```

To establish a connection, the following line of code should be implemented:

```java
import java.net.Socket;

Socket socketConnection = firstServerSocket.accept();
```

The `.accept()` method allows the ServerSocket class to take incoming messages.

#### 2. Setting up the Logic for catching the message from client
To do this, the `DataInputStream` is used.

```java
import java.io.DataInputStream;

DataInputStream dataStreamIn = new DataInputStream(socketConnection.getInputStream());
```

This code will allow the program to grab the data being streamed within the socket connection between the client and server.


#### 3. Read the data caught by `dataStreamIn`
The `.readUTF()` method from the `DataInputStream` allows to return a String form of the message.

```java
String readString = (String) dataStreamIn.readUTF();
```

#### 4. Close the socket connection
Close the connection by implementing the `.close()` method for the `ServerSocket`.


### Client Side Program

#### 1. Create a Socket
Create a Socket of the same port number used by the server.

```java
import java.net.Socket;

Socket clientSocket = new Socket("localhost", 6868);
```

#### 2. Create a `DataOutputStream`

```java
import java.io.DataOutputStream;

DataOutputStream dataStreamOut = new DataOutputStream(clientSocket.getOutputStream());
```

#### 3. Write the message using the `DataOutputStream` instance object.
Using the `.writeUTF(String message)`.

#### 4. Flush out the `DataOutputStream`
Using the `.flush()` method from the `DataOutputStream` class.

#### 5. Close the `DataOutputStream` and `Socket`
This can be achieved using the .close() method for both dataStreamOut and clientSocket.



