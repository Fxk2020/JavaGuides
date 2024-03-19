package xieCheng.spring;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String number = in.next();

        int n = number.length();
        int end = number.charAt(n-1)-'0';
        int count = 0;
        for (int i = 0; i < number.length()-1; i++) {
            int start = number.charAt(i)-'0';
            if ((start+end)%2==0) count++;
        }
        System.out.println(count);
    }


}
