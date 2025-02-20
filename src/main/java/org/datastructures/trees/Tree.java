package org.datastructures.trees;

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
}
