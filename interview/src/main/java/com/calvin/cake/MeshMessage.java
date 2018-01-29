package com.calvin.cake;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * Constant weight dijsktra algo
 * @author Calvin
 *
 */
public class MeshMessage {
	public static class PathWeight {
		String node;
		int weightFromSource;
		String previousNode;
		PathWeight(String node, int weight, String prev){
			this.node = node;
			this.weightFromSource = weight;
			this.previousNode = prev;
		}
		static PathWeight of(String node, int weight, String prev){
			return new PathWeight(node, weight, prev);
		}
	}
	
	/**
	 * Since there is no weight for this graph, we can use BFS to find least steps from source to dest
	 * @param network
	 * @param from
	 * @param to
	 * @return
	 */
	public static void findPathBfs(Map<String, String[]> network, String start, String end){
		Queue<String> queue = new ArrayDeque<String>(network.size());
		
		// Find start
		// Create something to say that a node has been visited
		// Create something to track the path
		HashMap<String, String> paths = new HashMap<>();
		
		queue.add(start);
		paths.put(start, null);
		while (!queue.isEmpty()){
			String current = queue.poll();

			if (current.compareTo(end) == 0){
				// Found end
				break;
			}

			for (String neighbor : network.get(current)){
				if (!paths.containsKey(neighbor)){
					paths.put(neighbor, current);
					queue.add(neighbor);
				}
			}
		}

		while (end != null){
			System.out.println(end);
			end = paths.get(end);
		}
	}
	
	public static List<String> findPath(Map<String, String[]> network, String from, String to){
		// Shortest path - Dijkstra
		// Assign a weight to each node
		// Create an array to hold weight at N and previous node to N
		
		// We can use heap to hold paths
		HashMap<String, PathWeight> paths = new HashMap<>();
		HashSet<String> visited = new HashSet<>(network.size());
		HashSet<String> notVisited = new HashSet<>(network.size());
		
		// Find the source node
		// Build a data structure to hold
		// [node] = { weight to source, previous node }
		for (Entry<String, String[]> entry : network.entrySet()){
			notVisited.add(entry.getKey());
			String key = entry.getKey();
			if (key.compareTo(from) == 0){
				paths.put(key, PathWeight.of(key, 0, key));
			}
			else{
				paths.put(key, PathWeight.of(key, Integer.MAX_VALUE, null));
			}
		}
		
		while (!notVisited.isEmpty()){
			// Find one with lowest weight
			PathWeight current = null;
			for (PathWeight path : paths.values()){
				if (visited.contains(path.node)){
					continue;
				}
				if (current == null){
					current = path;
				}
				else if (path.weightFromSource < current.weightFromSource){
					current = path;
				}
			}
			
			String[] neighbors = network.get(current.node);
			for (String neighbor : neighbors){
				// Update weights for each nonVisited neighbor
				if (!visited.contains(neighbor)){
					PathWeight pathWeight = paths.get(neighbor);
					if (current.weightFromSource + 1 < pathWeight.weightFromSource){
						pathWeight.weightFromSource = current.weightFromSource + 1;
						pathWeight.previousNode = current.node;						
					}
				}
			}
			
			visited.add(current.node);
			notVisited.remove(current.node);
		}

		List<String> result = new LinkedList<String>();
		while (to.compareTo(from) != 0){
			PathWeight removed = paths.remove(to);
			if (removed == null){
				throw new RuntimeException("Something is wrong");
			}
			result.add(0, removed.node);
			to = removed.previousNode;
		}
		result.add(0, from);
		return result;
	}
}
