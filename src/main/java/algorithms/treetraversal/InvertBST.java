package algorithms.treetraversal;

import datastructures.trees.Node;

public class InvertBST {
    /*
     * Idea being ,go to one node, and just swap its left and right children
     * Then recursively call this function on each of the child nodes
     * */

    public Node invertTree(Node node) {
        if (node == null) {
            return null;
        } else if (node.getLchild() == null && node.getRchild() == null) {
            return node;
        } else {
            swapNodes(node);
            invertTree(node.getLchild());
            invertTree(node.getRchild());
        }
        return node;
    }

    private void swapNodes(Node parentnode) {
        /*
         * Node 1 and 2 are sibling nodes, and children of parent parentNode
         * */
        Node temp = parentnode.getLchild();
        parentnode.setLchild(parentnode.getRchild());
        parentnode.setRchild(temp);


    }
}
