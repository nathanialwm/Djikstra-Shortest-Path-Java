/**
 * Utility class for creating and populating sample graphs.
 */
public class GraphLoader {

    /**
     * Loads a sample graph with predefined vertices and edges.
     *
     * @return A fully populated Graph object.
     */
    public static Graph loadSampleGraph() {
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        // Add edges with weights (distance, time, cost)
        graph.addEdge("A", "B", 5, 10, 3);
        graph.addEdge("A", "C", 2, 5, 2);
        graph.addEdge("B", "C", 2, 4, 1);
        graph.addEdge("B", "D", 7, 14, 5);
        graph.addEdge("C", "D", 4, 8, 3);
        graph.addEdge("C", "E", 3, 6, 2);
        graph.addEdge("D", "E", 1, 2, 1);
        graph.addEdge("D", "F", 5, 10, 4);
        graph.addEdge("E", "F", 7, 14, 6);

        return graph;
    }

    /**
     * Loads another sample graph with different vertices and edges.
     *
     * @return A fully populated Graph object.
     */
    public static Graph loadSampleGraph2() {
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex("X");
        graph.addVertex("Y");
        graph.addVertex("Z");
        graph.addVertex("W");
        graph.addVertex("V");
        graph.addVertex("U");

        // Add edges with weights
        graph.addEdge("X", "Y", 6, 12, 4);
        graph.addEdge("X", "Z", 1, 2, 1);
        graph.addEdge("Y", "Z", 2, 4, 2);
        graph.addEdge("Y", "W", 5, 10, 3);
        graph.addEdge("Z", "W", 1, 2, 1);
        graph.addEdge("Z", "V", 7, 14, 5);
        graph.addEdge("W", "V", 3, 6, 2);
        graph.addEdge("W", "U", 2, 4, 1);
        graph.addEdge("V", "U", 4, 8, 3);

        return graph;
    }

    /**
     * Loads a third sample graph with unique vertices and edges.
     *
     * @return A fully populated Graph object.
     */
    public static Graph loadSampleGraph3() {
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex("P");
        graph.addVertex("Q");
        graph.addVertex("R");
        graph.addVertex("S");
        graph.addVertex("T");
        graph.addVertex("U");

        // Add edges with weights
        graph.addEdge("P", "Q", 3, 6, 2);
        graph.addEdge("P", "R", 2, 4, 1);
        graph.addEdge("Q", "R", 4, 8, 3);
        graph.addEdge("Q", "S", 5, 10, 4);
        graph.addEdge("R", "S", 1, 2, 1);
        graph.addEdge("R", "T", 7, 14, 6);
        graph.addEdge("S", "T", 3, 6, 2);
        graph.addEdge("S", "U", 4, 8, 3);
        graph.addEdge("T", "U", 2, 4, 1);

        return graph;
    }
}
