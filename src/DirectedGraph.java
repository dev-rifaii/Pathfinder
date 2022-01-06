import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DirectedGraph<T> implements Graph<T> {
    protected final Map<T, List<Edge>> adjacencyList = new HashMap<>();

    @Override
    public boolean addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new LinkedList<Edge>());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            for (List<Edge> entry : adjacencyList.values()) {
                List<Edge> list = entry;
                for (Edge e : list) {
                    if (e.getDestination().equals(vertex)) {
                        list.remove(e);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(T src, Edge dst) {
        if (adjacencyList.containsKey(src) && adjacencyList.containsKey(dst.getDestination())) {
            adjacencyList.get(src).add(dst);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            for (Edge e : adjacencyList.get(source)) {
                if (e.getDestination().equals(destination)) {
                    adjacencyList.get(source).remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    //Prints the adjacecny list
    public void printAdjacencyList() {
        adjacencyList.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        });
    }
}
