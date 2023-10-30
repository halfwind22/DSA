package algorithms.treetraversal;

import datastructures.trees.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
public class BreadthFirstSearch {
    private final Queue<Node> fifoQueue;
    private final List<Integer> listOfElements;
    private final Node rootNode;

    public BreadthFirstSearch(Node rootNode) {
        fifoQueue = new LinkedList<>();
        listOfElements = new ArrayList<>();
        this.rootNode = rootNode;
    }

    public void BFS() {
        fifoQueue.add(rootNode);
        while (!fifoQueue.isEmpty()) {
            Node node = fifoQueue.remove();
            listOfElements.add(node.getValue());
            if (node.getLchild() != null) {
                fifoQueue.add(node.getLchild());
            }
            if (node.getRchild() != null) {
                fifoQueue.add(node.getRchild());
            }

        }
    }
}
