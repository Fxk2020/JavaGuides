package meiTuan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        String t = in.next();
        char[] s2 = s.toCharArray();
        char[] t2 = t.toCharArray();

        int number = 0;
        for (int i = 0; i < n; i++) {

            if (s.charAt(i)==t.charAt(i)) {
                number++;
                s2[i] = ' ';
                t2[i] = ' ';
            }
        }

        String s3 = "";
        String t3 = "";
        for (int i = 0; i < n; i++) {
            if (s2[i]!=' '){
                s3 += s2[i];
                t3 += t2[i];
            }
        }

        int m = s3.length();
        int addNumber = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (s3.charAt(i)==t3.charAt(j)){
                    addNumber = 1;
                    if (t3.charAt(i)==s3.charAt(j)) {
                        System.out.println(number+2);
                        return;
                    }
                }
            }
        }
        System.out.println(number+addNumber);
    }

}
