package org.datastructures.hashmap;

import java.util.Arrays;

/**
 * HASHMAPS
 * <ul>
 *     <li>data structures that serve as efficient key-value stores.</li>
 *     <li>Capable of assigning & retrieving data in the fastest way possible.</li>
 *     <li>The underlying data structure is an Array or LinkedList.</li>
 * </ul>
 */
public class HashMap {

    public LinkedList[] hashmap;
    /**
     * CONSTRUCTOR:
     * <p>- initialize the empty array that will hold values.</p>
     */
    public HashMap(int size) {
        this.hashmap = new LinkedList[size];
        Arrays.fill(this.hashmap, new LinkedList());
    }

    /**
     * <u>HASHING FUNCTION</u>
     * <p>- Will return an index in the array where the value will be stored.</p>
     * <p>- Deterministic, meaning must always return the same index when given the same key.</p>
     * <br/>
     * <u>COMPRESSION</u>
     * <p>- Means taking some input and returning an output within a specific range.</p>
     * <p>- Uses the concept of MODULAR ARITHMETIC (prevents a value from growing larger)</p>
     * <p>- Achieved using the modulo operation (%)</p>
     */
    private int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode + Character.codePointAt(key, i);
        }
        hashCode = hashCode % this.hashmap.length;
        return hashCode;
    }

    /**
     * LINKED LIST and NODE data structures are customized to cater the Key-Value pair. <br/>
     * 1. Check if the head of the list is null. If it is null, this means that the list is empty. <br />
     * 2. If the list is not null, iterate through the list and check if there is an existing key. <br />
     * 3.
     *
     */
    public void assign(String key, String value) {
        int arrayIndex = this.hash(key);
        LinkedList list = this.hashmap[arrayIndex];

        if (list.head == null) {
            list.addToHead(key, value);
            return;
        }

        Node currentNode = list.head;


        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                currentNode.setKeyValue(key, value);
            }
            if (currentNode.getNext() == null) {
                list.addToTail(key, value);
            }
            currentNode = currentNode.getNext();
        }
    }

    public String retrieve(String key) {
        Node currentNode = this.hashmap[this.hash(key)].head;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }

        return null;
    }
}