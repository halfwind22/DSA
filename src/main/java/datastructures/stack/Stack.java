package datastructures.stack;

import datastructures.stack.Node;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stack {

    /*
     * Implementing Stack using LinkedList
       Insertion and Deletion from the head is O(1), where as Insertion and Deletion from the tail is O(1) and O(n)
     */


    private int length;
    Node top;

    public Stack(int value) {
        Node node = new Node(value);
        this.top = node;
        node.setNext(null);
        this.length += 1;
    }

    public boolean push(int value) {

        if (this.length == 0) {
            new Stack(value);
        } else {
            Node node = new Node(value);
            node.setNext(this.top);
            this.top = node;
            this.length += 1;
        }

        return true;
    }

    public Node pop() {
        Node nodeToBePopped = null;
        if (this.length != 0) {
            nodeToBePopped = this.top;
            this.top = this.top.getNext();
        }
        return nodeToBePopped;
    }

    public void displayStack() {
        Node node = this.top;
        while (node != null) {
            System.out.print(node);
            node = node.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

}
