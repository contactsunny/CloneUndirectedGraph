package com.contactsunny.poc.cloneundirectedgraph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private char value;
    private List<Node> adjacentNodes = new ArrayList<Node>();

    public Node(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void addAdjacentNode(Node node) {
        this.adjacentNodes.add(node);
    }

    public List<Node> getAdjacentNodes() {
        return this.adjacentNodes;
    }
}
