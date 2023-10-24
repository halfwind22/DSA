package datastructures.trees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private int value;
    private Node lchild;
    private Node rchild;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "⬇" + this.value + "⬇ ";
    }
}
