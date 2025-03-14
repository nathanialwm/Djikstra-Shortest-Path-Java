import java.util.*;

/**
 * Represents the entire graph structure.
 * Stores vertices and edges using an adjacency list.
 * Provides methods for adding vertices and edges.
 * Implements Dijkstra's algorithm for shortest path calculations.
 */
public class Graph {
	// Adjacency list mapping each vertex to its connected edges.
	private Map<String, List<Edge>> adjList;

	/**
	 * Initializes the graph with an empty adjacency list.
	 */
	public Graph() {
		adjList = new HashMap<>();
	}

	/**
	 * Adds a vertex to the graph.
	 *
	 * @param vertex The name of the vertex to add.
	 */
	public void addVertex(String vertex) {
		if (!adjList.containsKey(vertex)) {
			adjList.put(vertex, new ArrayList<Edge>());
		}
	}

	/**
	 * Adds an edge between two vertices with specified weights.
	 *
	 * @param source      The starting vertex.
	 * @param destination The ending vertex.
	 * @param distance    The distance weight.
	 * @param time        The time weight.
	 * @param cost        The cost weight.
	 */
	public void addEdge(String source, String destination, int distance, int time, int cost) {
		addVertex(source);
		addVertex(destination);

		adjList.get(source).add(new Edge(destination, distance, time, cost));
		adjList.get(destination).add(new Edge(source, distance, time, cost));
	}

	/**
	 * Computes shortest paths from the start vertex
	 *
	 * @param start      The starting vertex.
	 * @param weightType ("distance", "time", or "cost").
	 * @return A map of vertices and their shortest distances from the start vertex.
	 * throws exception If the weight type is invalid.
	 */
	public Map<String, Integer> dijkstra(String start, String weightType) {
		Map<String, Integer> distances = new HashMap<>();
		PriorityQueue<Map.Entry<String, Integer>> priorityQueue =
				new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
		Set<String> visited = new HashSet<>();

		// Initialize distances
		for (String vertex : adjList.keySet()) {
			distances.put(vertex, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		priorityQueue.add(new AbstractMap.SimpleEntry<>(start, 0));

		// Process the priority queue
		while (!priorityQueue.isEmpty()) {
			Map.Entry<String, Integer> currentEntry = priorityQueue.poll();
			String currentVertex = currentEntry.getKey();

			if (visited.contains(currentVertex)) {
				continue;
			}
			visited.add(currentVertex);

			for (Edge edge : adjList.get(currentVertex)) {
				String neighbor = edge.getVertex();

				if (visited.contains(neighbor)) {
					continue;
				}

				int weight = edge.getWeightByType(weightType);
				int newDist = distances.get(currentVertex) + weight;

				if (newDist < distances.get(neighbor)) {
					distances.put(neighbor, newDist);
					priorityQueue.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
				}
			}
		}

		return distances;
	}

	/**
	 * Holds the result of the shortest path computation.
	 */
	public class PathResult {
		private List<String> path;
		private int totalWeight;

		public PathResult(List<String> path, int totalWeight) {
			this.path = path;
			this.totalWeight = totalWeight;
		}

		public List<String> getPath() {
			return path;
		}

		public int getTotalWeight() {
			return totalWeight;
		}
	}

	/**
	 * Finds the shortest path from start to end vertex.
	 *
	 * @param start      The starting vertex.
	 * @param end        The ending vertex.
	 * @param weightType The weight type ("distance", "time", or "cost").
	 * @return A PathResult with the shortest path and total weight, or null if no path exists.
	 * @throws IllegalArgumentException If the weight type is invalid.
	 */
	public PathResult getShortestPath(String start, String end, String weightType) {
		Map<String, Integer> distances = new HashMap<>();
		Map<String, String> previous = new HashMap<>();
		PriorityQueue<Map.Entry<String, Integer>> priorityQueue =
				new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
		Set<String> visited = new HashSet<>();

		// Initialize distances
		for (String vertex : adjList.keySet()) {
			distances.put(vertex, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		priorityQueue.add(new AbstractMap.SimpleEntry<>(start, 0));

		// Process the priority queue
		while (!priorityQueue.isEmpty()) {
			Map.Entry<String, Integer> currentEntry = priorityQueue.poll();
			String currentVertex = currentEntry.getKey();

			if (visited.contains(currentVertex)) {
				continue;
			}
			visited.add(currentVertex);

			if (currentVertex.equals(end)) {
				break;
			}

			for (Edge edge : adjList.get(currentVertex)) {
				String neighbor = edge.getVertex();

				if (visited.contains(neighbor)) {
					continue;
				}

				int weight = edge.getWeightByType(weightType);
				int newDist = distances.get(currentVertex) + weight;

				if (newDist < distances.get(neighbor)) {
					distances.put(neighbor, newDist);
					previous.put(neighbor, currentVertex);
					priorityQueue.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
				}
			}
		}

		// Build the path from start to end
		List<String> path = new ArrayList<>();
		String current = end;

		if (!previous.containsKey(end) && !start.equals(end)) {
			return null;
		}

		while (current != null) {
			path.add(0, current);
			current = previous.get(current);
		}

		int totalWeight = distances.get(end);
		if (totalWeight == Integer.MAX_VALUE) {
			return null;
		}

		return new PathResult(path, totalWeight);
	}

	/**
	 * Displays the graph in a readable format.
	 */
	public void displayGraph() {
		for (String vertex : adjList.keySet()) {
			System.out.printf("%s -> ", vertex);
			List<Edge> edges = adjList.get(vertex);
			for (Edge edge : edges) {
				System.out.printf("%s, ", edge.toString());
			}
			System.out.println();
		}
	}
}
