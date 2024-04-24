package cocurrent2;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {
    // 创建一个 ThreadLocal 对象，用于保存每个线程的计数器
    private static final ThreadLocal<AtomicInteger> threadLocalCounter = ThreadLocal.withInitial(AtomicInteger::new);

    // 线程执行的任务
    static class Task implements Runnable {
        @Override
        public void run() {
            // 获取当前线程的计数器
            AtomicInteger counter = threadLocalCounter.get();
            // 增加计数器的值
            counter.incrementAndGet();
            // 输出当前线程的计数器值
            System.out.println("Thread " + Thread.currentThread().getId() + " counter: " + counter.get());
        }
    }

    public static void main(String[] args) {
        // 创建多个线程执行任务
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }
}

