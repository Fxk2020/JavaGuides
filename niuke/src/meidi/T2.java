package meidi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        char[] strs = str.toCharArray();

        char[][] res = new char[n][strs.length];
        List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        int row = 0;
        boolean flag = true;//正向
        for (char c:
             strs)  {
            result.get(row).add(c);
            if (flag) {
                row++;
                if (row>=n){
                    flag=false;
                    row-=2;
                }
            }else {
                row--;
                if (row<=-1){
                    flag=true;
                    row+=2;
                }
            }
        }
        String str1 = "";
        for (List<Character> r:
             result) {


            for (Character c:
                 r) {
                str1 = str1.concat(String.valueOf(c));
            }
        }

        System.out.println(str1);

    }


}
