package xieCheng.spring;

import java.util.HashMap;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        in.close();

        int count = 0;
        HashMap<Long, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
            long tmp = a[i]%k;
            if (tmp==0) count++;
            else {
                //和为k
                long k2 = k-a[i]%k;

                if (res.containsKey(k2)){
                    count++;
                    int value = res.get(k2);
                    if (--value==0){
                        res.remove(k2);
                    }else {
                        res.put(k2, value);
                    }
                }else {
                    if (res.containsKey(tmp)){
                        res.put(tmp, res.get(tmp)+1);
                    }else {
                        res.put(tmp, 1);
                    }
                }
            }
        }

        if (res.isEmpty()) System.out.println(count);
        else System.out.println(0);


    }

}
