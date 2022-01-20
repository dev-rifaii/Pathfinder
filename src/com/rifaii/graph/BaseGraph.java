package com.rifaii.graph;

import java.util.*;

public abstract class BaseGraph<T> implements Graph<T> {

    protected final Map<T, Set<Edge>> adjacencyList = new HashMap<>();

    @Override
    public boolean addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            for (Set<Edge> entry : adjacencyList.values()) {
                Set<Edge> set = entry;
                for (Edge e : set) {
                    if (e.getDestination().equals(vertex)) {
                        set.remove(e);
                    }
                }
            }
            return true;
        }
        return false;
    }

    //Removes the edge from the list of the source and destination
    @Override
    public boolean removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            for (Edge e : adjacencyList.get(source)) {
                if (e.getDestination().equals(destination)) {
                    adjacencyList.get(source).remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    public Set<Edge> getNeighbours(T vertex) {
        return adjacencyList.get(vertex);
    }

    public Map<T, Set<Edge>> getAdjacencyList() {
        return Collections.unmodifiableMap(adjacencyList);
    }


    //Prints the adjacecny list
    public void printAdjacencyList() {
        adjacencyList.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        });
    }

}
