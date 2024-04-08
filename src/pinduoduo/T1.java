package pinduoduo;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n>45) System.out.println(-1);
        else {
            if (n<10) System.out.println(n);
            else {
                System.out.println(findSmallestNumber(n));
            }
        }

    }

    private static int findSmallestNumber(int n) {

        int num = 19;
        while (true){
            int digitSum = calDigSum(num);
            if (digitSum==n&&hasUnique(num)){
                return num;
            }
            num++;
        }
    }

    private static boolean hasUnique(int num) {

        boolean[] flags = new boolean[10];
        while (num>0){
            int tmp = num%10;
            if (flags[tmp]){
                return false;
            }
            flags[tmp] = true;
            num/=10;
        }
        return true;
    }

    private static int calDigSum(int num) {

        int sum = 0;
        while (num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
