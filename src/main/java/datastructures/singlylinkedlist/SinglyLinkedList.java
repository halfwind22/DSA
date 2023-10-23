package datastructures.singlylinkedlist;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SinglyLinkedList {

    private Node head;
    private Node tail;

    private int length;

    public SinglyLinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.tail.setNext(null);
        this.length += 1;

    }

    public boolean addElement(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = node;
            node.setNext(null);
        } else {

            this.tail.setNext(node);
            this.tail = node;
        }
        this.length += 1;
        return true;
    }

    public boolean addElementAtBeginning(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = node;
            node.setNext(null);
        } else {

            node.setNext(this.head);
            this.head = node;
        }
        this.length += 1;
        return true;

    }

    public boolean addElementAtPosition(int position, int value) {
        if (position > length) {
            return false;
        } else {
            Node node = getElement(position);
            if (node != null) {
                Node newNode = new Node(value);
                newNode.setNext(node.getNext());
                node.setNext(newNode);
                this.length += 1;
            } else return false;
        }
        return true;
    }

    public Node removeElement() {
        Node nodeToBeDeleted = null;
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            nodeToBeDeleted = this.head;
            this.head = this.tail = null;
            this.length -= 1;
            return nodeToBeDeleted;
        } else {

            Node node = this.head;
            while (node.getNext().getNext() != null) {
                node = node.getNext();
            }

            nodeToBeDeleted = node.getNext();
            this.tail = node;
            this.tail.setNext(null);
            this.length -= 1;
            return nodeToBeDeleted;
        }
    }

    public Node removeElementFromBeginning() {
        Node nodeToBeDeleted = null;
        if (this.length != 0) {
            nodeToBeDeleted = this.head;
            this.head = this.head.getNext();
            this.length -= 1;
        }
        return nodeToBeDeleted;
    }

    public Node removeElementAtPosition(int position) {
        Node nodeToBeDeleted = null;
        if (position > length) {
            return null;
        } else {
            Node node = getElement(position);
            if (node != null) {
                nodeToBeDeleted = node.getNext();
                Node nextNode = node.getNext().getNext();
                node.setNext(nextNode);
                this.length -= 1;
            }
        }
        return nodeToBeDeleted;
    }

    public void displayLinkedList() {
        Node node = this.head;
        System.out.println();
        while (node != null) {
            System.out.print(node);
            node = node.getNext();
        }
        System.out.print(" null");
        System.out.println();
    }

    public void displayLinkedListWithNext() {
        Node node = this.head;
        System.out.println();
        while (node != this.tail) {
            System.out.print("| " + node.toString().replaceAll(" -->", "") + "**** " + node.getNext().toString().replaceAll(" -->", "") + " |");
            node = node.getNext();
        }
        System.out.print("| " + node + " null");
        System.out.println();
    }

    public Node getElement(int index) {
        if (index > this.length || index < 0) {
            return null;
        }
        Node node = this.head;
        int postionsTravelled = 1;
        while (node != null && postionsTravelled < index) {
            postionsTravelled += 1;
            node = node.getNext();
        }
        return node;
    }

    public boolean setElement(int index, int value) {
        Node node = getElement(index);
        if (node != null) {
            node.setValue(value);
            return true;

        }
        return false;
    }

    public void reverseLinkedList() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node after = tail.getNext();
        Node before = null;
        Node currentNode = this.tail;

        while (currentNode != this.head && after != null) {
            temp = after.getNext();
            after.setNext(currentNode);
            currentNode.setNext(before);
            before = currentNode;
            currentNode = after;
            after = temp;

        }

    }

    public Node reverseLinkedList(Node headNode) {

        if (headNode != null) {
            Node after = headNode.getNext();
            Node before = null;
            Node temp = null;

            while (after != null) {
                headNode.setNext(before);
                temp = after.getNext();
                after.setNext(headNode);

                before = headNode;
                headNode = after;
                after = temp;

            }
        }
        return headNode;

    }

    public static Node mergeTwoLinkedLists(Node headNode1, Node headNode2) {
        Node firstNode = null;
        if (headNode1 == null && headNode2 == null) {
            return null;
        } else if (headNode1 == null) {
            return headNode2;
        } else if (headNode2 == null) {
            return headNode1;
        } else {

            boolean headSet = false;
            Node node = null;

            while (headNode1 != null && headNode2 != null) {
                if (headNode1.getValue() <= headNode2.getValue()) {
                    if (!headSet) {
                        node = new Node(headNode1.getValue());
                        headSet = true;
                        firstNode = node;
                    } else {
                        node.setNext(new Node(headNode1.getValue()));
                        node = node.getNext();
                    }
                    headNode1 = headNode1.getNext();
                } else {
                    if (!headSet) {
                        node = new Node(headNode2.getValue());
                        headSet = true;
                        firstNode = node;
                    } else {
                        node.setNext(new Node(headNode2.getValue()));
                        node = node.getNext();
                    }
                    headNode2 = headNode2.getNext();

                }
            }

            if (headNode1 == null && headNode2 != null) {
                node.setNext(headNode2);
            } else if (headNode2 == null) {
                node.setNext(headNode1);
            }

        }
        return firstNode;

    }

    public static Node mergeTwoLinkedListsEfficient(Node headNode1, Node headNode2) {
        Node firstNode = null;
        if (headNode1 == null && headNode2 == null) {
            return null;
        } else if (headNode1 == null) {
            return headNode2;
        } else if (headNode2 == null) {
            return headNode1;
        } else {

            boolean headSet = false;
            Node node = null;

            while (headNode1 != null && headNode2 != null) {
                if (headNode1.getValue() <= headNode2.getValue()) {
                    if (!headSet) {
                        node = new Node(headNode1.getValue());
                        headSet = true;
                        firstNode = node;
                    } else {
                        node.setNext(headNode1);
                        node = node.getNext();
                    }
                    headNode1 = headNode1.getNext();
                } else {
                    if (!headSet) {
                        node = new Node(headNode2.getValue());
                        headSet = true;
                        firstNode = node;
                    } else {
                        node.setNext(headNode2);
                        node = node.getNext();
                    }
                    headNode2 = headNode2.getNext();

                }
            }

            if (headNode1 == null) {
                node.setNext(headNode2);
            } else {
                node.setNext(headNode1);
            }

        }
        return firstNode;

    }

    public boolean detectCycles() {

        /*
         * Tortoise and hare algorithm
         * */

        if (this.head == null || this.head.getNext() == null) {
            return false;
        }
        Node slowPtr = this.head;
        Node fastPtr = this.head.getNext();

        while (fastPtr != null) {
            if (slowPtr == fastPtr) {
                return true;
            }
            slowPtr = slowPtr.getNext();
            if (fastPtr.getNext() != null) {
                fastPtr = fastPtr.getNext().getNext();
            } else {
                return false;
            }
        }
        return false;

    }
}
