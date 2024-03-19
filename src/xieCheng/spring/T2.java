package xieCheng.spring;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }

        in.close();

        Arrays.sort(nums);
        long min = nums[0];

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i]==min) continue;
            while (nums[i]>min){
                count++;
                nums[i] /= 2;
            }

            if (nums[i]<min){
                //必须把小的除以2，再次计算
                count++;
                min /= 2;
                i = 0;
            }
        }

        System.out.println(count);
    }

}
