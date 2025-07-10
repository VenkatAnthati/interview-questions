package com.practice.java.dsa;
import java.util.*;

class ConnectedComponents {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public ConnectedComponents(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // For undirected graph
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = adjList[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void connectedComponents() {
//        for (LinkedList<Integer> list : adjList){
//            System.out.println(list);
//        }
        boolean[] visited = new boolean[vertices];
        for (int v = 0; v < vertices; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        ConnectedComponents g = new ConnectedComponents(5);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        System.out.println("Connected components:");
        g.connectedComponents();
    }
}
