public class Edge<T> {

    private T destination;
    private float weight;

    public Edge(T destination) {
        this.destination = destination;

    }

    public Edge(T destination, float weight) {
        this.destination = destination;
        this.weight = weight;
    }


    public T getDestination() {
        return destination;
    }

    public float getWeight() {
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
