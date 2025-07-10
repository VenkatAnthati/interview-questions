package com.practice.java.dsa;

import java.util.Iterator;

public class ConnectedComInArrays {
    private int[][] adjacentsMatrix;
    private int vertices;


    public ConnectedComInArrays(int vertices){
        this.vertices =  vertices;
        this.adjacentsMatrix =  new int[vertices][vertices];

    }

    public static void main(String[] args) {
        ConnectedComInArrays connectedComInArrays = new ConnectedComInArrays(5);
        connectedComInArrays.addEdge(1, 0);
        connectedComInArrays.addEdge(2, 1);
        connectedComInArrays.addEdge(3, 4);

        connectedComInArrays.connectedComponents();
    }

    private void connectedComponents() {
        boolean[] visited = new boolean[vertices];
        for (int v = 0; v < vertices; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited);
//                System.out.println("V: "+v);
//                Iterator<Integer> it = adjList[v].iterator();
            }
        }
    }

    private void DFSUtil(int v, boolean[] visited) {
//        visited[v] = true;
//        System.out.print(v + " ");
//
//        Iterator<Integer> it = adjList[v].iterator();
//        while (it.hasNext()) {
//            int n = it.next();
//            if (!visited[n])
//                DFSUtil(n, visited);
//        }
    }

    public void addEdge(int i , int j){
        this.adjacentsMatrix[i][j] = 1;
        this.adjacentsMatrix[j][i] = 1;
    }
}
