package org.datastructures.queue;

import org.datastructures.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
        Queue unboundedQueue = new Queue();
        Queue boundedQueue = new Queue(10);

//        System.out.println("unboundedQueue: " + unboundedQueue.maxSize);
//        System.out.println("boundedQueue: " + boundedQueue.maxSize);

//        boundedQueue.dequeue();
        System.out.println("-------------");
        boundedQueue.enqueue("1");
        boundedQueue.enqueue("2");
        boundedQueue.enqueue("3");
        boundedQueue.enqueue("4");
        boundedQueue.enqueue("5");
        boundedQueue.enqueue("6");
        boundedQueue.enqueue("7");
        boundedQueue.enqueue("8");
        boundedQueue.enqueue("9");
        boundedQueue.enqueue("10");
        boundedQueue.enqueue("11");
    }
}
