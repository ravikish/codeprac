package com.demo.testcode;

import java.util.LinkedList;
import java.util.Stack;

public class GraphTopBottom {
    private final int vertices;
    private final LinkedList<Integer>[] adjList;

    GraphTopBottom(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    void DFS(int source) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            source = stack.pop();
            System.out.print(source + " ");

            for (int n : adjList[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    stack.add(n);
                }
            }
        }

    }

    public static void main(String[] args) {
        GraphTopBottom g = new GraphTopBottom(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
