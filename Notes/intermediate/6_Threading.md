# Threading [↑](../../README.md#intermediate-java-fundamentals)
- [Introduction](#introduction-)
  - [When to use Threads](#when-to-use-threads)
  - [Context in Thread](#context-of-a-thread)
- [Implementations](#implementation-)
  - [1. Extending the `Thread` class](#1-extending-the-thread-class-)
  - [2. Implementing the `Runnable` Interface](#2-implementing-the-runnable-interface-)
    - [The Lambda Syntax](#lambda-expressions)
- [Supervising a Thread](#supervising-a-thread-)

## Terms and Definitions: 

- **Sequential Programs:** Type of programs that run instructions in a defined order, with a beginning and an end. Only one instruction is being performed at a time.
- **Concurrent Programs:** Type of program the supports multiple flows of execution at the same time. Commonly implemented for fast and efficiency.

## Introduction [↑](#threading-)

### Thread
- The building blocks of concurrent programs or processes.
- A thread has a beginning and an end and only a single point of execution.
- Multi-threaded architecture and paradigm for programs is one of the most fundamental patterns in programming.

<div>
<img src="../../img/threads.png" alt="Threads in Java"/>
</div>

- On this diagram, we can see that a process can start and execute multiple threads.
- By default, a process has a single thread of execution called **main thread**. From this initial thread, more threads can be created to launch different independent tasks.
- The process is not considered to be complete until all the threads that has started are finished.
- When a thread completes execution, it joins back to the main thread.

### When to use threads
- Threads are best use when a program has tasks that need to be performed in parallel. It is required that the main thread remains responsive while tasks are being performed.
- When a program has the ability to perform more tasks in less time, the threading has increased its **throughput**.
- Threading can solve problem where there is a lot of waiting to be done. When one task is in a "waiting" or "blocked" state, another one can start.


### Context of a Thread
- For a program to execute properly, it needs to have several things in its **context**.
- A program's context includes variables, function names, a history of function calls (call stack), and more.
- There is a point where some information (context) needs to be shared between threads.
  - example, in an online store, there are several threads. Each thread will be using the product ID or user ID at some point which usually originates at the start of the application (main thread).
  - However, when multiple threads tends to read/update a single shared-resource, there is a risk of that resource being out-dated. This issue is handled through the use of **synchronization**.


## Implementation [↑](#threading-)
There are multiple ways to implement threading in Java.

### 1. Extending the `Thread` Class [↑](#threading-)
- `java.lang.Thread` is a built-in class in Java that handles threads.
- To create a thread, a class is created. It is extended to the built-in Thread class.
- Once it is extended, the class overrides the `public void run()` method of the Thread class.
  - The `run()` method accepts no parameters and returns void as well.
  - If there is a need for a parameter, the fields of the class can be used. However, be very careful in utilizing the class fields as it may present some synchronization issues.
- When a class is defined this way, an instance of it can be created in any part of the program and call the `start()` to trigger the thread's execution.


```java
public class HugeProblemSolver extends Thread{

  public HugeProblemSolver(){
    // Required constructor used for passing information to the start() method.
  }

  private static void solveComputation(){
    // Solves random computation
    // Takes anywhere from 1 second to 10 minutes
  }

  @Override
  public void run(){
    solveComputation();
    System.out.println("The answer is: 42");
  }

  public static void main(String[] args){
    HugeProblemSolver m1 = new HugeProblemSolver();
    HugeProblemSolver m2 = new HugeProblemSolver();
    m1.start();
    m2.start();
  }
}

```

### 2. Implementing the Runnable Interface [↑](#threading-)
- A threaded class can be created in Java by implementing the `Runnable` interface.
- This is preferred since we are only allowed to extend one class and wasting it on a Thread might not be a beneficial approach to the program.

```java
public class Factorial implements Runnable {
 private int n;
 
 public Factorial(int n) {
   this.n = n;
 }
 
 public int compute(int n) {
   // ... the code to compute factorials
 }
 
 public void run() {
   System.out.print("Factorial of " + this.n + ":");
   System.out.println(this.compute(this.n));
 }
 
 public static void main(String[] args) {
   Factorial f = new Factorial(25);
   Factorial g = new Factorial(10);
   Thread t1 = new Thread(f);
   Thread t2 = new Thread(f);
   t1.start();
   t2.start();
 }
}
```
#### Lambda Expressions
- A more succinct way of using the `Runnable` interface is through the use of Lambda expressions.
- This is a more modern syntax that allows to define the run() method inline without requiring the class to implement `Runnable` or extend `Thread`.

```java
public class Factorial {
 public int compute(int n) {
   // ... the code to compute factorials
 }
 
 public static void main(String[] args) {
   Factorial f = new Factorial();
   
   // the lambda function replacing the run method
   new Thread(() -> {
     System.out.println(f.compute(25));
   }).start();
 
   // the lambda function replacing the run method
   new Thread(() -> {
     System.out.println(f.compute(10));
   }).start();
 }
}
```

- This syntax has several benefits:
  - The class no longer needs to extend `Thread` OR implement `Runnable`. Thread can be created from anything.
  - The class no longer needs a constructor to store arguments since it can be passed as an argument directly into the compute function when the Thread is created.
  - The class is easier to read. The lambda syntax makes it so that readers can immediately identify what is being performed without having to read through the class first.

## Supervising a Thread [↑](#threading-)
- Sometimes there is a need to see the status of threads during their execution. In Java, the best pattern for this situation is using a **supervisor thread**.
- This is a pattern where the main thread (or another thread) is able to watch and check on the progress of another thread, as long as it has access to the corresponding Thread instance.