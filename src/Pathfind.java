import java.util.*;


public class Pathfind<T> {


   //Dijkstra's Algorithm
    public void findShortestPath(Graph graph, T source) {
        //gets the adjacency list
        Map<T, List<Edge>> adj = graph.getAdjacencyList();
        int verticesCount = adj.size();
        //Storing the distances here
        Map<Node<T>, Integer> distances = new HashMap<>();
        //Keeping track of visited vertices here
        List<T> visited = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(verticesCount, new Node());
        //Adding all vertices to distances map and setting the value of distance to max
        for (T vertex : adj.keySet()) {
            distances.put(new Node(vertex, 0), Integer.MAX_VALUE);
        }
        distances.put(new Node(source, null), 0);

        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node<T> node = pq.poll();
            T vertex = node.getNode();
            visited.add(vertex);

            for (Edge<T> edge : adj.get(vertex)) {
                if (!visited.contains(edge.getDestination())) {
                    int totalCost = node.getCost() + edge.getWeight();
                    T destNode = edge.getDestination();

                    if (totalCost < distances.get(new Node(destNode))) {

                        distances.put(new Node<T>(destNode, vertex), totalCost);


                    }
                    pq.add(new Node(destNode, totalCost));
                }
            }

        }

        for (Node<T> node : distances.keySet()) {
            System.out.println(node.getNode().toString() + " ||| Cost = " + distances.get(node));
            if (node.getPredecessor() != null) {
                System.out.println(" ||| Predecessor = " + node.getPredecessor());
            }
        }

    }


    public class Node<T> implements Comparator<Node> {
        private T node;
        private int cost;
        private T predecessor;

        public Node() {

        }

        public Node(T node) {
            this.node = node;
        }

        public Node(T node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public Node(T node, T predecessor) {
            this.node = node;
            this.predecessor = predecessor;
        }

        public Node(T node, int cost, T predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }

        public T getNode() {
            return node;
        }


        public int getCost() {
            return cost;
        }

        public T getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(T predecessor) {
            this.predecessor = predecessor;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node1 = (Node<?>) o;
            return Objects.equals(node, node1.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }
    }
}