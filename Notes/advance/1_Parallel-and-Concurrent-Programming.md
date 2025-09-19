# Parallel and Concurrent Programming [↑](../../README.md#advanced-java-fundamentals)

## Concurrency and Parallelism
- **Concurrency** is the act of processing more than one task at seemingly the same time on the same CPU, requiring the ability to switch between tasks.
- **Parallelism** is the act of splitting tasks into smaller subtasks and processing those subtasks in parallel.

Each concept has its strengths and levels of efficiency, and will always be a tradeoff of overhead in both.

## Thread Pools
- The concept of reusing threads.
- Manages a pool of worker threads that connect to a work queue of `Runnable` tasks waiting to be executed.
- In the Thread pool, a **Blocking Queue** is used to manage this work, which takes a given `Runnable` object as a task to be processed and enqueues it.
- The idle threads are watching the queue and will process the enqueued tasks on a first-come-first-serve basis.
- Once a thread finishes a task, it simply returns to watching the block queue and processes whatever tasks gets enqueued next.

## The Executor Framework
- Implements thread pooling through the `Executor` interface.
- Fairly intuitive and draws on already pre-existing functionality found in the Thread class, and the executor framework provides additional interfaces for various implementation strategies.

#### Executor Framework Classes
Executor interfaces include:
- `Executor`: Launch a `Runnable` object task.
- `ExecutorService`: manages the lifecycle of tasks in a sub-interface of `Executor`
- `ScheduledExecutor`: schedules the execution of tasks in a sub-interface of `ExecutorService`.

#### Imports

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
```

#### Implementation
Additionally, since we need the tasks  we enqueue into the thread pool to be `Runnable` objects, we'll be creating a `Runnable` class accordingly.

To use an executor, we need to create an `ExecutorService` object and pass it the number of threads.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

private static final int N = 10;

public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(N);
    executor.execute(task);
    
}
```
Since the thread pool is responsible for those threads, it will automatically handle creating those and managing how they run. 
We just need to tell it how many to create and handle. At this point, all we need to do now is pass tasks to the executor.

#### Methods:
- `executor.shutdown()` To prevent any new tasks from being added to the executor. The threads will still work and clear out the queue.
- `executor.awaitTermination()` Wait for the thread pool to finish executing everything in its queue.

#### Examples

```java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int N = 10;
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(N);
    for (int i = 0; i < 500; i++) {
      Runnable task = new RunnableTask(10000000L + i);
      executor.execute(task);
    }
    executor.shutdown();
    executor.awaitTermination(30, TimeUnit.SECONDS);
    System.out.println("Finished all threads");
  }

}
```

## The Fork-Join Framework


