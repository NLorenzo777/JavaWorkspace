package org.datastructures.queue;

import org.datastructures.linkedlist.LinkedList;
import org.datastructures.nodes.Node;

import javax.management.RuntimeErrorException;

public class Queue {
    public LinkedList queue;
    public int size;
    public int maxSize;
    public static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    //Constructor Overloading:
    //If there are no specified size, this makes the queue 'Unbounded'.
    public Queue() {
        this(DEFAULT_MAX_SIZE);
    }

    public Queue(int maxSize) {
        this.queue = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    //ENQUEUE: add to the end of the queue.
    public void enqueue(String data) {
        if (this.hasSpace()) {
            this.queue.addToTail(data);
            this.size++;
            System.out.println("Added " + data + "! Queue size is now " + this.size + ".");
        } else {
            throw new Error("Queue is full!");
        }

    }

    //DEQUEUE: return the first item and remove it from the Queue.
    //Size is reduced.
    public String dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue is Empty!");
        } else {
            String data = this.queue.head.getData();
            this.queue.removeHead();
            System.out.println("Removed " + data + "! Queue size is now " + this.size);
            return data;
        }
    }

    //PEEK: return the first item of the Queue without removing it.
    public String peek() {
        if (this.isEmpty()) {
            throw new Error("Queue is Empty!");
        } else {
            return this.queue.head.getData();
        }
    }

    //HELPER METHODS:
    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


}
