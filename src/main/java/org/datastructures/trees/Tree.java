package org.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void printTree() {
        print(this.root, 0);
    }

    public void print(TreeNode current, int level) {
        String levelMarks = "";
        for (int i = 0; i < level; i++) {
            levelMarks += "-- ";
        }
        System.out.println(levelMarks + current.data);
        for (TreeNode child : current.children) {
            print(child, level + 1);
        }
    }

    /**
     * <Strong>Depth-First-Search (DFS)</Strong>
     * <p>a technique that visits the first child in the children list and that node's children recursively
     * before visiting all the first child's siblings and then their children recursively.</p>
     */
    public void depthFirstTraversal(TreeNode current) {
        System.out.print(current.data + " ");
        for (TreeNode child : current.children) {
            this.depthFirstTraversal(child);
        }
    }

    /**
     * <Strong>Breadth-First-Search (BFS)</Strong>
     * <p>A technique in a tree that visits all children of a node first before visiting any further levels.</p>
     */
    public void breadthFirstTraversal() {
        TreeNode current = this.root;

        //queue is a LinkedList<>() which implements the Queue interface.
        //an interface cannot be instantiated.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.data + " ");
            queue.addAll(current.children);
        }
    }
}
