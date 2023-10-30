package algorithms.treetraversal;

import datastructures.trees.Node;
import lombok.Getter;

import java.util.*;

@Getter
public class DepthFirstSearch {
    private static List<Integer> listOfElements;
    private final Node rootNode;

    public DepthFirstSearch(Node rootNode) {
        listOfElements = new ArrayList<>();
        this.rootNode = rootNode;
    }

    public void DFSPreOrder() {
        new TraversePreOrder(rootNode);
    }

    public void DFSPostOrder() {
        new TraversePostOrder(rootNode);
    }

    public void DFSInOrder() {
        new TraverseInOrder(rootNode);
    }

    public void display() {
        System.out.println(listOfElements);
    }

    static class TraversePreOrder {
        /*
         *  Write the value from the node, then look left, look right.
         * */

        public TraversePreOrder(Node node) {
            if (node != null) {
                listOfElements.add(node.getValue());
            }
            if (node != null) {
                new TraversePreOrder(node.getLchild());
                new TraversePreOrder(node.getRchild());
            }
        }
    }

    static class TraversePostOrder {
        /*
         * Look left, look right, and then write the value from the node.
         * */

        public TraversePostOrder(Node node) {
            if (node.getLchild() != null) {
                new TraversePostOrder(node.getLchild());
            }
            if (node.getRchild() != null) {
                new TraversePostOrder(node.getRchild());
            }
            listOfElements.add(node.getValue());
        }
    }

    static class TraverseInOrder {
        /*
         * Look left, write the value from the node, and then look right
         * */

        public TraverseInOrder(Node node) {
            if (node.getLchild() != null) {
                new TraverseInOrder(node.getLchild());
            }

            listOfElements.add(node.getValue());

            if (node.getRchild() != null) {
                new TraverseInOrder(node.getRchild());
            }
        }
    }
}


