package tainrongxin;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzz implements Runnable{

    private int number;
    public FizzBuzz(int n) {
        number = n;
    }

    public void fizz() {
        System.out.println("fizz");
    }          // only output "fizz"

    public void buzz() {
        System.out.println("buzz");
    }          // only output "buzz"

    public void fizzbuzz() {
        System.out.println("fizzbuzz");
    }  // only output "fizzbuzz"

    public void number() {
        System.out.println(number);
    }      // only output the numbers


    @Override
    public void run() {
        if (number%3==0&&number%5==0) fizzbuzz();
        else {
            if (number%3==0) fizz();
            else if (number%5==0) buzz();
            else number();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(n);
        for (int num:
             nums) {
            executorService.submit(new FizzBuzz(num));
            Thread.sleep(1);
        }
        executorService.shutdown();

    }
}
