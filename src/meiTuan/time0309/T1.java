package meiTuan.time0309;

import java.util.Scanner;

/**
 *现在小美拿到了一个仅由大写字母组成字符串，她可以最多操作k次，每次可以修改任意一个字符。小美想知道，操作结束后最多共有多少个'M'和'T'字符？
 *
 *输入描述
 *
 * 第一行输入两个正整数，代表字符串长度和操作次数。第二行输入一个长度为的、仅由大写字母组成的字符串。1<=k<=n<=10^5
 *
 * 输出描述
 *
 * 输出操作结束后最多共有多少个'M'和'T'字符。
 *
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        sc.close();

        int count = 0;
        for (int i = 0; i < n; i++) {
            char tmp = str.charAt(i);
            if (tmp=='M'||tmp=='T'){
                count++;
            }
        }

        int shengyu = n-count;
        if (k>=shengyu){
            System.out.println(n);
        }else {
            System.out.println(count+k);
        }

    }


}
