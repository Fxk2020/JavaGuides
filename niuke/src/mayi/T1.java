package mayi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 众所周知，在一些消费支付的场合中，往往有“支付宝九五折”的优惠。
 *
 * 这天小苯来到了超市购买物品，一共有 n种物品，每种物品只能购买一个，
 * 但有的物品支持优惠活动，有的并不支持。
 * 恰好本超市的结账是有“支付宝九五折”优惠的，小苯的支付宝余额还剩k元，他想知道他仅使用支付宝进行支付的话，最多能买几件物品？
 */
public class T1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        double[] ai = new double[n];
        boolean[] flags = new boolean[n];

        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextInt();
        }
        String str = sc.next();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i)=='1'){
                flags[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (flags[i]){
                ai[i] = ai[i]*0.95;
            }
        }
        Arrays.sort(ai);

        double sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {

            sum+=ai[i];
            if (sum>k)break;

            count++;

        }

        System.out.println(count);


    }



}
