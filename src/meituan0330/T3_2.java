package meituan0330;

import java.util.Scanner;

public class T3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int n = str1.length();

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        int index = compareStrs(char1, char2, n-1);
        boolean flag = true;
        int idx1 = index;
        while (idx1>0){
            if (char1[--idx1]!=char1[index]) {
                flag =false;
                break;
            }
        }
        if (flag){
            System.out.println(1);
            System.out.println(2+" "+(index+1)+" "+char1[index]);
            return;
        }

        flag = true;
        int idx2 = index;
        while (idx2>0){
            if (char2[--idx2]!=char2[index]) {
                flag =false;
                break;
            }
        }
        if (flag){
            System.out.println(1);
            System.out.println(1+" "+(index+1)+" "+char2[index]);
            return;
        }

        System.out.println(2);
        System.out.println(1+" "+str1.length()+" "+str1.charAt(n-1));
        System.out.println(2+" "+str2.length()+" "+str1.charAt(n-1));
    }

    private static int compareStrs(char[] char1, char[] char2, int n) {
        int i;
        for ( i = n; i >= 0 ; i--) {
            if (char1[i]!=char2[i]) break;
        }
        return Math.max(i, 0);
    }


}
