package xieCheng.autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        List<List<Integer>> ress = permute(nums);

        int count = 0;
        for (List<Integer> res:
             ress) {
            if(isTrue(res)){
                count++;
//                System.out.println(res);
            }
        }

        System.out.println(count);

    }

    private static boolean isTrue(List<Integer> res) {

        //判断是否和都不是素数
        for (int i = 0; i < res.size() - 1; i++) {
            if (isPrime(res.get(i)+res.get(i+1))){
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int i) {
        //是素数

        if (i<2){
            return false;
        }else {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j==0)return false;
            }
        }
        return true;
    }

    private static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    private static void backtrack(ArrayList<Integer> status, int[] nums, boolean[] choices, List<List<Integer>> res) {

        if (status.size()==nums.length) {
            res.add(new ArrayList<>(status));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!choices[i]){
                status.add(nums[i]);
                choices[i]=true;
                backtrack(status, nums, choices, res);
                choices[i]=false;
                status.remove(status.size()-1);
            }
        }
    }


}
