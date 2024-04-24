package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC2 {
    private int num = 0;
    private static final Lock Lock = new ReentrantLock();

    private void printABC(String name, int targetNum){
        while (true){
            System.out.println(Thread.currentThread().getName());
            Lock.lock();
            if (num%3==targetNum){
                num++;
                System.out.println(name);
            }
            Lock.unlock();
        }


    }


    public static void main(String[] args) {
        PrintABC2 printABC = new PrintABC2();

        new Thread(
                ()-> {
                    printABC.printABC("A", 0);
                },"A--Thread"
        ).start();
        new Thread(
                ()-> {
                    printABC.printABC("B", 1);
                },"B--Thread"
        ).start();
        new Thread(
                ()-> {
                    printABC.printABC("C", 2);
                },"C--Thread"
        ).start();
    }
}
