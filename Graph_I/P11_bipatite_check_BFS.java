package Graph_I;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1); // Initialize all nodes as uncolored

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!bfsCheck(graph, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int[][] graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // Add the start node to the queue
        colors[start] = 0; // Color the start node with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == -1) { // If the neighbor is not colored
                    colors[neighbor] = 1 - colors[node]; // Color with alternate color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) { // If the neighbor has the same color
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph1)); // Output: true

        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(isBipartite(graph2)); // Output: false
    }
}
