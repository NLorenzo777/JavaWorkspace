# Apache Kafka & Docker Basics -- Summary

## 1. General Idea

Apache Kafka is a distributed event streaming platform used for: 
- Sending messages (events) 
- Storing streams of data
- Allowing multiple
systems to consume data independently

It acts as a **central communication backbone** between services.

Without Kafka:
```text
Application A ---> Application B
```

With Kafka:
```text
Application A ---> Kafka ---> Application B
                         |
                          ---> Application C
                         |
                          ---> Application D
```

Application A does not need to know who consumes the data. It simply publishes messages to Kafka.

### Real World Example
Without Kafka:
```text
Order Service
    |
    +--> Payment Service
    +--> Inventory Service
    +--> Shipping Service
    +--> Email Service
```
The `Order Service` becomes tightly coupled to everything.

With Kafka:
```text
Order Service
      |
      v
   Kafka Topic
      |
      +--> Payment Service
      +--> Inventory Service
      +--> Shipping Service
      +--> Email Service
      +--> Analytics Service
```
This promotes independence of each service.

## 2. Core Kafka Concepts

### Producer
Sends messages to Kafka topics

```java
producer.send(
    new ProducerRecord<>("orders", order)
);
```


### Consumer
Reads messages from Kafka topics

```java
@KafkaListener(topics = "orders")
public void process(Order order) {
    // process logic starts here
}
```
Multiple consumers can read the same message.

### Topic
- A category/channel where messages are stored (e.g., `orders`, `payments`)
- Messages are written to topics
- Think of a topic as a queue-like mailbox.

### Message
A message is simply a data

```json
{
  "orderId": 123,
  "customer": "John Doe",
  "amount": 500
}
```

In Kafka, these are called **events**.

### Broker
- Kafka server that stores and serves messages
- Kafka runs as a cluster of brokers
- If one broker dies, Kafka can continue operating.

#### Why multiple brokers?
- High availability
- Scalability
- Fault tolerance

### Partition
- Topics are split into partitions for scalability and parallel processing
- This is where Kafka becomes powerful.

Example:
```text
Topic: orders

Partition 0
Partition 1
Partition 2
```

Messages are distributed among partitions.

```text
Order 1 -> Partition 0
Order 2 -> Partition 1
Order 3 -> Partition 2
```

#### Benefits of Partitioning
- Parallel processing
- Higher throughput
- Scalability

### Consumer Group
- A group of consumers sharing the workload of reading partitions
- This is how Kafka scales horizontally.

Suppose you have three instances of the same service:

```text
Email Service #1
Email Service #2
Email Service #3
```

All belong to:
```text
consumer-group-email
```

Kafka automatically distributes partitions

```text
Partition 0 -> Consumer 1
Partition 1 -> Consumer 2
Partition 2 -> Consumer 3
```

Each message is processed only once within the group.

### Offset
- Work in progress.

## 3. Why Kafka is Used

Without Kafka: - Services are tightly coupled (direct API calls)

With Kafka: - Services communicate asynchronously - More scalable and
resilient architecture - Supports event-driven systems

## 4. Difference from Traditional Queues
- Many messaging systems delete messages after they are consumed. Kafka keeps messages for a configurable period.
- A new consumer can later read old events. This is one reason Kafka is popular for:
  - Analytics
  - Audit trails
  - Event sourcing
  - Data pipelines



## Java Example (Basic)

### Maven Dependencies
```xml
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-clients</artifactId>
    <version>3.9.0</version>
</dependency>
```

### Producer

```java
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class OrderProducer {

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record =
                new ProducerRecord<>(
                        "orders",
                        "order-123"
                );

        producer.send(record);
        System.out.println("Message sent!");
        producer.close();
    }
}
```

### Consumer

```java
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class OrderConsumer {

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "order-group");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        props.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(props);

        consumer.subscribe(
                Collections.singletonList("orders")
        );

        while (true) {

            ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofSeconds(1));

            for (ConsumerRecord<String, String> record : records) {

                System.out.println(
                        "Received: " + record.value()
                );
            }
        }
    }
}
```

## Spring Boot Example
In a Spring Boot applications, the message is often JSON.

### Producer
```java
OrderEvent event = new OrderEvent(123L, "John Doe", 500.00);
kafkaTemplate.send("orders", event);
```

### Consumer
```java
@KafkaListener(topics="orders", groupId="order-services")
public void processOrder(OrderEvent event) {
    System.out.println("Processing Order: " + event.getOrderId());
}

```

## Important Properties

| Property             | Purpose                                    |
|----------------------|--------------------------------------------|
| `bootstrap.servers`  | Where Kafka is running                     |
| `group.id`           | Consumer group name                        |
| `key.serializer`     | Converts Java object to bytes              |
| `value.serializer`   | Converts Java object to bytes              |
| `key.deserializer`   | Converts bytes to Java object              |
| `value.deserializer` | Converts bytes to Java object              |
| `auto.offset.reset`  | Where to start reading if no offset exists |


## 6. Docker Basics for Kafka

### Key Concepts

-   Image: template (like a Java class)
-   Container: running instance (like an object)
-   Port mapping: exposes Kafka to your local machine

------------------------------------------------------------------------

## 7. Running Kafka with Docker

### Check Docker

``` bash
docker --version
```

### Run Kafka using Docker Compose

``` yaml
services:
  kafka:
    image: apache/kafka:latest
    ports:
      - "9092:9092"
```

### Start Kafka

``` bash
docker compose up -d
```

### Check running containers

``` bash
docker ps
```

------------------------------------------------------------------------

## 8. Key Takeaway

Kafka is best understood as:

> A distributed log system that enables event-driven communication
> between services.

Once Docker is running, you can: - Send messages using a Java Producer -
Read messages using a Java Consumer - Experiment with real event-driven
architecture locally
