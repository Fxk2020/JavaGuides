package elm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 迪杰斯特拉算法
 * 二维数组表示图
 */
public class T3 {

    public static int[] dijkstra(int[][] graph, int source){
        int numVertices = graph.length;
        int[] dist = new int[numVertices];
        boolean[] visited  = new boolean[numVertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            //将剩余n-1个顶点加入到dist中

            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j]&&graph[u][j]!=0&&dist[u]+graph[u][j]<dist[j]){
                    dist[j] = dist[u]+graph[u][j];
                }
            }

        }
        return dist;
    }

    private static int minDistance(int[] dist, boolean[] visited) {

        int minIndex = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]&&dist[i]<min){
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n个顶点
        int m = sc.nextInt();//m条边
        int k = sc.nextInt();//k个目的地

        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int width = sc.nextInt();
            graph[start-1][end-1] = width;
            graph[end-1][start-1] = width;
        }
        int[] dist = dijkstra(graph, 0);

        int sumDistance = 0;
        for (int i = 0; i < k; i++) {
            int node = sc.nextInt()-1;

            sumDistance+=(dist[node]*2);
        }
        sc.close();
        System.out.println(sumDistance);
    }
}
