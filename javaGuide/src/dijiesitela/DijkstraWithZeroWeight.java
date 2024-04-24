package dijiesitela;

import java.util.*;

public class DijkstraWithZeroWeight {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 2, 0},
                {1, 0, 3, 0, 0},
                {0, 3, 0, 0, 4},
                {2, 0, 0, 0, 5},
                {0, 0, 4, 5, 0}
        };

        int[] distances = dijkstra(graph, 0);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }
    }

    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minIndex = j;
                    minDistance = distances[j];
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (graph[minIndex][j] != 0 && !visited[j]) {
                    distances[j] = Math.min(distances[j], distances[minIndex] + graph[minIndex][j]);
                }
            }
        }

        return distances;
    }
}

