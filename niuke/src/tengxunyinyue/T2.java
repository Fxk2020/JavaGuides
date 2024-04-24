package tengxunyinyue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T2 {
    public int getMethods (int[] a) {

        Set<List<Integer>> res = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[a.length];

        backtracking(a, 0, used, path, res);
        return res.size();
    }

    private void backtracking(int[] a, int start, boolean[] used, List<Integer> path, Set<List<Integer>> res) {

        if (start==a.length){
            if (path.size()==a.length){
                res.add(new ArrayList<>(path));
            }

            System.out.println(path);
            return;
        }

        Set<Integer> dup = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (!used[i]&&(path.isEmpty()||isPrime(path.get(path.size()-1)+a[i]))&&!dup.contains(a[i])){
                dup.add(a[i]);
                used[i]=true;
                path.add(a[i]);

                backtracking(a, start+1,used,path, res);
                used[i]=false;
                path.remove(path.size()-1);
            }

        }
    }

    private boolean isPrime(int num) {

        if (num<=1) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num%i==0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new T2().getMethods(new int[]{1,1,2}));
    }
}
