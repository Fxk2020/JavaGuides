package meituan0330;

import java.util.Scanner;

public class T4_2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();


        long count = generateSub(str);
        if (count>Math.pow(10,9))
            System.out.println(count%(Math.pow(10,9)+7));
        else
            System.out.println(count);
    }

    private static long generateSub(String str) {

        int n = str.length();
        int[][] dp = new int[n][n+1];

        for (int j = 0; j < n; j++) {
            dp[j][1] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i+len-1;
                if (j>=n){
                    break;
                }

            }
        }


        return 0;


    }
}
