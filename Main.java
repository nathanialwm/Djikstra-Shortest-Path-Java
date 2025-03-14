import java.util.*;

/**
 * Runnable section of the program
 * Gains user input to find the shortest path for specified graph, points and weight type
 */
public class Main {
    public static void main(String[] args) {
        // Handle user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to select a graph.
        System.out.println("Select a graph to load:");
        System.out.println("1. Graph 1");
        System.out.println("2. Graph 2");
        System.out.println("3. Graph 3");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Load the specified graph
        Graph graph;
        switch (choice) {
            case 1:
                graph = GraphLoader.loadSampleGraph();
                break;
            case 2:
                graph = GraphLoader.loadSampleGraph2();
                break;
            case 3:
                graph = GraphLoader.loadSampleGraph3();
                break;
            default:
                System.out.println("Invalid choice. Loading default graph.");
                graph = GraphLoader.loadSampleGraph();
        }

        // Display the chosen graph
        System.out.println("City Map (Graph):");
        graph.displayGraph();

        // Ask user for the start and end locations.
        System.out.print("Enter start location: ");
        String start = scanner.nextLine().toUpperCase();
        System.out.print("Enter end location: ");
        String end = scanner.nextLine().toUpperCase();

        // Ask user for the weight type for path
        System.out.print("Select weight type (distance/time/cost): ");
        String weightType = scanner.nextLine();

        // Use that hard to type guys algorithm to find the shortest path
        try {
            Graph.PathResult result = graph.getShortestPath(start, end, weightType);

            // Calculate shortest path
            if (result != null) {
                System.out.printf("Shortest %s from %s to %s: %d%n", weightType, start, end, result.getTotalWeight());
                System.out.print("Path: ");
                List<String> path = result.getPath();
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i));
                    if (i != path.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            } else {
                System.out.printf("No path found from %s to %s.%n", start, end);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid weight type");
        }

        scanner.close();
    }
}
