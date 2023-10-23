package datastructures.doublylinkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private int value;
    private Node prev;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " <-- " + this.value + " --> ";
    }
}
