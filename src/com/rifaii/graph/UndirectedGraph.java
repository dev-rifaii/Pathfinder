package com.rifaii.graph;


public class UndirectedGraph<T> extends BaseGraph<T> {


    @Override
    public boolean addEdge(T src, Edge dst) {
        if (adjacencyList.containsKey(src) && adjacencyList.containsKey(dst.getDestination())) {
            adjacencyList.get(src).add(dst);
            adjacencyList.get(dst.getDestination()).add(new Edge(src, dst.getWeight()));
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return
                adjacencyList.toString();

    }
}