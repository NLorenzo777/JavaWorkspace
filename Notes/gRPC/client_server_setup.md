# gRPC Client/Server Setup


## Client/Server Setup - Java
This section contains the step-by-step procedure on how to create a gRPC Server powered by Java programming language.

### 1. Update the pom.xml
This will enable the project to generate the protocol buffer classes.

```xml
<dependency>
    <groupId>io.grpc</groupId>
    <artifactId>grpc-netty-shaded</artifactId>
    <version>1.75.0</version>
</dependency>

<dependency>
    <groupId>io.grpc</groupId>
    <artifactId>grpc-protobuf</artifactId>
    <version>1.60.1</version>
</dependency>

<dependency>
    <groupId>io.grpc</groupId>
    <artifactId>grpc-stub</artifactId>
    <version>1.60.1</version>
</dependency>

<build>
    <extensions>
        <extension>
            <groupId>kr.motd.maven</groupId>
            <artifactId>os-maven-plugin</artifactId>
            <version>1.7.0</version>
        </extension>
    </extensions>
    
    <plugins>
        <plugin>
            <groupId>org.xolstice.maven.plugins</groupId>
            <artifactId>protobuf-maven-plugin</artifactId>
            <version>0.6.1</version>
            <configuration>
                <protocArtifact>
                    com.google.protobuf:protoc:3.25.1:exe:${os.detected.classifier}
                </protocArtifact>
                <pluginId>grpc-java</pluginId>
                <pluginArtifact>
                    io.grpc:protoc-gen-grpc-java:1.60.1:exe:${os.detected.classifier}
                </pluginArtifact>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>compile</goal>
                        <goal>compile-custom</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
### 2. Create the .proto file
The .proto file serves as the skeleton on how components will be mapped and will serve as a basis for the maven project to generate the Java classes.

Below is a sample .proto file content.
```protobuf
syntax="proto3";

option java_multiple_files=true;
option java_package="com.noel.grpc";
option java_outer_classname="HelloProto";


service HelloService {
  rpc sayHello (HelloRequest) returns (HelloResponse);
}

message HelloRequest {
  string name=1;
}

message HelloResponse {
  string message=1;
}
```

### 3. Generate the protocol buffers
Go to the project root directory and run execute this line via terminal

```bash
mvn clean compile
```

One this is run, the proto files are generated (usually inside a `target` folder).


### 4. Create the implementation file
This will serve as the `Service` file that will connect with the generated proto files.

Notice the following:
- The service file is extended in this pattern: `<service name>Grpc.<service name>ImplBase`
- The service file usually contains the rpc methods annotated by the `@Override` annotation. 
- The rpc method should accept two (2) parameters:
  - The request object that was also generated.
  - a generic `StreamObserver<T>` containing the request object. 

```java
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloResponse> resObserver) {

        String reply = "Hello" + req.getName();

        HelloResponse res = HelloResponse.newBuilder()
                .setMessage(reply)
                .build();

        // Logic to send back the response to the client through the constructed stream
        resObserver.onNext(res);

        // Signals back to the client which ends the stream.
        resObserver.onCompleted();
    }

}
```

### 5. Create the Java Server file
Below is an example of a Java file that acts as a GRPC server

```java
public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder
                .forPort(5555)
                .addService(new HelloServiceImpl())
                .build();

        server.start();
        System.out.println("gRPC Server Started on port 5555.");
        server.awaitTermination();
    }

}
```

#### The `Server` object
- Is the object that embodies the server
- This is created by the built-in `ServerBuilder` of the gRPC dependencies which holds the following important server details:
  1. `.forPort(port_number)` = Port number where the gRPC server will live.
  2. `.addService(grPC-Object)` = The gRPC service object created. In this example, `the HelloServiceImpl()`.
  3. `.build()` = Returns the immutable server instance


### 6. Create the Java Client File
Below is an example of a Java file that sends the request to the gRPC server.

```java
public class GrpcClient {

    /**
     * 1. Create the channel object containing the address and port number
     * 2. create a Blocking stub which accepts the channel
     * 3. Create the response object which uses the stub object to call the rpc method.
     * 4. Place further logic after to achieve business case.
     * 5. IMPORTANT: Shutdown the channel.
     * @param args
     */
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 5555)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setName("Noel").build();

        HelloResponse res = stub.sayHello(request);

        System.out.println("Response from Server: " + res.getMessage());

        channel.shutdown();
    }
}
```

#### The `ManagedChannel` object
- This is the object that embodies the client which sends the request to the specific gRPC server.
- The general process in creating the client is as follows:
  1. Create the channel object the same way how `Service` channel was created on the gRPC server side.
     - `.forAddress(url, portNumber)` = Should be the same port where the gRPC server resides.
     - `.usePlaintext()`
     - `.build()`
  2. Feed the created channel to the blocking stub.
  3. Create the request object `<GeneratedGrpcClass>.newBuilder().setDetail1(input1).setDetail2(input2).build()` 
  4. Use the stub object to call the needed method and pass the request object.
  5. Lastly, shutdown the channel `channel.shutdown()`.


