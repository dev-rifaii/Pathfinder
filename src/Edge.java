public class Edge<T> {

    private T destination;
    private int weight;

    public Edge(T destination) {
        this.destination = destination;

    }

    public Edge(T destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }


    public T getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
