import java.util.Objects;

public class Edge {
    private String src;
    private String dst;
    int weight;


    public Edge(String src, String dst, int weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }


    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge:" +
                "source='" + src + '\'' +
                ", Destination='" + dst + '\'' +
                ", weight=" + weight;
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
