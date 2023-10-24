package datastructures.trees;

import datastructures.trees.Node;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BinarySearchTree {

    private Node root;
    private int level;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(int value) {
        Node node = new Node(value);
        this.root = node;
        node.setLchild(null);
        node.setRchild(null);
        this.level += 1;
    }

    public boolean insertElement(int value) {
        Node node = new Node(value);
        if (this.root == null) {
            this.root = node;
            node.setLchild(null);
            node.setRchild(null);
            this.level += 1;
            return true;
        } else {
            int height = 0;
            Node tNode = this.root;
            while (true) {
                if (value == tNode.getValue()) {
                    return false;
                }
                if (tNode.getValue() < value) {
                    if (tNode.getLchild() == null) {
                        tNode.setLchild(node);
                        this.level = height + 1;
                        return true;

                    }
                    tNode = tNode.getLchild();
                } else {
                    if (tNode.getRchild() == null) {
                        tNode.setRchild(node);
                        this.level = height + 1;
                        return true;
                    }
                    tNode = tNode.getRchild();
                }
                height += 1;
            }
        }
    }

    public boolean containsElement(int value) {
        if (this.root == null) {
            return false;
        } else {
            Node tNode = this.root;
            while (true) {
                if (tNode.getValue() == value) {
                    return true;
                } else if (tNode.getValue() < value) {
                    if (tNode.getLchild() == null) {
                        return false;
                    }
                    tNode = tNode.getLchild();
                } else {
                    if (tNode.getRchild() == null) {
                        return false;
                    }
                    tNode = tNode.getRchild();
                }
            }
        }
    }

    public Node removeElement(int value) {
        Node parentnode = null;
        Node tNode = this.root;
        if (this.root == null) {
            return null;
        } else if (value == this.root.getValue()) {
            this.root = null;
            return tNode;
        } else {
            while (true) {
                if (tNode.getValue() < value) {
                    if (tNode.getLchild() == null) {
                        return null;
                    }
                    parentnode = tNode;
                    tNode = tNode.getLchild();
                    if (tNode.getValue() == value) {
                        parentnode.setLchild(null);
                        return tNode;
                    }
                } else {
                    if (tNode.getRchild() == null) {
                        return null;
                    }
                    parentnode = tNode;
                    tNode = tNode.getRchild();
                    if (tNode.getValue() == value) {
                        parentnode.setRchild(null);
                        return tNode;
                    }
                }
            }
        }
    }

//    public void displayLinkedList() {
//        Node node = this.root;
//        System.out.println();
//        while (node != null) {
//            System.out.print(node);
//            node = node.getRchild();
//        }
//        System.out.print(" null");
//        System.out.println();
//    }
//

}


