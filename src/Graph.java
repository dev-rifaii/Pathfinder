import java.util.*;

public class Graph {
    Map<String, LinkedList<Edge>> adjacencyList;
    boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        adjacencyList = new HashMap<>();
    }

    //Checks if a vertex with the same name exists, if not adds it and returns true
    public boolean addVertex(String name) {
        if (adjacencyList.containsKey(name)) {
            return false;
        } else {
            adjacencyList.put(name, new LinkedList<>());
            return true;
        }
    }

    /*If graph is directed, adds the edge only from source to destination, if graph is not directed
    adds the edge to both vertices. */
    public boolean addEdge(String src, String dst, int weight) {
        if (isDirected) {
            Edge edge = new Edge(src, dst, weight);
            adjacencyList.get(src).add(new Edge(src, dst, weight));
            return true;
        }
        if (!isDirected) {
            Edge edge = new Edge(src, dst, weight);
            adjacencyList.get(src).add(new Edge(src, dst, weight));
            adjacencyList.get(dst).add(new Edge(dst, src, weight));
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
    public boolean removeVertex(String name) {
        if (adjacencyList.containsKey(name)) {
            adjacencyList.remove(name);
            for (Map.Entry<String, LinkedList<Edge>> entry : getMap().entrySet()) {
                LinkedList<Edge> list = entry.getValue();
                for (Edge e : list) {
                    if (e.getSrc().contentEquals(name) || e.getDst().contentEquals(name)) {
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
    public boolean removeEdge(String src, String dst, int weight) {
        Edge edge = new Edge(src, dst, weight);
        Edge edge1 = new Edge(dst, src, weight);
        if (adjacencyList.containsKey(src)) {
            List<Edge> list = adjacencyList.get(src);
            if (isDirected) {
                for (Edge e : list) {
                    if (e.equals(edge)) ;
                    list.remove(e);
                    return true;
                }
            }
            if (!isDirected) {
                List<Edge> list1 = adjacencyList.get(dst);
                for (Edge e : list) {
                    if (e.equals(edge)) {
                        list.remove(e);
                    }
                }
                for (Edge e : list1) {
                    if (e.equals(edge1)) {
                        list1.remove(e);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Map<String, LinkedList<Edge>> getMap() {
        return adjacencyList;
    }

}
