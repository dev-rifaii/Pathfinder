

import java.util.*;

public class UndirectedGraph<T> implements Graph<T> {

    final private Map<T, List<T>> adjacencyList = new HashMap<>();

    //Checks if a vertex with the same name exists, if not adds it and returns true
    @Override
    public boolean addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new LinkedList<T>());
            return true;
        }
        return false;
    }


    @Override
    public boolean addEdge(T src, T dst) {
        if (adjacencyList.containsKey(src) && adjacencyList.containsKey(dst)) {
            adjacencyList.get(src).add(dst);
            adjacencyList.get(dst).add(src);
            return true;
        }
        return false;
    }


    //Prints the adjacecny list
    public void printAdjacencyList() {
        adjacencyList.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        });
    }


    //Removes the vertex and all the edges tied to it.
    @Override
    public boolean removeVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            for (List<T> entry : getAdjacencyList().values()) {
                List<T> list = entry;
                for (T e : list) {
                    if (e.equals(vertex)) {
                        entry.remove(e);
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
        if (source != null && destination != null) {
            adjacencyList.get(source).remove(destination);
            adjacencyList.get(destination).remove(source);
            return true;
        }
        return false;
    }

    public Map<T, List<T>> getAdjacencyList() {
        return Collections.unmodifiableMap(adjacencyList);
    }

    @Override
    public String toString() {
        return "UndirectedGraph{" +
                "adjacencyList=" + adjacencyList +
                '}';
    }
}