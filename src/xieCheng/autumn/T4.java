package xieCheng.autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        long[] left = new long[number];
        long[] right = new long[number];
        ArrayList<long[]> all = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int n = in.nextInt();
            left[i] = in.nextInt();
            right[i] = in.nextInt();
            long[] tmp = new long[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = in.nextInt();
            }
            all.add(tmp);
        }

        long[] res = new long[number];//记录结果
        for (int i = 0; i < number; i++) {
            long l = left[i];
            long r = right[i];
            long[] test = all.get(i);
            Arrays.sort(test);

            if (test[test.length-1]<l) {
                res[i] = -1;
            }else if (test[0]>r){
                res[i] = -1;
            }else {
                long jianNumber = 0;
                long addNumber = 0;

                long canJian = 0;
                long canAdd = 0;

                for (int j = 0; j < test.length; j++) {
                    if (test[j]<l){
                        addNumber+=(l-test[j]);
                        canAdd+=r-test[j];
                    }
                    if (test[j]>r){
                        jianNumber+=(test[j]-r);
                        canJian+=test[j]-l;
                    }
                    else {
                        //已经在区间里的不能出去
                        canAdd += (r-test[j])+r-l;
                        canJian += (test[j]-l)+r-l;
                    }
                }

                if (addNumber==jianNumber){
                    res[i] = addNumber;
                    continue;
                }
                if (addNumber>jianNumber){
                    if (canJian>=addNumber-jianNumber){
                        res[i] = addNumber;
                    }else {
                        res[i]=-1;
                    }
                }else {
                    if (canAdd>=jianNumber-addNumber){
                        res[i] = jianNumber;
                    }else {
                        res[i]=-1;
                    }
                }

            }

        }

        for (int i = 0; i < number; i++) {
            System.out.println(res[i]);
        }

    }

}
