import java.util.*;

public class Graph<T> {
    private Map<T, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    //Checks if a vertex with the same name exists, if not adds it and returns true
    public boolean addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new LinkedList<Edge>());
            return true;
        }
        return false;
    }


    public boolean addEdge(T src, T dst) {
        Edge edge = new Edge(src, dst);
        if (adjacencyList.containsKey(src) && adjacencyList.containsKey(dst)) {
            adjacencyList.get(src).add(edge);
            adjacencyList.get(dst).add(edge);
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
    public boolean removeVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            for (Map.Entry<T, List<Edge>> entry : getAdjacencyList().entrySet()) {
                List<Edge> list = entry.getValue();
                for (Edge e : list) {
                    if (e.getSrc().equals(vertex) || e.getDst().equals(vertex)) {
                        list.remove(e);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /*IF graph is directed, removes the edge from the list of the source
     * If graph is not directed, removes the edge from the list of the source and destination*/
    public boolean removeEdge(Edge edge) {
        List list = adjacencyList.get(edge.getSrc());
        List list2 = adjacencyList.get(edge.getDst());
        if (list.contains(edge)) {
            list.remove(edge);
            list2.remove(edge);
            return true;
        }
        return false;
    }

    public Map<T, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}