package meiTuan.time0309;

import java.util.Scanner;

/**
 * 小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积末尾至少有k个 0。小美想知道，一共有多少种不同的删除方案？
 *
 * 输入描述
 *
 * 第一行输入两个正整数n，k。第二行输入n个正整数ai，代表小美拿到的数组。
 *
 * 输出描述
 *
 * 一个整数，代表删除的方案数。
 *
 */
public class T4 {

    /**
     * 计算构成0的个数，其实就是计算2和5的个数最小值。
     * 假设数组中2的个数为x，5的个数为y，构成0的个数就是min(x, y)。
     * 假设某区间2和5的个数分别为x1和y1，那么如果删除该区间，剩余2的个数为x-x1，剩余5的个数为y-y1，如
     * 果min(x-x1, y-y1) >= k，那么该区间可以删除。
     * 先计算2和5的前缀和，然后枚举可以删除的区间
     *
     *
     * @param args
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] ai = new long[n];
        //记录前缀中有几个2和5
        int[] nums2  = new int[n];
        int[] nums5 = new int[n];
        int num_2 = 0;
        int num_5 = 0;
        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextLong();
            num_2 += cal(ai[i], 2);
            num_5 += cal(ai[i], 5);
            nums2[i] = num_2;
            nums5[i] = num_5;
        }
        sc.close();

        int x = nums2[n-1];
        int y = nums5[n-1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //删除[i,j]符不符合
                int x1 = 0;
                int y1 = 0;
                if (i!=0) {
                    x1 = nums2[j] - nums2[i - 1];
                    y1 = nums5[j] - nums5[i - 1];
                }else {
                    x1 = nums2[j];
                    y1 = nums5[j];
                }
                int x2 = x - x1;
                int y2 = y - y1;
                if (Math.min(x2, y2)>=k) {
//                    System.out.println("["+ai[i]+" "+ai[j]+"]");
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    private static int cal(long num, int i) {

        int cnt = 0;
        while (num!=0){
            if (num%i==0){
                cnt++;
            }else {
                break;
            }
            num/=i;
        }
        return cnt;
    }
}
