package tainrongxin;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz{

    private static int number;
    private static int cur = 1;

    private static final Object lock = new Object();

    public FizzBuzz(int n) {
        number = n;
    }

    public void fizz() throws InterruptedException {
        while (cur<=number){
            synchronized (lock){
                while ((cur%3!=0||cur%15==0)&&cur<=number) lock.wait();
                if (cur<=number) {
                    System.out.println("fizz");
                }else return;
                cur++;
                lock.notifyAll();
            }
        }


    }          // only output "fizz"

    public void buzz() throws InterruptedException {
        while (cur<=number){
            synchronized (lock){
                while ((cur%5!=0||cur%15==0)&&cur<=number) lock.wait();
                if (cur<=number) {
                    System.out.println("buzz");
                }else return;
                cur++;
                lock.notifyAll();
            }
        }
    }          // only output "buzz"

    public void fizzbuzz() throws InterruptedException {
        while (cur<=number){
            synchronized (lock){
                while (cur%15!=0&&cur<=number) lock.wait();
                if (cur<=number) {
                    System.out.println("fizzbuzz");
                }else return;
                cur++;
                lock.notifyAll();
            }
        }
    }  // only output "fizzbuzz"

    public void number() throws InterruptedException {
        while (cur<=number){
            synchronized (lock){
                while ((cur%3==0||cur%5==0)&&cur<=number) lock.wait();
                if (cur<=number) {
                    System.out.println(cur);
                }else return;
                cur++;
                lock.notifyAll();
            }
        }
    }      // only output the numbers


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        FizzBuzz fizzBuzz = new FizzBuzz(n);

        new Thread(
                ()->{
                    try {
                        fizzBuzz.fizz();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();

        new Thread(
                ()->{
                    try {
                        fizzBuzz.buzz();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();

        new Thread(
                ()->{
                    try {
                        fizzBuzz.fizzbuzz();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();

        new Thread(
                ()->{
                    try {
                        fizzBuzz.number();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();



    }
}
