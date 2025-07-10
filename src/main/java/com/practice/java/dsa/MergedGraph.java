package com.practice.java.dsa;

import java.util.*;

class MergedGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public MergedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    public MergedGraph mergeGraphs(MergedGraph otherGraph) {
        MergedGraph mergedGraph = new MergedGraph();

        // Add vertices and edges from the first graph
        for (Map.Entry<Integer, List<Integer>> entry : this.adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            mergedGraph.addVertex(vertex);
            for (int neighbor : entry.getValue()) {
                mergedGraph.addEdge(vertex, neighbor);
            }
        }

        // Add vertices and edges from the second graph
        for (Map.Entry<Integer, List<Integer>> entry : otherGraph.adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            mergedGraph.addVertex(vertex);
            for (int neighbor : entry.getValue()) {
                mergedGraph.addEdge(vertex, neighbor);
            }
        }

        return mergedGraph;
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + " is connected to: ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create the first graph
        MergedGraph graph1 = new MergedGraph();
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);

        // Create the second graph
        MergedGraph graph2 = new MergedGraph();
        graph2.addEdge(3, 4);
        graph2.addEdge(4, 1);

        // Merge the two graphs
        MergedGraph mergedGraph = graph1.mergeGraphs(graph2);

        // Print the merged graph
        System.out.println("Merged Graph:");
        mergedGraph.printGraph();
    }
}
