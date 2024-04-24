package meiTuan.time0309;

import java.util.Map;
import java.util.Scanner;

/**
 * 小美拿到了一个n*n 的矩阵，其中每个元素是 0 或者 1。
 *小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
 *现在，小美希望你回答有多少个i*i的完美矩形区域。你需要回答1<=i<=n的所有答案。
 *
 * 输入描述
 *
 * 第一行输入一个正整数n，代表矩阵大小。
 *
 * 接下来的n行，每行输入一个长度为n的01 串，用来表示矩阵。
 *
 * 输出描述
 *
 * 输出n行，第i行输出的I*I 完美矩形区域的数量。
 */
public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arrays = new int[n][n];


        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                arrays[i][j] = tmp.charAt(j)-'0';
            }
        }
        sc.close();


        for (int i = 1; i <= n; i++) {
            if (i%2!=0){
                System.out.println(0);
            }else {
                int[] start = new int[]{0,0};
                int res = 0;

                while ((start[0]+i)<=n){
                    int sum = 0;
                    for (int j = start[0]; j < start[0]+i; j++) {
                        for (int k = start[1]; k < start[1]+i; k++) {
                            sum+=arrays[j][k];
                        }
                    }
                    if (sum==(Math.pow(i,2) /2)) res++;
                    start[0]++;
                    if ((start[0]+i)>n){
                        //从下一列从头开始
                        if (start[1]+i<n){
                            start[1]++;
                            start[0]=0;
                        }
                    }
                }
                System.out.println(res);
            }
        }


    }

}
