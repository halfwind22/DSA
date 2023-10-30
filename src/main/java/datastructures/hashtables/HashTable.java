package datastructures.hashtables;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HashTable {

    /*
     *   Hash function takes O(1) time as it is independent of the no of elements added to the hash structure and is instead dependent on the size.
     *   Assuming enough randomness using a good hash function and a larger address space, SET and REMOVE operations happen in O(1) time.
     *
     * */

    private final int SIZE = 7; //having a prime number as the address space reduces the chances of collisions

    private final Node[] nodes;

    public HashTable() {
        this.nodes = new Node[SIZE];
    }

    private int hashFunction(String key) {
        int hash = 0;
        char[] asciiArray = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {
            int asciiValue = asciiArray[i];
            hash = (hash + asciiValue) % SIZE;
        }
        return hash;
    }

    public void set(Object key, Object value) {
        int arrayIndex = hashFunction((String) key);
        Node refNode = this.getNodes()[arrayIndex];
        if (refNode == null) {
            this.getNodes()[arrayIndex] = new Node(key, value);
        } else {
            while (refNode.getNext() != null) {
                refNode = refNode.getNext();
            }
            refNode.setNext(new Node(key, value));
        }
    }

    public Node remove(Object key) {
        int arrayIndex = hashFunction((String) key);
        Node refNode = this.getNodes()[arrayIndex];
        if (refNode != null) {
            while (refNode != null) {
                if (refNode.getKey() == key) {
                    return refNode;
                }
                refNode = refNode.getNext();
            }
        }
        return null;
    }

    public List<Object> getKeys() {
        ArrayList<Object> arrayListOfKeys = new ArrayList<>();
        Node refNode = null;
        for (Node node : nodes) {
            refNode = node;
            if (refNode != null) {
                while (refNode != null) {
                    arrayListOfKeys.add(refNode.getKey());
                    refNode = refNode.getNext();
                }
            }
        }
        return arrayListOfKeys;
    }

    public void printTable() {
        for (int j = 0; j < this.nodes.length; j++) {
            System.out.println(" Index::" + j);
            Node temp = nodes[j];
            while (temp != null) {
                System.out.print(temp);
                System.out.print(" ");
                temp = temp.getNext();
            }
        }
    }

    public boolean itemInCommon(String[] arr1, String[] arr2) {
        /*
         * O(n) approach to check if elements present in one list are also present in another
         * */

        for (String j : arr1) {
            set(j, true);
        }
        for (String i : arr2) {
            if (remove(i) != null) {
                return true;
            }
        }
        return false;
    }
}
