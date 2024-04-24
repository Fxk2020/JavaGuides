package xieCheng.autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T4_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        long[] left = new long[number];
        long[] right = new long[number];
        ArrayList<long[]> all = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int n = in.nextInt();
            left[i] = in.nextInt();
            right[i] = in.nextInt();
            long[] tmp = new long[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = in.nextInt();
            }
            all.add(tmp);
        }

        for (int i = 0; i < number; i++) {
            long[] tmp = all.get(i);
            long l = left[i];
            long r = right[i];

            Arrays.sort(tmp);
            long max = tmp[tmp.length-1];
            long min = tmp[0];

            if (max<l||min>r) System.out.println(-1);
            else System.out.println(Math.ceil(((max-l)+(r-min))/2));

        }

    }

}
