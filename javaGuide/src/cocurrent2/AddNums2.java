package cocurrent2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

public class AddNums2 implements Runnable {

    private int i = 0;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            addI();
        }
    }

    //synchronized关键字
    private void addI() {
        lock.lock();
        i++;
        System.out.println(Thread.currentThread().getName()+" "+i);
        lock.unlock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        AddNums2 addNums = new AddNums2();

        new Thread(addNums, "线程1").start();
        new Thread(addNums, "线程2").start();

    }
}
