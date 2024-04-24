package cocurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileAtomicityDemo {

    public volatile static int inc = 0;
    private Lock lock = new ReentrantLock();

//    public void increase() {
//        inc++;
//    }

//    public synchronized void increase() {
//        inc++;
//    }

    public void increase() {
        lock.lock();
        try {
            inc++;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
