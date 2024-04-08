package elm;

import java.util.*;

/**
 * 迪杰斯特拉
 * 链表实现图
 */
public class T3_2 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n个顶点
        int m = sc.nextInt();//m条边
        int k = sc.nextInt();//k个目的地

        List<List<int[]>> graph = new ArrayList<>();
        //初始化
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int width = sc.nextInt();
            graph.get(start-1).add(new int[]{end-1, width});
            graph.get(end-1).add(new int[]{start-1, width});
        }
        int[] dist = dijkstra(graph, 0);

        int[] nodes = new int[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = sc.nextInt();
        }

        long sumDistance = 0;
        for (int node:
             nodes) {
            sumDistance += dist[node-1]*2;
        }
        sc.close();
        System.out.println(sumDistance);
    }

    private static int[] dijkstra(List<List<int[]>> graph, int source) {
        int numsNode = graph.size();
        int[] dist = new int[numsNode];
        boolean[] visited = new boolean[numsNode];

        Arrays.fill(dist, Integer.MAX_VALUE);//设置不可到达
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);//根据数组第一个值排序的最小堆,存储着有序的到source的距离
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()){
            int[] arr = pq.poll();
            int u = arr[1];
            if (visited[u]) continue;
            visited[u] = true;
            for (int[] edge:
                    graph.get(u)) {
                int v = edge[0];
                int width = edge[1];
                if (dist[u]+width<dist[v]){
                    dist[v] = dist[u]+width;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        return dist;
    }

}
