package com.contactsunny.poc.cloneundirectedgraph;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Node nodeA = new Node('a');
        Node nodeB = new Node('b');
        Node nodeC = new Node('c');
        Node nodeD = new Node('d');
        Node nodeE = new Node('e');

        nodeA.addAdjacentNode(nodeB);
        nodeA.addAdjacentNode(nodeC);

        nodeB.addAdjacentNode(nodeD);
        nodeB.addAdjacentNode(nodeE);

        nodeC.addAdjacentNode(nodeA);
        nodeC.addAdjacentNode(nodeD);

        nodeD.addAdjacentNode(nodeB);
        nodeD.addAdjacentNode(nodeE);

        nodeE.addAdjacentNode(nodeB);
        nodeE.addAdjacentNode(nodeD);

        printGraph(nodeA);

        Node clonedHead = cloneGraph(nodeA);

        System.out.println("-------------------------");
        System.out.println("Printing cloned graph");
        System.out.println("-------------------------");
        printGraph(clonedHead);
    }

    /**
     * This method is taking care of cloning the graph completely. The process is divided into two parts:
     * 1. Clone all the nodes first. They'll remain un-connected in this step.
     * 2. Clone all the edges next. In this step, all the cloned nodes will be connected.
     *
     * @param node The starting node of the original graph
     *
     * @return The starting node of the cloned graph
     */
    private static Node cloneGraph(Node node) {
        // Creating a map to hold the references of the cloned node for each node
        // in the given graph. This is used for cloning the edges.
        Map<Node, Node> nodeMap = new HashMap<Node, Node>();
        // Cloning all the nodes.
        cloneNodes(node, nodeMap);
        // Cloning all the edges.
        cloneEdges(node, nodeMap);
        // Returning the head or the starting node of the cloned graph.
        return nodeMap.get(node);
    }

    /**
     * In this method, we use BFS to traverse through the graph to clone all the edges we find
     * in all the nodes that we see. This is a typical BFS loop, but instead of searching for a node,
     * we're cloning the edges we have at each node.
     *
     * @param startingNode The starting node of the original graph
     * @param nodeMap The map containing references to all cloned nodes.
     */
    private static void cloneEdges(Node startingNode, Map<Node, Node> nodeMap) {
        // Creating a queue to hold all the nodes that need to be visited
        Queue<Node> queue = new LinkedList<Node>();
        // Creating a set to hold the values of all the nodes we've already visited.
        Set<Character> seen = new HashSet<Character>();

        // Adding the starting node to the queue.
        queue.add(startingNode);

        // Looping until the queue becomes empty.
        while (!queue.isEmpty()) {
            // Pulling the node from the top of the queue.
            Node node = queue.poll();
            // We'll process this node only if it's not yet processed already.
            if (!seen.contains(node.getValue())) {
                // We'll add this to the seen set so that we don't process it again.
                seen.add(node.getValue());
                // Getting the cloned node from the map.
                Node clonedNode = nodeMap.get(node);
                // Looping through all the adjacent nodes of the original node. In this loop:
                // 1. We add all adjacent nodes to the queue.
                // 2. Find the cloned equivalent of the adjacent node, and add it to the list of
                // adjacent nodes of the cloned node. This is how we create an edge in the cloned graph.
                for (Node adjacentNode : node.getAdjacentNodes()) {
                    // Adding node to the queue
                    queue.add(adjacentNode);
                    // Adding node's clone to the adjacent node list of the clone of the current node.
                    clonedNode.addAdjacentNode(nodeMap.get(adjacentNode));
                }
            }
        }
    }

    /**
     * In this method I'm creating a clone for each node in the origin graph.
     * These clone nodes will be stored in a hash map so that we can retrieve it with O(1)
     * when we have the reference of the original node. We'll use this to create edges in the
     * next step.
     *
     * @param startingNode The starting node of the original graph
     * @param nodeMap The map containing references to all cloned nodes.
     */
    private static void cloneNodes(Node startingNode, Map<Node, Node> nodeMap) {
        // Creating a queue to hold all the nodes that need to be visited
        Queue<Node> queue = new LinkedList<Node>();
        // Creating a set to hold the values of all the nodes we've already visited.
        Set<Character> seen = new HashSet<Character>();

        // Adding the starting node to the queue.
        queue.add(startingNode);

        // Looping until the queue becomes empty.
        while (!queue.isEmpty()) {
            // Pulling the node from the top of the queue.
            Node node = queue.poll();
            // We'll process this node only if it's not yet processed already.
            if (!seen.contains(node.getValue())) {
                // Checking if we have already cloned the node.
                if (!nodeMap.containsKey(node)) {
                    // Adding the node to the seen set.
                    seen.add(node.getValue());
                    // Creating a new node with the same value as the original node.
                    Node cloneNode = new Node(node.getValue());
                    // Adding the cloned node to the hash map along with the original node.
                    nodeMap.put(node, cloneNode);
                }
                // Adding all adjacent nodes to the queue.
                queue.addAll(node.getAdjacentNodes());
            }
        }
    }

    private static void printGraph(Node startingNode) {
        Queue<Node> queue = new LinkedList<Node>();
        Set<Character> seen = new HashSet<Character>();

        queue.add(startingNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!seen.contains(node.getValue())) {
                seen.add(node.getValue());
                System.out.println("Vertex " + node.getValue());
                System.out.println("Hash code: " + node.hashCode());
                System.out.println("Edges:");
                for (Node adjacentNode : node.getAdjacentNodes()) {
                    queue.add(adjacentNode);
                    System.out.println(node.getValue() + " -> " + adjacentNode.getValue());
                }
                System.out.println("-----------------------------");
            }
        }

    }
}
