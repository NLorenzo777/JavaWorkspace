# Google Remote Procedure Calls (gRPC) [↑](../../README.md#grpc-remote-procedure-calls)

Below is a sample gRPC protocol file which is used for generating the protocol buffer classes based on a programming language used.

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

#### Useful mnemonics
- `service` --> Class
- `rpc` --> Method
- `message` --> Logic
- `option` --> Field


## The file options
 - The `option` keyword is used by the gRPC for generation of proto files.

```protobuf
option java_package="io.grpc.examples.helloworld";
```
This specified the package of the generated protocol buffer class (in Java format)

## The RPC methods
GRPC allows four (4) kinds of method.

### Simple RPC
Where the client sends request to the server using the stub and waits for a response to come back, just like a normal function call.

```text
rpc GetFeature(Point) returns (Feature) {}
```

### Server-side Streaming RPC
The client sends a request to the server and gets a stream to read a sequence of messages back. The client reads from the returned stream until there are no more messages.

A server-side streaming method is specified by placing the `stream` keyword before the response type.

```text
rpc ListFeatures(Rectangle) returns (stream Feature) {}
```

### Client-side Streaming RPC
The client writes a sequence of messages and sends them to the server (again, using the `stream` keyword). Once the client has finished writing the messages, it waits for the server to read them all and return its response.

```text
rpc RecordRoute(stream Point) returns (RouteSummary) {}
```
### Bidirectional Streaming RPC
Both sides send a sequence of messages using a read-write stream. The two stream operate independently, so clients and servers can read and write in whatever order they like.

```text
rpc RouteChat(stream RouteNote) returns (stream RouteNote) {}
```
