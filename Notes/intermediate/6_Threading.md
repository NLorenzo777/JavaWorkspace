# Threading

## Terms and Definitions:

- **Sequential Programs:** Type of programs that run instructions in a defined order, with a beginning and an end. Only one instruction is being performed at a time.
- **Concurrent Programs:** Type of program the supports multiple flows of execution at the same time. Commonly implemented for fast and efficiency.

## Introduction

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
- Threads are best use when a program has tasks that need to be performed in parallel and it is required that the main thread remains responsive while tasks are being performed.
- When a program has the ability to perform more tasks in less time, the threading has increased its **throughput**.


### Context of a Thread
- For a program to execute properly, it needs to have several things in its **context**.
- A program's context includes variables, function names, a history of function calls (call stack), and more.
- There is a point where some information (context) needs to be shared between threads.
  - example, in an online store, there are several threads. Each thread will be using the product ID or user ID at some point which usually originates at the start of the application (main thread).
  - However, when multiple threads tends to read/update a single shared-resource, there is a risk of that resource being out-dated. This issue is handled through the use of **synchronization**.

