package cocurrent2;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如何使自增操作变为原子的
 * 1.synchronized
 * 2.AtomicInteger
 * 3.ReentrantLock
 */
public class AddNums implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            addI();
        }
    }

    //synchronized关键字
    private void addI() {
        i.addAndGet(1);
        System.out.println(Thread.currentThread().getName()+" "+i);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        AddNums addNums = new AddNums();

        new Thread(addNums, "线程1").start();
        new Thread(addNums, "线程2").start();

    }
}
