package com.practice.java.dsa;

public class GraphArray {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public GraphArray(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1; // For undirected graph
    }

    public void addEdge(int i, int j, int weight) {
        adjacencyMatrix[i][j] = weight;
        adjacencyMatrix[j][i] = weight; // For undirected graph
    }

    public void removeEdge(int i, int j) {
        adjacencyMatrix[i][j] = 0;
        adjacencyMatrix[j][i] = 0; // For undirected graph
    }

    public boolean hasEdge(int i, int j) {
        return adjacencyMatrix[i][j] != 0;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphArray graph = new GraphArray(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Graph representation as adjacency matrix:");
        graph.printGraph();

        System.out.println("Has edge between 0 and 2: " + graph.hasEdge(0, 2));
        System.out.println("Has edge between 1 and 3: " + graph.hasEdge(1, 3));

        graph.removeEdge(0, 2);
        System.out.println("Graph representation after removing edge (0,2):");
        graph.printGraph();

        System.out.println(5/2f);
    }
}