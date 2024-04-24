package xieCheng.time0313;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 游游拿到了一个数组，她每次操作可以任选一个元素加 1 或者减 1。游游想知道，
 * 将所有元素都变成和ai相等需要操作最少多少次？你需要回答i∈[1,n]的结果。
 *
 * 输入描述
 *
 * 第一行输入一个正整数n，代表数组的大小。第二行输入n个正整数ai，代表数组的元素。
 *
 * 输出描述
 *
 * 输出n行，分别代表i∈[1,n]的结果。
 */
public class T2 {

    /**
     * 思路还是前缀和
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ai = new long[n];
        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextLong();
        }
        sc.close();

        long[] nums = ai.clone();
        Arrays.sort(ai);
        //求前缀和
        long[] pres = new long[n];
        pres[0] = ai[0];
        for (int i = 1; i < n; i++) {
            pres[i] = ai[i]+pres[i-1];
        }

        HashMap<Long, Long> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long count = 0;
            if (i==0){
                count = pres[n-1]-pres[0]-(n-1)*ai[0];
            }else {
                long left = i*ai[i]-pres[i-1];
                long right = pres[n-1]-pres[i]-(n-i-1)*ai[i];
                count = left+right;
            }
            res.put(ai[i], count);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res.get(nums[i]));
        }
    }
}
