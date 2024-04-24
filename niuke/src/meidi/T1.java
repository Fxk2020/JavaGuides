package meidi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 */

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] nums = str.split(",");
        int n = nums.length;

        long[] nums2 = new long[n];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = Integer.parseInt(nums[i]);
        }

        HashSet<Long> res = new HashSet<>();
        for (long num:
             nums2) {
            if (res.isEmpty()){
                res.add(num);
            }else {
                if (res.contains(num)) {
                    System.out.println("true");
                    return;
                }
            }
        }

        System.out.println("false");

    }


}
