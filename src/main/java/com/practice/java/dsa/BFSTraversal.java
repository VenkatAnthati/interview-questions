package com.practice.java.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int[][] adjacencyMatrix;
    private int numVertices;
    private boolean[] visited;

    public BFSTraversal(int[][] matrix) {
        this.adjacencyMatrix = matrix;
        this.numVertices = matrix.length;
        this.visited = new boolean[numVertices];
    }

    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0}
        };

        BFSTraversal bfsTraversal = new BFSTraversal(matrix);
        System.out.println("BFS Traversal:");
        bfsTraversal.bfs(0); // Start BFS from vertex 0
    }
}
