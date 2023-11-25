package datastructures;


import lombok.Data;

import java.util.HashMap;

public class LRUCache {

    // Write modular code for remove/insert
    @Data
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return " <--( " + this.key + "," + this.value + " )--> ";
        }

    }

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> integerNodeHashMap;

    public LRUCache(int capacity) {
        this.integerNodeHashMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        //Return the value of the key if the key exists, otherwise return -1.

        Node keyNode = integerNodeHashMap.get(key);
        if (keyNode != null && keyNode == tail) {
            return keyNode.value;
        }
        if (integerNodeHashMap.get(key) != null) {
            remove(keyNode);
            insertAtTail(key, keyNode.value);
            return keyNode.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        //Update the value of the key if the key exists.
        // Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
        // evict the least recently used key.

        if (head == null && tail == null && integerNodeHashMap.isEmpty()) {
            //DLL is empty
            insertAtTail(key, value);
        } else {
            if (integerNodeHashMap.containsKey(key)) {
                remove(integerNodeHashMap.get(key));
            } else {
                if (integerNodeHashMap.values().size() == capacity) {
                    Node headNode = head;
                    if (headNode != null) {
                        remove(headNode);// Head always has LRU element
                    }// Head always has LRU element
                }
            }
            insertAtTail(key, value);
        }
    }

    public void remove(Node existingNode) {
        Node previousNode = existingNode.prev;
        Node nextNode = existingNode.next;
        if (previousNode == null) {
            // Target node was the head node itself
            if (nextNode == null) {
                //was the lone element in the linked list
                tail = head = null;
            } else {
                existingNode.next = null;
                head = nextNode;
                nextNode.prev = null;
            }
        } else {
            previousNode.next = nextNode;
            if (nextNode != null) { // current node wasn't tail
                nextNode.prev = previousNode;
            } else {
                // curent node was tail
                tail = previousNode;
            }
        }
        integerNodeHashMap.remove(existingNode.key);
    }

    public void insertAtTail(int key, int value) {
        Node newNode = new Node(key, value);
        integerNodeHashMap.put(key, newNode);
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        }
        if (head == null) {
            head = newNode;
        }
        tail = newNode;
    }

    public void displayLRUCacheContents() {
        System.out.println("Begin ********************************");
        Node node = head;
        while (node != null) {
            System.out.println("Key: " + node.key + " Value: " + node.value);
            node = node.next;
        }
        System.out.println("******************************** End");
    }
}
