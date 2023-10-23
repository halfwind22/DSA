package datastructures.doublylinkedlist;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private int length;


    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        this.head = this.tail = node;
        this.tail.setNext(null);
        this.tail.setPrev(null);
        this.length += 1;

    }

    public boolean addElement(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = node;
            node.setNext(null);
            node.setPrev(null);
        } else {

            node.setPrev(this.tail);
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
            node.setPrev(null);
        } else {
            node.setPrev(null);
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
                node.getNext().setPrev(newNode);
                newNode.setPrev(node);
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
            this.head.setPrev(null);
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
                nextNode.setPrev(node);
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

    public void displayLinkedListInReverse() {
        Node node = this.head;
        System.out.println();
        while (node != null) {
            System.out.print(node);
            node = node.getPrev();
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

    }
}


