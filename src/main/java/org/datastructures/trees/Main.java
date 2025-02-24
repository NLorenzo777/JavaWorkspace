package org.datastructures.trees;

public class Main {

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode("S");
        TreeNode child1 = new TreeNode("N");
        TreeNode child2 = new TreeNode("O");
        TreeNode grandchild1 = new TreeNode("W");
        TreeNode grandchild2 = new TreeNode("Y");
        // addChild operations below
        treeRoot.addChild(child1);
        treeRoot.addChild(child2);
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);
        // Create tree
        Tree tree = new Tree(treeRoot);
        // Print tree
        tree.printTree();
        // Remove grandchild2 from the tree
        treeRoot.removeChild(grandchild2);
        // Print the tree
        tree.printTree();
        // Remove "O" from the tree
        treeRoot.removeChild("O");
        // Print the tree again
        tree.printTree();


        int[] result = new int[2];
        result = new int[] {1, 2};
    }
}
