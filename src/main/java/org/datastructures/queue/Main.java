package org.datastructures.queue;

import org.datastructures.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
        Queue unboundedQueue = new Queue();
        Queue boundedQueue = new Queue(10);

        System.out.println("unboundedQueue: " + unboundedQueue.maxSize);
        System.out.println("boundedQueue: " + boundedQueue.maxSize);

        unboundedQueue.enqueue("first Item");
        unboundedQueue.enqueue("second Item");
    }
}
