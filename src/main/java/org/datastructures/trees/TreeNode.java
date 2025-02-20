package org.datastructures.trees;

import java.util.ArrayList;

/**
 * <Strong>TREES</Strong>
 * <p>- Data structure that can model real life hierarchical information.</p>
 * <p>- Organizational chart, genealogical trees, computer file systems, HTML elements (DOM).</p>
 */
public class TreeNode {
    public Object data;
    public ArrayList<TreeNode> children;

    public TreeNode(Object data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void addChild(Object child) {
        children.add(new TreeNode(child));
    }

    public void removeChild(TreeNode childToRemove) {
        if (this.children.isEmpty()) {
            return;
        }
        else if (this.children.contains(childToRemove)) {
            this.children.remove(childToRemove);
            return;
        } else {
            for (TreeNode child : this.children) {
                child.removeChild(childToRemove);
            }
        }
    }

    public void removeChild(Object childToRemove) {
        if (this.children.isEmpty()) {
            return;
        }
        for (TreeNode child : this.children) {
            if (child.data == childToRemove) {
                removeChild(child);
                return;
            }
        }
        for (TreeNode child : this.children) {
            child.removeChild(childToRemove);
        }
    }
}
