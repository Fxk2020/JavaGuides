package xieCheng.spring;

import java.util.*;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int m1 = in.nextInt();
        int m2 = in.nextInt();

        //key是范围，value是值
        HashMap<long[], Long> row1 = new HashMap<>();
        HashMap<long[], Long> row2 = new HashMap<>();
        long cur = 0;
        for (long i = 0; i < m1; i++) {
            long u = in.nextLong();
            long c = in.nextLong();
            row1.put(new long[]{cur, cur+c-1}, u);
            cur+=c-1;
        }
        cur = 0;
        for (long i = 0; i < m2; i++) {
            long u = in.nextLong();
            long c = in.nextLong();
            row2.put(new long[]{cur, cur+c-1}, u);
            cur+=c-1;
        }

        long count = 0;
        for (long i = 0; i < n - 1; i++) {
            long start = i;
            long startRight = i+1;

            if (isTrue(start,startRight, row1, row2)){
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isTrue(long start, long startRight,
                                  HashMap<long[], Long> row1,
                                  HashMap<long[], Long> row2) {


        long num1 = 0;
        long num2 = 0;
        long num3 = 0;
        long num4 = 0;

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        for (Map.Entry<long[], Long> tmps:
             row1.entrySet()) {

            long[] tmp = tmps.getKey();
            if (start>=tmp[0]&&start<=tmp[0]){
                num1 = tmps.getValue();
                flag1 = true;
            }
            if (start>=tmp[0]&&start<=tmp[0]){
                num2 = tmps.getValue();
                flag2 = true;
            }

            if (flag1&&flag2) break;
        }

        for (Map.Entry<long[], Long> tmps:
                row2.entrySet()) {

            long[] tmp = tmps.getKey();
            if (start>=tmp[0]&&start<=tmp[0]){
                num3 = tmps.getValue();
                flag3 = true;
            }
            if (start>=tmp[0]&&start<=tmp[0]){
                num4 = tmps.getValue();
                flag4 = true;
            }

            if (flag3&&flag4) break;
        }

        LinkedHashSet<Long> hashSet =
                new LinkedHashSet<>();
        hashSet.add(num1);
        hashSet.add(num2);
        hashSet.add(num3);
        hashSet.add(num4);
        return  hashSet.size()==2;

    }


}
