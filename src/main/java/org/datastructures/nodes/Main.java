package org.datastructures.nodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Main.class);

        Node node1 = new Node("data1");
        Node node2 = new Node("data2");
        Node node3 = new Node("data3");

        node1.connectTo(node2);
        node2.connectTo(node3);



    }

}
