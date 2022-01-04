public interface Graph<T> {

    public boolean addVertex(T vertex);
    public boolean addEdge(T src, T dst);
    public boolean removeVertex(T vertex);
    public boolean removeEdge(T source, T destination);
}
