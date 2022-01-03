import java.util.Objects;

public class Edge<T> {
    private T src;
    private T dst;

    public Edge(T src, T dst) {
        this.src = src;
        this.dst = dst;

    }

    public T getSrc() {
        return src;
    }

    public T getDst() {
        return dst;
    }

    @Override
    public String toString() {
        return "Edge source: " + src + ", destination: " + dst;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(src, edge.src) && Objects.equals(dst, edge.dst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dst);
    }
}
