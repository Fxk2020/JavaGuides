package xieCheng;

import java.util.Scanner;
public class T2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        String str = in.next();
        int[][] op = new int[m][2];

        for (int i = 0; i < m; i++) {
            op[i][0] = in.nextInt();
            op[i][1] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {

            int left = op[i][0];
            int right = op[i][1];

            String str1 = str.substring(0, left-1);
            String str2 = str.substring(left-1, right);
            String str3 = str.substring(right);

            String tmp = "";
            for (int j = 0; j < str2.length(); j++) {
                tmp+=str2.charAt(j);
                tmp+=str2.charAt(j);
            }

            str = str1.concat(tmp).concat(str3);
        }

        System.out.println(str);


    }

}
