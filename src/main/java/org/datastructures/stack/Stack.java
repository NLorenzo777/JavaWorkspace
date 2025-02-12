package org.datastructures.stack;

import org.datastructures.linkedlist.LinkedList;

public class Stack {
    //Stack is useful data structure to maintain the contents of a certain package.
    //For example, stack is used to track the arrival of guests at a party.
    //to see if who comes last.
    public LinkedList stack;
    public int size;
    public static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void push(String data) {
        if (this.hasSpace()) {
            this.stack.addToHead(data);
            this.size++;
            System.out.println("Added "
                    + data
                    + "! Stack size is now "
                    + this.size);
            System.out.print("Current Stack: ");
            this.stack.printList();
        } else {
            throw new Error("There are no space in the Stack");
        }
    }

    public String pop() {
        if (this.isEmpty()) {
            throw new Error("There are no items in the stack");
        } else {
            String data = this.stack.head.getData();
            this.stack.removeHead();
            this.size--;
            System.out.println("Removed "
                    + data
                    + "! Stack size is now "
                    + this.size);
            return data;
        }
    }

    public String peek() {
        return this.stack.head.getData();
    }

    //HELPER METHODS:
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }
}
