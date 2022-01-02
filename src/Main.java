import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(false);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("C", "B", 1);
        graph.addEdge("A", "C", 1);
        Edge edge = new Edge("A", "B", 156);

        graph.removeVertex("A");
//        Map map = graph.getMap();
//        System.out.println(map.get("A"));
//        System.out.println(graph.removeEdge("A", "B", 1));

        graph.printAdjacencyList();


    }


}
