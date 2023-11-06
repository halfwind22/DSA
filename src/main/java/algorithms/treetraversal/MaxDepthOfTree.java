package algorithms.treetraversal;

import datastructures.trees.Node;

public class MaxDepthOfTree {
    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        } else if (root.getRchild() == null && root.getLchild() == null) {
            return 1;
        } else {
            int left = maxDepth(root.getLchild()) + 1;
            int right = maxDepth(root.getRchild()) + 1;
            return Math.max(left, right);
        }

    }
}
