package xieCheng;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long v0 = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();
        double res = Math.sqrt(x*y)-v0;
        double t = 0;
        if (res>0){
            t = res/x;//可以求出t
        }
        double tLast = y/(v0+x*t)+t;


        System.out.printf("%.6f%n", tLast);


    }

}
