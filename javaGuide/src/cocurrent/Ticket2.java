package cocurrent;

import java.util.concurrent.*;

public class Ticket2 implements Runnable{
    private volatile static int ticket = 100;
    private boolean loop = true;


    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

    private void sell() {
        synchronized (this) {
            if (ticket == 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }

            int res = 100 - (--ticket);

            System.out.println(Thread.currentThread().getName() +
                    "卖出了第" + res + "票");
        }

    }


    public static void main(String[] args) {



        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5, 10, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(18));
        for (int i = 0; i < 28; i++) {
           Runnable worker = new Ticket2();
           System.out.println(i + " 被执行,线程名:" + Thread.currentThread().getName());
           threadPool.execute(worker);
        }

        threadPool.shutdown();
        while (!threadPool.isTerminated());
        System.out.println("售票结束，请各位等待发车！！！！！！！！");

    }
}
