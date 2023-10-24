package datastructures.stack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterNode {

    private char value;
    private CharacterNode next;

    public CharacterNode() {
    }

    public CharacterNode(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value + " --> ";
    }
}
