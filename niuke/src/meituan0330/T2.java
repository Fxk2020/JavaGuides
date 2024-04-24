package meituan0330;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ai = new long[n];
        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextLong();
        }
        long max = getMax(ai);

        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            if (2*ai[i]>max) res[i]=2*ai[i];
            else res[i] = max;
        }

        for (long result:
             res) {
            System.out.print(result+" ");
        }

    }

    private static long getMax(long[] ai) {

        long max = Long.MIN_VALUE;
        for (long a:
             ai) {
            if (a>max) max = a;
        }
        return max;
    }


}
