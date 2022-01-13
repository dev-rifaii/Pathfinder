import java.util.*;

public interface Graph<T> {


    boolean addEdge(T src, Edge edge);

    boolean removeEdge(T source, T destination);

    boolean addVertex(T vertex);

    boolean removeVertex(T vertex);

    void printAdjacencyList();

    List<Edge> getNeighbours(T vertex);


    Map<T, List<Edge>> getAdjacencyList();
}
