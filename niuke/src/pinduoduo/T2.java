package pinduoduo;

import java.util.*;

public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String strX = sc.next();
        String strY = sc.next();

        int[] X = new int[26];
        int[] Y = new int[26];

        for (int i = 0; i < n; i++) {
            X[strX.charAt(i)-'a']++;
            Y[strY.charAt(i)-'a']++;
        }

        HashMap<Integer, Integer> hashX = new HashMap<>();
        HashMap<Integer, Integer> hashY = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int tmp = X[i] - Y[i];
            if (tmp>0){
                hashX.put(i, tmp);
            }else if (tmp<0){
                hashY.put(i, -tmp);
            }
        }

        int sum = 0;

        Iterator<Map.Entry<Integer, Integer>> iterator = hashX.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> iterator1 = hashY.entrySet().iterator();
        List<Integer> Xlist = new ArrayList<>();
        List<Integer> Ylist = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            for (int i = 0; i < entry.getValue(); i++) {
                Xlist.add(entry.getKey());
            }
        }
        while (iterator1.hasNext()){
            Map.Entry<Integer, Integer> entry1 = iterator1.next();
            for (int i = 0; i < entry1.getValue(); i++) {
                Ylist.add(entry1.getKey());
            }
        }
        for (int i = 0; i < Xlist.size(); i++) {
            sum += Math.abs(Xlist.get(i)-Ylist.get(i));
        }

        System.out.println(sum);
    }


}
