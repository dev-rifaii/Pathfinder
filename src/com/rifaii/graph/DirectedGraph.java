package com.rifaii.graph;

public class DirectedGraph<T> extends BaseGraph<T> {


    @Override
    public boolean addEdge(T src, Edge dst) {
        if (adjacencyList.containsKey(src) && adjacencyList.containsKey(dst.getDestination())) {
            adjacencyList.get(src).add(dst);
            return true;
        }
        return false;
    }


}
