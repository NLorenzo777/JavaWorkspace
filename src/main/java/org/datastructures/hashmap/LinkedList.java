package org.datastructures.hashmap;

public class LinkedList {
    /**
     * GENERAL INFO:
     * - A LinkedList is one of the basic data structures in computer science and serves as the foundation for more
     * complex data structures.
     * - The list comprises series of nodes.
     * - The beginning of the list is called "head", while the end is called "tail"
     * - This data structure only tracks the HEAD of the list.
     */
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String key, String value) {
        Node newHead = new Node(key, value);
        Node currentHead = this.head;
        this.head = newHead;

        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    /**
     * ADDING TO THE TAIL:
     * 1. Start with a temporary tail variable that will be set equal to the list's head.
     * 2. Set up a logic that will check if there is no head. If there is none, that means that the list is empty.
     * Otherwise, this will iterate through the list until the last node is find.
     */
    public void addToTail(String key, String value) {
        Node tail = this.head;

        if (tail == null) {
            this.head = new Node(key, value);
        } else {
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }

            tail.setNextNode(new Node(key, value));
        }
    }

    /**
     * REMOVING THE HEAD:
     * 1. Check to see if the list has a head. If it doesn't, there is nothing to return.
     * If there is a head, remove it by setting the list's head equal to the original head's next node.
     * 2. Return the original head.
     */
    public void removeHead() {
        Node removedHead = this.head;

        if (removedHead == null) {
            return;
        }
        this.head = removedHead.getNext();
    }
}
