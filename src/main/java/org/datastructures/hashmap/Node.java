package org.datastructures.hashmap;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Node {
    // GENERAL INFO:
    // Node is one of the fundamental building blocks of many computer science data structures.
    // They form the basis for linked lists, stacks, queues, trees, and more.

    private String key;
    private String value;
    private Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }

    public void setKeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
