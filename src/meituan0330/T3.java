package meituan0330;

import java.util.ArrayList;
import java.util.Scanner;

public class T3 {

//    static ArrayList<Integer> howStr = new ArrayList<>();
    static ArrayList<Integer> whereEnd = new ArrayList<>();
    static ArrayList<Character> whatChar = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        int m = getCAC(char1, char2, str1.length()-1);

        System.out.println(m);
        for (int i = 0; i < m; i++) {
            System.out.print(2+" "+whereEnd.get(i)+" "+whatChar.get(i));
            System.out.println();
        }
    }

    private static int getCAC(char[] str1, char[] str2, int end) {

        int res = 0;
        for (int i = end; i >= 0; i--) {
            if (str1[i]!=str2[i]){
                for (int j = 0; j <= i; j++) {
                    str2[j] = str1[i];
                }
                whereEnd.add(i+1);
                whatChar.add(str1[i]);
                res++;
            }
        }
        return res;
    }


}
