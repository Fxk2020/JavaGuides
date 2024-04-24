package meiTuan.time0309;

import java.util.Scanner;

/**
 * 小美拿到了一个由正整数组成的数组，但其中有一些元素是未知的（用 0 来表示）。
 *现在小美想知道，如果那些未知的元素在区间[l,r]范围内随机取值的话，数组所有元素之和的最小值和最大值分别是多少？
 *共有q次询问。
 *
 * 输入描述
 *
 * 第一行输入两个正整数n,q，代表数组大小和询问次数。
 *
 * 第二行输入n个整数ai，其中如果输入ai的为 0，那么说明ai是未知的。
 *
 * 接下来的q行，每行输入两个正整数l,r，代表一次询问。
 *
 *
 *
 * 输出描述
 *
 * 输出q行，每行输出两个正整数，代表所有元素之和的最小值和最大值。
 */
public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        long[] left = new long[q];
        long[] right = new long[q];
        for (int i = 0; i < q; i++) {
            left[i] = sc.nextLong();
            right[i] = sc.nextLong();
        }
        sc.close();


        long sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]==0) count++;
            else sum+=nums[i];
        }
        for (int i = 0; i < q; i++) {
            System.out.print(sum+left[i]*count);
            System.out.print(" ");
            System.out.println(sum+right[i]*count);
        }
    }

}
