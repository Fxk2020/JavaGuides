package pinduoduo0324;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        String aStr = sc.next();
        String bStr = sc.next();

        Set<String> resStr = new HashSet<>();
        for (int i = 0; i < m - n; i++) {
            String subA = aStr.substring(i, i+n);
            String res = yihuo(bStr, subA);
            if (isZero(res)){
                resStr.add(res);
            }
        }

        System.out.println(resStr.size());

    }

    private static boolean isZero(String res) {
        int resNum = 0;
        for (int i = 0; i < res.length(); i++) {
            resNum ^= Integer.parseInt(String.valueOf(res.charAt(i)));
        }
        return resNum==0;
    }

    private static String yihuo(String bStr, String subA) {

        String res = "";
        for (int i = 0; i < bStr.length(); i++) {
            res = res.concat(String.valueOf(Integer.parseInt(String.valueOf(bStr.charAt(i)))^Integer.parseInt(String.valueOf(subA.charAt(i)))));
        }
        return res;
    }
}
