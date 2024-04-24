package concurrent;

import java.util.concurrent.locks.*;

public class PrintOut {

    //可重入锁
    private static final Lock lock = new ReentrantLock();
    //state表示该那个线程执行
    private static int state = 0;
    // 三个条件对象，分别绑定A、B、C三个线程
    private static final Condition A = lock.newCondition();//锁的信号量
    private static final Condition B = lock.newCondition();
    private static final Condition C = lock.newCondition();

    static class PrintA extends Thread{

        @Override
        public void run() {
            while (true){
                lock.lock();
                try{
                    try{
                        while (state%3!=0) A.await();//await等待时释放锁
                        System.out.println("A");
                        state++;
                        B.signal();
                    }finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    static class PrintB extends Thread{

        @Override
        public void run() {
            while (true){
                lock.lock();
                try{
                    try{
                        while (state%3!=1) B.await();
                        System.out.println("B");
                        state++;
                        C.signal();
                    }finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    static class PrintC extends Thread{

        @Override
        public void run() {
            while (true){
                lock.lock();
                try{
                    try{
                        while (state%3!=2) C.await();
                        System.out.println("C");
                        state++;
                        A.signal();
                    }finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }




    public static void main(String[] args) throws InterruptedException {
        //启动三个线程
        PrintA a = new PrintA();
        a.start();

        PrintB b = new PrintB();
        b.start();

        PrintC c = new PrintC();
        c.start();
    }

}
