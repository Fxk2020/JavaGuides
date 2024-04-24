package xieCheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            in.nextToken();
            array[i] = (int) in.nval;
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
