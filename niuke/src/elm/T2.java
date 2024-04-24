package elm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        sc.close();

        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char tmp = str.charAt(i);
            characters.add(tmp);
        }

        Set<Character> usedChar = new HashSet<>();

        char[] res = new char[n];
        for (int i = 0; i < n; i++) {

            if (usedChar.size()!=characters.size()){
                for (char c:
                     characters) {

                    if (usedChar.contains(c)) continue;
                    if (c!=str.charAt(i)){
                        res[i] = c;
                        usedChar.add(c);
                        break;
                    }
                }
            }else {
                for (char c:
                     characters) {
                    if (c!=str.charAt(i)){
                        res[i] = c;
                        break;
                    }
                }
            }
        }

        if (usedChar.size()==0) System.out.println(-1);
        else         System.out.println(new String(res));
    }


}
