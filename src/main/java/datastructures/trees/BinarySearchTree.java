package datastructures.trees;

import datastructures.trees.Node;
import lombok.Getter;
import lombok.Setter;

import java.security.cert.TrustAnchor;

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
                if (value < tNode.getValue()) {
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

    public boolean recursiveInsertElement(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            this.root.setLchild(null);
            this.root.setRchild(null);
            this.level += 1;
            return true;
        } else {
            return insert(this.root, value, 1);
        }
    }


    private boolean insert(Node node, int value, int height) {
        if (node.getValue() == value) {
            return false;
        } else if (value < node.getValue()) {
            if (node.getLchild() == null) {
                Node temp = new Node(value);
                node.setLchild(temp);
                this.level = height + 1;
                return true;
            } else {
                return insert(node.getLchild(), value, height + 1);
            }
        } else {
            if (node.getRchild() == null) {
                Node temp = new Node(value);
                node.setRchild(temp);
                this.level = height + 1;
                return true;

            } else {
                return insert(node.getRchild(), value, height + 1);
            }
        }

    }

    public Node recursiveInsertElementV2(int value) {
        Node node = null;
        if (this.root == null) {
            this.root = new Node(value);
            this.root.setLchild(null);
            this.root.setRchild(null);
            this.level += 1;
            return this.root;
        } else {
            node = insertV2(this.root, value, 1);
        }
        return node;
    }


    private Node insertV2(Node node, int value, int height) {
        if (node == null) {
            this.level = height;
            return new Node(value);
        } else if (value < node.getValue()) {
            node.setLchild(insertV2(node.getLchild(), value, height + 1));
        } else if (value > node.getValue()) {
            node.setRchild(insertV2(node.getRchild(), value, height + 1));
        }
        return node;
    }


    public boolean containsElement(int value) {
        if (this.root == null) {
            return false;
        } else {
            Node tNode = this.root;
            while (true) {
                if (tNode.getValue() == value) {
                    return true;
                } else if (value < tNode.getValue()) {
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

    public boolean containsElementCleaner(int value) {
        if (this.root != null) {
            Node tNode = this.root;
            while (tNode != null) {
                if (tNode.getValue() < value) {
                    tNode = tNode.getLchild();
                } else if (tNode.getValue() > value) {
                    tNode = tNode.getRchild();
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recursiveContains(int value) {
        if (this.root == null) {
            return false;
        } else {
            return contains(this.root, value);
        }
    }

    private boolean contains(Node node, int value) {
        if (node.getValue() == value) {
            return true;
        } else if (value < node.getValue()) {
            if (node.getLchild() == null) {
                return false;
            }
            return contains(node.getLchild(), value);

        } else {
            if (node.getRchild() == null) {
                return false;
            }
            return contains(node.getRchild(), value);

        }
    }

    public Node removeElementAndSubTree(int value) {
        Node parentnode = null;
        Node tNode = this.root;
        if (this.root == null) {
            return null;
        } else if (value == this.root.getValue()) {
            this.root = null;
            return tNode;
        } else {
            while (true) {
                if (value < tNode.getValue()) {
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

    public Node removeElement(int value) {
        if (this.root == null) {
            return null;
        } else {
            return remove(this.root, null, value, null);
        }

    }

    public Node remove(Node node, Node parentNode, int value, String direction) {

        while (true) {
            if (node == null) {
                return null;
            } else if (value < node.getValue()) {
                return remove(node.getLchild(), node, value, "left");
            } else if (value > node.getValue()) {
                return remove(node.getRchild(), node, value, "right");
            } else {
                /*
                 * At this point, I have reached the element tot be deleted
                 * */

                if (node.getLchild() == null && node.getRchild() == null) {
                    // Leaf node
                    if (direction.equalsIgnoreCase("left")) {
                        parentNode.setLchild(null);
                    } else if (direction.equalsIgnoreCase("right")) {
                        parentNode.setRchild(null);
                    }
                    return node;
                } else if (node.getLchild() != null && node.getRchild() == null) {
                    parentNode.setRchild(node.getLchild());
                    return node;
                } else if (node.getLchild() == null && node.getRchild() != null) {
                    parentNode.setLchild(node.getRchild());
                    return node;
                } else {
                    Node minNode = getMinValueFromRightSubTree(node, parentNode);
                    Node dummyNode = new Node(node.getValue());
                    node.setValue(minNode.getValue());
                    return dummyNode;
                }
            }
        }
    }

    private Node getMinValueFromRightSubTree(Node temp, Node parentNode) {
        /*
         * Returns the min value from a subtree, which is always going to be leftmost leaf node of the subtree
         * */
        Node node = temp.getRchild();
        while (node.getLchild() != null) {
            parentNode = node;
            node = node.getLchild();
        }
        parentNode.setLchild(null);
        return node;
    }

}

