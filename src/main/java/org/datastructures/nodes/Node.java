package org.datastructures.nodes;

public class Node {
    // GENERAL INFO:
    // Node is one of the fundamental building blocks of many computer science data structures.
    // They form the basis for linked lists, stacks, queues, trees, and more.

    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public void connectTo(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }

    public void update() {
        this.data = data;
    }

}
