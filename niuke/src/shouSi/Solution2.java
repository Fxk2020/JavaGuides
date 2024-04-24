package shouSi;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution2 implements Runnable{

    private static int i =0;
    public int getI() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5, 100, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(18));

        for (int i = 0; i < 2; i++) {
            Runnable work = new Solution2();
            threadPool.execute(work);

        }

        threadPool.shutdown();
        System.out.println("调用awaitTermination之前："+threadPool.isTerminated());
        // 个人理解：如果service进行了shutdown操作，就查看子线程是否全部完成（也就是调用此方法），其中的参数相当于超时时间
        threadPool.awaitTermination(1,TimeUnit.HOURS);
        System.out.println("调用awaitTermination之后："+threadPool.isTerminated());
        if (threadPool.isTerminated()) {
            System.out.println("子线程执行完毕");
            System.out.println("主线程开始");
        }
    }

    @Override
    public void run() {
        int tmp = 0;
        while (tmp++<100){
            addI();
        }

    }

    private synchronized void addI()  {
        i=i+1;
        System.out.println(i);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
