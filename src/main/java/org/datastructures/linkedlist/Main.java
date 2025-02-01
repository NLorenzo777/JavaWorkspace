package org.datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList seasons = new LinkedList();
        seasons.printList();
        seasons.addToHead("summer");
        seasons.printList();
        seasons.addToHead("spring");
        seasons.printList();
        seasons.addToTail("fall");
        seasons.addToTail("winter");
        seasons.printList();
        seasons.removeHead();
        seasons.printList();
        seasons.removeHead();
        seasons.removeHead();
        seasons.printList();


        //two four
    }
}
