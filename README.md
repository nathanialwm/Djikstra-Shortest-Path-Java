# Dijkstra's Shortest Path Algorithm

This is a console-based Java project that creates 3 graphs containing itself and a list of neighbors.

When designating a start and end position on one of the graphs the program runs Dijkstra's algorithm to find and return the shortest path.

The format of these graphs is to represent something like a transit route

## Table of Contents

- [Tech Stack](#tech-stack)
- [Preview](#preview)
- [How It Works](#how-it-works)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)
- [Contact](#contact)

## Tech Stack

 - **Java**: Scripting Language

## Preview

```java
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
```

## How It Works

Dijkstra's algorithm checks each neighbor and prioritizs the lowest weighted path. It will not explore an edge/node on another path until moving to that path costs less then the total cost of the current path


## Installation

Clone the repository

```bash
git clone https://github.com/nathanialwm/AutoBattle-RPG.git
```

Make sure you have a compatable jre or jvm

## Usage

Run Main.java in a code editor

## License

Unlicensed

## Contact

Nathanial Martin @ [Linkedin](https://www.linkedin.com/in/nathanialm/)
