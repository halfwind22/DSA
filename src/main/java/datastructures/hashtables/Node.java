package datastructures.hashtables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private Object key;
    private Object value;
    private Node next;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ " + this.key + " : " + this.value + " }" + " --> ";
    }
}
