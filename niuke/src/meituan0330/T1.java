package meituan0330;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();


        int c = getC(k, x, y);
        int a = c-x;
        int b = c+y;
        System.out.println(a+" "+b+" "+c);
    }

    private static int getC(int k, int x, int y) {

        int c = (k-y+x)/3;
        return c;

    }


}
