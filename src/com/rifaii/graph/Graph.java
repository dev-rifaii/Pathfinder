package com.rifaii.graph;


import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph<T> {


    boolean addEdge(T src, Edge edge);

    boolean removeEdge(T source, T destination);

    boolean addVertex(T vertex);

    boolean removeVertex(T vertex);

    void printAdjacencyList();

    Set<Edge> getNeighbours(T vertex);


    Map<T, Set<Edge>> getAdjacencyList();
}
