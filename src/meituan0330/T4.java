package meituan0330;

import java.util.*;

public class T4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        List<String> res = new ArrayList<>();
        generateSubsets(str, 0, "", res);

        long count = res.size();
        if (count>Math.pow(10,9))
            System.out.println(count%(Math.pow(10,9)+7));
        else
            System.out.println(count);
    }

    private static void generateSubsets(String str, int index, String s, List<String> res) {
        if (s.length()!=0&&isBalance(s)){
            System.out.println(s);
            res.add(s);
        }

        for (int i = index; i < str.length(); i++) {
            generateSubsets(str, i+1,s.concat(String.valueOf(str.charAt(i))), res);
        }

    }

    private static boolean isBalance(String s) {

        if (s.length()%2!=0) return false;
        char[] chars = new char[2];
        int[] res = new int[2];
        chars[0] = s.charAt(0);
        chars[1] = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=chars[0]) {
                chars[1] = s.charAt(i);
                break;
            }
        }
        if (chars[0]==chars[1]) return false;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp==chars[0]){
                res[0]++;
            } else if (tmp==chars[1]) {
                res[1]++;
            } else {
                return false;
            }
        }
        return res[1]==res[0];
//        HashMap<Character, Integer> res = new HashMap<>();
//        for (int i = 0; i < s.length()&&res.size()<=2; i++) {
//            char tmp = s.charAt(i);
//            if (res.containsKey(tmp)) res.put(tmp, res.get(tmp)+1);
//            else res.put(tmp, 1);
//        }
//        if (res.size()!=2) return false;
//
//        Set<Map.Entry<Character, Integer>> entries = res.entrySet();
//        int[] count = new int[2];
//        int index = 0;
//        for (Map.Entry<Character, Integer> entry:
//             entries) {
//            count[index++] = entry.getValue();
//        }
//        return count[0]==count[1];
    }


}
