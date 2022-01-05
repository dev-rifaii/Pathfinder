public interface Graph<T> {

    boolean addVertex(T vertex);
    boolean addEdge(T src, T dst);
    boolean removeVertex(T vertex);
    boolean removeEdge(T source, T destination);
}
