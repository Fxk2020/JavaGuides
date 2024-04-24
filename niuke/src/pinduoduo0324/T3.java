package pinduoduo0324;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> edge = new ArrayList<>();
        List<List<Integer>> canToNodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            edge.get(start).add(end);
        }
        for (int i = 0; i <= n; i++) {
            canToNodes.add(new ArrayList<>(getCanToNodes(i, edge)));
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            List<Integer> nodes = canToNodes.get(i);
            for (int j = 1; j <= n; j++) {

                if (j==i||nodes.contains(j)) continue;
                else {
                    if (canToNodes.get(j).contains(i))continue;
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) res++;
        }
        System.out.println(res);
    }

    private static List<Integer> getCanToNodes(int start, List<List<Integer>> edge) {
        List<Integer> res = new ArrayList<>(edge.get(start));
        if (edge.get(start).size()==0){
            return res;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(edge.get(start));

        while (!priorityQueue.isEmpty()){
            int node = priorityQueue.poll();
            for (int ns:
                 edge.get(node)) {
                if (!priorityQueue.contains(ns)){
                    priorityQueue.add(ns);
                    res.add(ns);
                }
            }

        }

        return res;
    }


}
