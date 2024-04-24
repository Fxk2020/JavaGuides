package mayi;

import java.util.Scanner;

/**
 * 小红定义一个字符串的权值是：字符串辅音数量和元音数量的差的绝对值。
 *
 * 例如，"arcaea"的权值是 2，因为有 4 个元音，2 个辅音，权值为|4-2|=2。
 *
 * 现在小红拿到了一个字符串，她想把这个字符串切成两个非空字符串，需要满足两个字符串的权值相等。小红想知道，有多少种不同的切割方式？
 *
 * 我们定义，元音有"aeiou"这五种，其余字母均为辅音。
 */
public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int[] pre = new int[n+1];//前缀和，不包含自己
        int sum = 0;
        pre[0] = sum;
        for (int i = 1; i <= n; i++) {
            if (isYuan(str.charAt(i-1))){
                sum++;
            }else {
                sum--;
            }
            pre[i] = sum;
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            int left = Math.abs(pre[i]);
            int right = Math.abs(pre[n]-pre[i]);
            if (left==right) count++;
        }
        System.out.println(count);
    }

    private static boolean isYuan(char c) {

        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
