package java1;

import java.util.*;

public class Set {


    public static void main(String[] args) {

        Integer[] a = {4,54,454,545,45,45,45,45,4,54,54,5,};
//        ArrayList<Integer> list = new ArrayList<>(a.length);
//        Collections.addAll(list, a);
//        System.out.println(new HashSet<Integer>(list));

//        String[] a = new String[]{"adfas","dasfa"};
//        List<String> list = Arrays.asList(a);
//        Collections.reverse(list);
//        a = list.toArray(new String[0]);
//        for (String s:
//             a) {
//            System.out.println(s);
//        }
        List<Integer> list = Arrays.asList(a);
        System.out.println(list.get(1));
//        list.remove(1);
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        arrayList.remove(1);
        System.out.println(arrayList.get(1));


    }

}
