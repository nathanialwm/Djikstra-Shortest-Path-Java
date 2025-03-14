/**
 * Represents an edge to a destination vertex with associated weights.
 */
public class Edge {
    private String vertex;  // Destination vertex
    private int distance;   // Distance weight
    private int time;       // Time weight
    private int cost;       // Cost weight

    /**
     * Constructs an Edge with the given destination and weights.
     *
     * @param vertex   The destination vertex.
     * @param distance The distance weight.
     * @param time     The time weight.
     * @param cost     The cost weight.
     */
    public Edge(String vertex, int distance, int time, int cost) {
        this.vertex = vertex;
        this.distance = distance;
        this.time = time;
        this.cost = cost;
    }

    /**
     * Retrieves the weight based on the specified type.
     *
     * @param weightType The type of weight ("distance", "time", or "cost").
     * @return The corresponding weight value.
     * @throws IllegalArgumentException if the weight type is invalid.
     */
    public int getWeightByType(String weightType) {
        switch (weightType.toLowerCase()) {
            case "distance":
                return distance;
            case "time":
                return time;
            case "cost":
                return cost;
            default:
                throw new IllegalArgumentException("Invalid weight type: " + weightType);
        }
    }

    /**
     * Returns a string representation of the edge.
     *
     * @return A string like "B (distance: 5, time: 10, cost: 3)".
     */
    @Override
    public String toString() {
        return String.format("%s (distance: %d, time: %d, cost: %d)", vertex, distance, time, cost);
    }

    /**
     * Gets the destination vertex.
     *
     * @return The destination vertex.
     */
    public String getVertex() {
        return vertex;
    }
}
