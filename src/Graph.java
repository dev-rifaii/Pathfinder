import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface Graph<T> {


    boolean addEdge(T src, Edge edge);

    boolean removeEdge(T source, T destination);

    boolean addVertex(T vertex);

    boolean removeVertex(T vertex);

    List<Edge> getNeighbours(T vertex);

    Map<T, List<Edge>> getAdjacencyList();
}
