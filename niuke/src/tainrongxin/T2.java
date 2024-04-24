package tainrongxin;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ai = new int[n];
        for (int i = 0; i < n; i++) {
            ai[i]= sc.nextInt();
        }
        int m = sc.nextInt();
        int[] bi = new int[m];
        for (int i = 0; i < m; i++) {
            bi[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][m+1];//a以i结尾，b以j结尾的最大公共长度
        int maxLength = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ai[i-1]==bi[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        if (maxLength==-1) System.out.println(0);
        else System.out.println(maxLength);

    }
}
