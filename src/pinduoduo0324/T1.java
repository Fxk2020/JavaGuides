package pinduoduo0324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();

            int[] tmp = new int[n];
            long[] pre = new long[n+1];//前缀和,不包含自己
            for (int j = 0; j < n; j++) {
                tmp[j] = sc.nextInt();
            }
            Arrays.sort(tmp);
            pre[0] = 0;
            for (int j = 0; j < n; j++) {
                pre[j+1] = pre[j]+tmp[j];
            }

            long res = Long.MIN_VALUE;
            for (int j = 0; j <= d; j++) {
                long fu1 = (pre[n - j] - pre[n - m - j]) * (-k);
                res = Math.max(res, pre[n-m-j]+fu1);
            }
            results.add(res);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
