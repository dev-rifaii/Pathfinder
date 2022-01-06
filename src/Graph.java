import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface Graph<T> {


    abstract boolean addEdge(T src, Edge edge);

    abstract boolean removeEdge(T source, T destination);

    public boolean addVertex(T vertex);

    public boolean removeVertex(T vertex);

}
