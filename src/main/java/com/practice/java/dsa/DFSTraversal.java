package com.practice.java.dsa;

import java.util.Stack;

public class DFSTraversal {
    private int[][] adjacencyMatrix;
    private int numVertices;
    private boolean[] visited;

    public DFSTraversal(int[][] matrix) {
        this.adjacencyMatrix = matrix;
        this.numVertices = matrix.length;
        this.visited = new boolean[numVertices];
    }

    public void dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
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
        DFSTraversal dfsTraversal = new DFSTraversal(matrix);
        System.out.println("DFS Traversal:");
        dfsTraversal.dfs(0); // Start DFS from vertex 0
    }
}

