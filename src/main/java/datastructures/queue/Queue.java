package datastructures.queue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Queue {

    /*
     * Implementing Queue using LinkedList
       Insertion and Deletion from the head is O(1), where as Insertion and Deletion from the tail is O(1) and O(n)
       So we do insertion from tail and deletion from head to simulate FIFO
     */


    private int length;
    Node first;
    Node last;

    public Queue(int value) {
        Node node = new Node(value);
        this.first = node;
        this.last = node;
        node.setNext(null);
        this.length += 1;
    }

    public boolean enqueue(int value) {

        if (this.length == 0) {
            new Queue(value);
        } else {
            Node node = new Node(value);
            this.last.setNext(node);
            this.last = node;
            this.length += 1;
        }

        return true;
    }

    public Node dequeue() {
        Node nodeToBePopped = null;
        if (this.length != 0) {
            nodeToBePopped = this.first;
            this.first = this.first.getNext();
            nodeToBePopped.setNext(null);
            this.length -= 1;
        }
        return nodeToBePopped;
    }

    public void displayQueue() {
        Node node = this.first;
        while (node != null) {
            System.out.print(node);
            node = node.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

}
