package xieCheng;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = i; j < n-1; j++) {
                if (Math.abs(array[j]-array[j+1])<=1) {
                    tmp++;
                    maxLength = Math.max(maxLength, tmp);
                }
                else {
                    i = j;//j和j+1不符合那么j+1之前的长度不可能有超过i起始
                    break;
                }
                if (tmp==n) {
                    System.out.println(n);
                    return;
                }
            }
        }

        System.out.println(maxLength);
    }


}
